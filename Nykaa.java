package Week4Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.nykaa.com/");
			 String title=driver.getTitle();
		 System.out.println(title);
		 driver.manage().window().maximize();
		 
		 
		 WebElement brand=driver.findElement(By.xpath("//a[text()='brands']"));
		 Actions action=new Actions(driver);
		 action.moveToElement(brand).perform();
		 WebElement propular=driver.findElement(By.xpath("//a[text()='Popular']"));
		 action.moveToElement(propular).perform();
		 driver.findElement(By.xpath("//li[@class='brand-logo menu-links'][5]/a[1]")).click();
		 Thread.sleep(3000);
		   Set<String> windowhandleset1= driver.getWindowHandles();
			 List<String> windowhandlesList1=new ArrayList<String>(windowhandleset1);
			 driver.switchTo().window(windowhandlesList1.get(1));
			 String title1=driver.getTitle();
			 System.out.println(title1);
			 if(title1.equals("L'Oreal Paris - Buy L'Oreal Paris Products Online at Best Price | Nykaa")) {
				 System.out.println("title verified");
			 }
			 else {
				 System.out.println("Wrong title");
			 }
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//span[text()='popularity']")).click();
				driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)", "");
			 
			 driver.findElement(By.xpath("//div[text()='Category']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//a[text()='hair']")).click();
			 driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
			 driver.findElement(By.xpath("//a[text()='Shampoo']")).click();
			 Thread.sleep(3000);
			 Set<String> windowhandleset2= driver.getWindowHandles();
			 List<String> windowhandlesList2=new ArrayList<String>(windowhandleset2);
			 driver.switchTo().window(windowhandlesList2.get(1));
			 String filter = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
				if (filter.contains("Shampoo"))
					System.out.println("Filter is applied with Shampoo");
				else
					System.out.println("Filter is not applied with Shampoo");
				
				List<WebElement> productList = driver.findElements(By.xpath("//div[@class='m-content__product-list__title']"));
				for (WebElement product : productList) {
					if (product.getText().contains("L'Oreal Paris Colour Protect Shampoo")) {
						product.click();
						break;
					}
				}
				driver.findElement(By.xpath("//span[text()='175ml']")).click();
			    Thread.sleep(2000);
				String price = driver.findElement(By.xpath("//div[@class='price-info']/span[2]")).getText();
				System.out.println("price of the product "+price);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='pull-left']")).click();
				driver.findElement(By.className("AddBagIcon")).click();
				String totalamt = driver.findElement(By.xpath("//span[text()='Grand Total']/following::div")).getText();
				System.out.println("The grand total==: "+totalamt);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[text()='Proceed']")).click();
				driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
				String finalamt = driver.findElement(By.xpath("//div[@class='value']/span")).getText();
				System.out.println(finalamt);
				if(totalamt.equals(finalamt)) {
					System.out.println("The final total is same as grand total");
				}
				else {
					System.out.println("The final total is not same as grand total");
				}
				
			 driver.switchTo().window(windowhandlesList1.get(0));
			 driver.switchTo().window(windowhandlesList2.get(0));
		 driver.quit();
		 
		 
	}

}
