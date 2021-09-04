package Week4Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/pages/sortable.html");
			 String title=driver.getTitle();
		 System.out.println(title);
		 driver.manage().window().maximize();
		   //driver.switchTo().frame(0);
			 
			WebElement item1 = driver.findElement(By.xpath("//div[@id='mydiv'][1]//li[1]"));
			WebElement item5 = driver.findElement(By.xpath("//div[@id='mydiv'][1]//li[5]"));
			Point location1 = item5.getLocation(); 
			
			
			int x = location1.getX();
			int y = location1.getY();
			
			Actions builder = new Actions(driver);
			builder.dragAndDropBy(item1,x, y).perform();
			
			System.out.println("success");
	}
	
}
