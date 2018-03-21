package OLAMAuto;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
 
 
public class ExtentReportsClassVersion3{
	ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	ExtentTest logger;
	
	public static WebDriver driver;
		
	
	@BeforeTest
	public void startReport(){
		System.out.println("inside startReport");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
		System.out.println("Htmnl path is" +htmlReporter);
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Gaurav");
		
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
		htmlReporter.config().setReportName("OLAM Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		System.out.println("inside getScreenshot");
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}	
	
	/*public void screenShot(ITestResult result){
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
			if(ITestResult.FAILURE==result.getStatus()){
				try{
					// To create reference of TakesScreenshot
					TakesScreenshot screenshot=(TakesScreenshot)driver;
					// Call method to capture screenshot
					File src=(File) screenshot.getScreenshotAs(OutputType.FILE);
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
	
//	@Test
	public void passTest(){
		logger = extent.createTest("passTest");
		Assert.assertTrue(true);
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
	}
	
	//@Test
	public void failTest(){
		logger = extent.createTest("failTest");
		Assert.assertTrue(true);
		logger.log(Status.PASS, "Test Case (failTest) Status is passed");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
	}
	
	//@Test
	public void skipTest(){
		logger = extent.createTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		System.out.println("status of test cases " +result.getStatus());
		if(result.getStatus() == ITestResult.FAILURE){
			System.out.println("inside failure");
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			System.out.println("result.getName is " +result.getName());
			String screenshotPath = ExtentReportsClassVersion3.getScreenhot(driver, result.getName());
			
			logger.addScreenCaptureFromPath(screenshotPath);
			//logger.log(Status.FAIL, logger.addScreenCaptureFromPath());
			
		}else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));	
		}
		//driver.quit();
	}
	
	@AfterTest
	public void afterMethod() {
	    extent.flush();
	}



}