package OLAMAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReOrder {

	public static void ReOrder_Olam(WebDriver driver)
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@class='action order']")).click();
		checkout.continue_ReviewOrder(driver);
		PlaceOrder.PlaceOrder_Olam(driver);
	}
}
