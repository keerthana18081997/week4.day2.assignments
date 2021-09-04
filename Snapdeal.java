package Week4Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("https://www.snapdeal.com/");
		 String title=driver.getTitle();
	 System.out.println(title);
	 driver.manage().window().maximize();
	 
	 driver.findElement(By.xpath("(//span[@class='catText'])[6]")).click();
	 driver.findElement(By.xpath("(//span[text()='Sports Shoes'])")).click();
	 Thread.sleep(3000);
	 String totalcountofshoe=driver.findElement(By.xpath("(//span[@class='category-count'])")).getText();
	 System.out.println(totalcountofshoe);
	 driver.findElement(By.xpath("(//div[text()='Training Shoes'])")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-expand-arrow sort-arrow'])")).click();
	 driver.findElement(By.xpath("(//ul[@class='sort-value'])//li[2]")).click();
	 Thread.sleep(3000);
	 List<WebElement> item = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int size = item.size();
		int a=0;
		for(int i=0; i<size; i++) {
			String itemtitle = item.get(i).getText();
			String replaceAll1 = itemtitle.replaceAll("[^0-9]", "");
			int b = Integer.parseInt(replaceAll1);
			System.out.println(b);
			if(a<=b) {
				System.out.println("prices sorted");
			}
			else {
				System.out.println("prices not sorted");
			}
			a=b;
		}
		Thread.sleep(2000);
		WebElement prod = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(prod).perform();
		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		Thread.sleep(3000);
		String price = driver.findElement(By.xpath("//span[@class='strikee ']")).getText();
		Thread.sleep(3000);
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("price " + price);
		System.out.println("discount" +discount);
		
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1250)");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//label[@for='Brand-VSS']")).click();
		System.out.println("puma brand selected");
		driver.quit();
}
}
