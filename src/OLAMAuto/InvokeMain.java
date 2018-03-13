package OLAMAuto;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class InvokeMain extends ExtentReportsClassVersion3{
	 
	
	//public static WebDriver driver;
	@BeforeMethod
	public void initiateSetup(){
		
		System.setProperty("webdriver.chrome.driver","/Users/chdsez97152lADM/Desktop/chromedriver 3");
		//report=new ExtentReports("/Users/chdsez97152lADM/Desktop/LearnAutomation.html");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://52.187.61.196//");
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	//@Test(enabled=false)
	public  void checkoutFlow()
	{
		logger = extent.createTest("Checkout");
		
		logger.log(Status.INFO, "Test started");
	/*	WebElement element = driver.findElement(By.xpath("//a[text()='My Account']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();*/
		//logger.log(LogStatus.INFO, "Test Started");
		Login.login_olam(driver);
		logger.log(Status.INFO, "User logged in");
		
		
		System.out.println("Before Olam Validate");
		Add_Olam_Validate(driver,logger);
		System.out.println("After Olam Validate");
		AddToCart.Add_Olam(driver);
		
		checkout.check_olam(driver,logger);
		
		PlaceOrder.PlaceOrder_Olam(driver);
		//driver.findElement(By.xpath("//span[text()='Go to My Account']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SignOut.SignOut_Olam(driver);
			
	}
	

	private static void Add_Olam_Validate( WebDriver driver,  ExtentTest logger) {
		// TODO Auto-generated method stub
		
		logger = extent.createTest("OLAM Validate");
		assertTrue(driver.findElement(By.xpath("//span[text()='View All Orders']")).isDisplayed());
		//boolean searchIconPresence = driver.findElement(By.xpath("//span[text()='View All Orders']")).isDisplayed();
		
		//if (searchIconPresence==true)
		//{
			
			System.out.println("View All Orders is Present");
			//driver.findElement(By.xpath("//span[text()='View All Orders']")).click();
			//logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.GREEN));
		//}	
	}
	
	private static void assertTrue(boolean displayed) {
		// TODO Auto-generated method stub
		
	}
	
	//@Test(enabled=false)
	@Test(priority=2)
	public void reorderFlow()
	{
		System.out.println("Re-Order");
		logger = extent.createTest("Re-Order");
		//logger = extent.startTest("Reorder flow");
		//logger=extent.createTest(testName)
	/*	WebDriverWait wait=new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-mask']")));
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='My Account']")));
		logger.log(Status.INFO, "ReOrder flow started");
		driver.findElement(By.xpath("//span[text()='Go to My Account']")).click();*/
		
		Login.login_olam(driver);
		ReOrder.ReOrder_Olam(driver);
		logger.log(Status.INFO, "ReOrder flow Ended");
	
	}
	
	
	@Test(priority=3)
	//@Test(enabled=false)
	public  void clearCartFlow()
	{
		//ExtentReports report;
		//logger = extent.startTest("Delete flow");
		//report=new ExtentReports("/Users/chdsez97152lADM/Desktop/LearnAutomation.html");
	/*	WebElement element = driver.findElement(By.xpath("//a[text()='My Account']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		if(driver.findElement(By.linkText("Log In")).isDisplayed())
		{
			Reporter.log("Login to site");
			Login.login_olam(driver);
			

		}
		else
		{
			Reporter.log("Logout from  site");
			SignOut.SignOut_Olam(driver);
		
		}
		*/
		logger = extent.createTest("Delete From Cart");
		System.out.println("clearCartFlow");
		//WebDriverWait wait=new WebDriverWait(driver, 180);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-mask']")));
		//driver.findElement(By.xpath("//span[text()='Go to My Account']")).click();
		Login.login_olam(driver);
		System.out.println("After Login");
			Reporter.log("Add To Cart");
			AddToCart.Add_Olam(driver);
			System.out.println("After Add to Cart");
			logger.log(Status.INFO, "DeleteFromCart flow started");
			DeleteFromCart.Delete_Cart(driver);
			System.out.println("After Delete from Cart");
			logger.log(Status.INFO, "DeleteFromCart flow Ended");		
	}
	
	
	//@Test(enabled=false)
	@Test(priority=4)
	public void addToCart()
	{
		logger = extent.createTest("Add to Cart");
		System.out.println("Add To Cart");
		//driver.findElement(By.xpath("//a[contains(@href,'/customer/account')]")).click();
		logger.log(Status.INFO, "Add to Cart flow started");
		Login.login_olam(driver);
		AddToCart.Add_Olam(driver);
		logger.log(Status.INFO, "Add to Cart Flow ended");

		
	}
	
	//@Test(enabled=false)
	@Test(priority=5)
	public void addMoreItems()
	{
		System.out.println("Add More Items");
		logger = extent.createTest("Add More items");
		Login.login_olam(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@class='action order']")).click();
		if(driver.getPageSource().contains("Order Total")){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}
		driver.findElement(By.xpath("//button[@id='add-more-items']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/customer/account')]")).click();
		AddToCart.Add_Olam(driver);
		logger.log(Status.INFO,"Add More Items Flow Ended");
		
	}
	   
	    public void ByVisibleElement(WebDriver driver) {
	       
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        //Find element by link text and store in variable "Element"        		
	      //  WebElement Element = driver.findElement(By.linkText("Linux"));
	        
	        WebElement Element = driver.findElement(By.xpath("//span[text()='Recent Ordered Items']"));
	        //This will scroll the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element);
	    }
	
	@Test(priority=6)
	public void RecentOrdItems()
	{
		logger = extent.createTest("Recent Ordered Items");
		Login.login_olam(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByVisibleElement(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.linkText("View Details")).click();
		driver.findElement(By.xpath("//div[text()='Purchase']")).click();
		//Select oSelect = new Select(driver.findElement(By.xpath("//select[@class='swatch-select crop_year']")));
		//oSelect.selectByVisibleText("12 months");
		driver.findElement(By.id("datepicker")).click(); //click field
		driver.findElement(By.linkText("Next")).click(); //click next month
		driver.findElement(By.linkText("28")).click(); //click day
		driver.findElement(By.id("cart-btn")).click();
		Select qty=new Select (driver.findElement(By.xpath("//select[@class='swatch-select packaging']")));
		System.out.println("After Selecting value from drop down");
		qty.selectByVisibleText("140 lb. Drum");
		checkout.check_olam(driver,logger);
		
		PlaceOrder.PlaceOrder_Olam(driver);
		logger.log(Status.INFO,"Recent Order Items Flow Ended");
	}
	
	@Test(priority=7)
	public void NavReviewOrdPage()
	{
		logger = extent.createTest("Navigate to Review Order Page ");
		logger.log(Status.INFO,"Navigate to Review Order Page Started");
		Login.login_olam(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddToCart.Add_Olam(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@class ='review-order-button']")).click();
		logger.log(Status.INFO,"Navigate to Review Order Page Ended");
		
	}
	
	@Test(priority=8)
	public void ProdCategoryPage()
	{
		
		logger = extent.createTest("Navigate to Product Category Page ");
		logger.log(Status.INFO,"Navigate to Product Category Page Started");
		System.out.println("inside category before login");
		Login.login_olam(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Before click on Tomatoes");
		//driver.findElement(By.xpath("//span[text()='Tomatoes']")).click();
		driver.findElement(By.linkText("Onion")).click();
		System.out.println("After click on Tomatoes");
		logger.log(Status.INFO,"Navigate to Product Category Page Ended");
		
	}
	
}

/*@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=(File) screenshot.getScreenshotAs(OutputType.BASE64);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				//FileUtils.copyFile(src, new File("/Users/chdsez97152lADM/Desktop/"+result.getName()+".png"));
				
				//after execution, you could see a folder "FailedTestsScreenshots" under src folder
				String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+result.getName()+".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(src, finalDestination);
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
		
		
	//driver.quit();
	}*/
	


//	@Test(priority = 1)
//	public static void Login()  {
//		
//		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
//		Login.login_olam(driver);
//		
//	}
	
//	@Test(priority = 2)
//	public static void AddToCart()  {
//		
//		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
//		AddToCart.Add_Olam(driver);
//	}
//	
//	@Test(priority = 3)
//	public static void Checkout()  {
//		
//		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
//		
//		checkout.check_olam(driver);
//	
//}
//
//	@Test(priority=4)
//	public static void PlaceOrder()  {
//		
//		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
//		
//		PlaceOrder.PlaceOrder_Olam(driver);
//	
//}

