package logfour;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		Logger logger = Logger.getLogger("Demo");
		PropertyConfigurator.configure("Log4j.properties");
		WebDriver driver = new FirefoxDriver();
		logger.info("Firefox opened");
		driver.manage().window().maximize();
		logger.info("Browser Maximized");
		driver.get("http://www.piit.us");
		logger.info("Successfully login");
		Actions builder=new Actions(driver);
		WebElement prod= driver.findElement(By.xpath(".//*[@id='redips_dialog']/div/span"));
		builder.moveToElement(prod).perform();
		builder.doubleClick(prod).build().perform();
		// driver.findElement(By.xpath("//div[@class='redips_dialog_titlebar']//span[.='✕']")).click();
		// logger.info("Popup window close");
		driver.findElement(By.xpath("//div[@class='redips_dialog_titlebar']//span[.='✕']")).click();
		driver.findElement(By.linkText("My Forum")).click();
		// driver.findElement(By.xpath(".//*[@id='table223']/tbody/tr/td[2]/font/a[1]")).click();
		logger.info("Open login box");
		driver.findElement(By.xpath(".//*[@id='frmLogin']/div/div[3]/dl/dd[1]/input")).sendKeys("testuser1");
		logger.info("Enter User name");
		driver.findElement(By.xpath(".//*[@id='frmLogin']/div/div[3]/dl/dd[2]/input")).sendKeys("abcd1234");
		logger.info("Enter user password");
		driver.findElement(By.xpath(".//*[@id='frmLogin']/div/div[3]/p[1]/input")).click();
		logger.info("Landing Page");
		driver.quit();
		logger.info("Firefox Close");
	}

}
