package Week4Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {
	public static void main(String[] args) {
		
	
	WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("http://www.leafground.com/pages/drag.html");
		 String title=driver.getTitle();
	 System.out.println(title);
	 driver.manage().window().maximize();
	WebElement drag = driver.findElement(By.id("draggable"));
	Actions builder = new Actions(driver);
	builder.dragAndDropBy(drag, 100, 150).perform();
	driver.close();

}
}
