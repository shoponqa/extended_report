package smoketest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.HomePage;
import com.LoginPage;
import com.OrderPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Utility;

public class Testsuit {
	WebDriver driver;
	HomePage objhomepage;
	LoginPage objloginpage;
	OrderPage objorderpage;
	ExtentReports report;
	ExtentTest logger;

	@Test(priority = 0, enabled = true)
	public void createaccountInvalidemail() throws Exception {
		report = new ExtentReports("C:\\Report\\executionreport.html");
		logger = report.startTest("Testsuitexecution");
		objloginpage = new LoginPage(driver);
		objloginpage.CreateAccwithInvalidemail("invalidEmail@email");
		Utility.captureScreenshot(driver, "createaccountInvalidemail");
		logger.log(LogStatus.INFO, "Invalidemail");
		logger.log(LogStatus.PASS, "Invalidemail");
	}

	@Test(priority = 1, enabled = true)
	public void createaccountregisteremail() throws IOException {
		objloginpage = new LoginPage(driver);
		objloginpage.CreateNewAccountAlreadyRegistered("mizan@gmail.com");
		logger.log(LogStatus.INFO, "Registeredemail");
		Utility.captureScreenshot(driver, "createaccountregisteremail");
		logger.log(LogStatus.PASS, "Registeredemail");
	}

	@Test(priority = 2, enabled = true)
	public void createaccountwithnewemail() throws Exception {
		objloginpage = new LoginPage(driver);
		objloginpage.CreateNewAccountvalidEmail("awter@gmail.com", "Peter", "Alen", "paswd123", "10", "May", "2000");
		logger.log(LogStatus.INFO, "Newemail");
		Utility.captureScreenshot(driver, "createaccountwithnewemail");
		logger.log(LogStatus.PASS, "Newemail");
	}

	@Test(priority = 3, enabled = true)
	public void ProductSearch() throws Exception {
		objhomepage = new HomePage(driver);
		objhomepage.Clicksignin();
		objhomepage.Productsearch("Shirt");
		logger.log(LogStatus.INFO, "Products");
		Utility.captureScreenshot(driver, "ProductSearch");
		logger.log(LogStatus.PASS, "ProductSearch");
	}

	@Test(priority = 4, enabled = false)
	public void Cartvalide() {
		objhomepage = new HomePage(driver);
		objhomepage.cartvalidation();
		logger.log(LogStatus.INFO, "Cart");
		Utility.captureScreenshot(driver, "CartValidation");
		logger.log(LogStatus.PASS, "Cartvarification");

	}

	@Test(priority = 5, enabled = false)
	public void OrderPage() {
		objorderpage = new OrderPage(driver);
		objorderpage.placeorder();
		logger.log(LogStatus.INFO, "PlaceOrder");
		Utility.captureScreenshot(driver, "Order");

	}

	@BeforeMethod
	public void before() {
		driver = new FirefoxDriver();
		driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, image);
		}
		report.endTest(logger);
		report.flush();
		driver.get("C:\\Report\\executionreport.html");
		driver.quit();
	}
}