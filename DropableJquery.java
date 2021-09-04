package Week4Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropableJquery {
	public static void main(String[] args)  {
		
		
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://jqueryui.com/droppable");
		 String title=driver.getTitle();
		 System.out.println(title);
		 driver.manage().window().maximize();
		 
		 WebElement findElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		 driver.switchTo().frame(findElement);
		 
		 Actions builder = new Actions(driver);
			WebElement source = driver.findElement(By.id("draggable"));
			WebElement target = driver.findElement(By.id("droppable"));
			builder.dragAndDrop(source,target).perform();
			//driver.quit();
}
}
