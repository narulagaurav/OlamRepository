package OLAMAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class DeleteFromCart {

	public static void Delete_Cart(WebDriver driver)
	{
	
		
		Reporter.log("Delete From Cart");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.className("cart-label")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/checkout/cart')]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Click on View Cart");
		//driver.findElement(By.xpath("//a[contains(@href,'/checkout/cart')]")).click();
		driver.findElement(By.xpath("//span[text()='Review Order']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='action action-delete']")).click();
		//driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[6]/div/a[3]")).click();
	}
}
