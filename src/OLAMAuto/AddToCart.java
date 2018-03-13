package OLAMAuto;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import junit.framework.Assert;


public class AddToCart{
	

public static void Add_Olam(WebDriver driver) {

	//driver.findElement(By.xpath("//span[text()='View All Orders']")).click();
	//WebElement viewOrder=driver.findElement(By.xpath("//span[text()='View All Orders']"));
	//Assert.assertEquals(true, viewOrder.isDisplayed());
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebElement element = driver.findElement(By.linkText("Onion"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//driver.findElement(By.linkText("Diced")).click();
	WebElement element1 =driver.findElement(By.linkText("Diced"));
	Actions action1 = new Actions(driver);
	action1.moveToElement(element1).build().perform();
	action1.clickAndHold(element1);
	/*	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	//driver.findElement(By.xpath("//a[@id='ui-id-37' and id = 'ui-id-37']")).click();
	//driver.findElement(By.xpath("//button[@id='btn-update-cart' and @class='action update checkout']")).click();
	WebElement element2=driver.findElement(By.xpath("//a[contains(@href,'/default/oniondiced') and @id='ui-id-37']"));
	  //in order to click a non visible element
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", element2);
	
	
	
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-mask']")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@option-label='Purchase']")));
	driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[@option-label='Purchase']")).click();
	//WebElement radio = driver.findElement(By.xpath("//div[@option-label='Purchase' and @option-id='24']"));
	//radio.click();
	//driver.findElement(By.xpath("//div[text()='Conventional']")).click();
	//driver.findElement(By.id("product-addtocart-button")).click();
	//driver.findElement(By.id("datepicker")).sendKeys("10-Nov-2017");
	//Select oSelect = new Select(driver.findElement(By.xpath("//select[@class='swatch-select crop_year']")));
	//oSelect.selectByVisibleText("12 months");
	driver.findElement(By.id("datepicker")).click(); //click field
	driver.findElement(By.linkText("Next")).click(); //click next month
	driver.findElement(By.linkText("30")).click(); //click day
	
	Select qty=new Select (driver.findElement(By.xpath("//select[@class='swatch-select packaging']")));
	System.out.println("After Selecting value from drop down");
	qty.selectByVisibleText("140 lb. Drum");
	driver.findElement(By.id("cart-btn")).click();
	
}

}