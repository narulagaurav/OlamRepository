package OLAMAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PlaceOrder {
	
	public static void PlaceOrder_Olam(WebDriver driver)
	{
		
		
		System.out.println("Inside Place Order");
		//driver.findElement(By.id("agreement_1")).click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-mask']")));
		
			
			//driver.findElement(By.xpath("(//input[@type='checkbox' and @value='1'])")).click();	
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-mask']")));
			
			driver.findElement(By.xpath("(//input[@type='checkbox' and @value='2'])")).click();	
			
		
	//driver.findElement(By.xpath("//input[@type='checkbox']")).click();	
		driver.findElement(By.xpath("//span[text()='Place Your Order']")).click();
		System.out.println("Leaving Place Order");
}
}
