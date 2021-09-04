package Week4Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("https://jqueryui.com/resizable");
		 String title=driver.getTitle();
	 System.out.println(title);
	 driver.manage().window().maximize();
	 
	 WebElement findElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	 driver.switchTo().frame(findElement);
	 
		WebElement drag = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(drag, 100, 150).perform();
		//builder.dragAndDropBy(drag, 50, 50).perform();
}
}
