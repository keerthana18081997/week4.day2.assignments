package Week4Assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MousetoHover {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("http://www.leafground.com/pages/mouseOver.html");
	 String title=driver.getTitle();
	 System.out.println(title);
	 driver.manage().window().maximize();
	 
	 WebElement element = driver.findElement(By.xpath("//a[@class='btnMouse']"));
	 Actions builder = new Actions(driver);
	 builder.moveToElement(element).perform();
	 WebElement element1=driver.findElement(By.xpath("//a[@class='listener']"));
	 String a=element1.getText();
	 System.out.println(a);
	 element1.click();
	 Alert alert=driver.switchTo().alert();
	 alert.accept();
}
}
