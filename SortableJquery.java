package Week4Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableJquery {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://jqueryui.com/sortable");
			 String title=driver.getTitle();
		 System.out.println(title);
		 driver.manage().window().maximize();
		 
		 WebElement findElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		 driver.switchTo().frame(findElement);
		 
			WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']//li[1]"));
			WebElement item5 = driver.findElement(By.xpath("//ul[@id='sortable']//li[6]"));
			Point location1 = item5.getLocation(); 
			
			
			int x = location1.getX();
			int y = location1.getY();
			
			Actions builder = new Actions(driver);
			builder.dragAndDropBy(item1,x, y).perform();
		 
		 
}
}
