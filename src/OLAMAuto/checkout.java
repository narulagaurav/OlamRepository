package OLAMAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class checkout {

	public static void check_olam(WebDriver driver, ExtentTest logger){
		
		logger.log(Status.INFO, "Inside check_olam");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[contains(@href,'/checkout/cart')]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(Status.INFO,"Inside Checkout");
		Reporter.log("Click on View Cart");
		//driver.findElement(By.xpath("//a[contains(@href,'/checkout/cart')]")).click();
		driver.findElement(By.xpath("//span[text()='Review Order']")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			continue_ReviewOrder(driver);
		}
		logger.log(Status.INFO, "Leaving check_olam");
		continue_ReviewOrder(driver);
	}
		
		public static void continue_ReviewOrder(WebDriver driver)
		{
		/*System.out.println("Before btn-update-cart1");
		Select qty=new Select (driver.findElement(By.id("cart-3438-qty-select")));
		System.out.println("After Selecting value from drop down");
		qty.selectByVisibleText("10200 lbs");*/
	
		//driver.findElement(By.xpath("//span[text()='Continue']")).click();
		//driver.findElement(By.className("action update checkout")).click();
			
		driver.findElement(By.xpath("//button[@id='btn-update-cart' and @class='action update checkout']")).click();
		System.out.println("After btn-update-cart1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			System.out.println("Before btn-update-cart2");
			driver.findElement(By.xpath("//button[@id='btn-update-cart' and @class='action update checkout']")).click();
			System.out.println("Before btn-update-cart2");
		}catch(NoSuchElementException e){}
		
		driver.findElement(By.id("po_number")).sendKeys("12345");
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.id("checkoutbtn"))).doubleClick().build().perform();
		//driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		//Actions action = new Actions(driver);
		//WebElement element=driver.findElement(By.id("checkoutbtn"));

		//Double click
		//action.doubleClick(element).perform();
		
	}
	}
		
	

