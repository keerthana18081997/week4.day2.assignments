package Week4Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop {
public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("http://www.leafground.com/pages/drop.html");
		 String title=driver.getTitle();
	 System.out.println(title);
	 driver.manage().window().maximize();
	 
		Actions builder = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		builder.dragAndDrop(source,target).perform();
		driver.close();
}
}
