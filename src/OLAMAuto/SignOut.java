package OLAMAuto;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class SignOut {

	public static void SignOut_Olam(WebDriver driver)
	{
	
		Reporter.log("Sign Out");
		//driver.findElement(By.xpath("//a[contains(@href,'/account/logout')]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		WebElement element = driver.findElement(By.xpath("//a[text()='My Account']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Sign Out")).click();
		try{
			driver.findElement(By.linkText("Sign Out")).click();
		}catch(NoSuchElementException e){}
	}
}
