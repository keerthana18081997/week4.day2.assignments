package Week4Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("http://www.leafground.com/pages/selectable.html");
		 String title=driver.getTitle();
	 System.out.println(title);
	 driver.manage().window().maximize();
	Actions builder = new Actions(driver);
	
	WebElement item1 = driver.findElement(By.xpath("//ol//li[1]"));
	WebElement item5 = driver.findElement(By.xpath("//ol//li[4]"));
	builder.clickAndHold(item1).moveToElement(item5).release().perform();
}
}
