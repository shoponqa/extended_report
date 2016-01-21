package com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signinLink;
	@FindBy(xpath = ".//*[@id='email_create']")
	WebElement createaccountemail;
	@FindBy(xpath = ".//*[@id='SubmitCreate']")
	WebElement createaccountsubmit;
	@FindBy(xpath = ".//*[@id='create_account_error']")
	WebElement invalidemailerror;
	@FindBy(xpath = ".//*[@id='create_account_error']/ol/li")
	WebElement invalidemailmessage;
	@FindBy(xpath = ".//*[@id='id_gender1']")
	WebElement gender;
	@FindBy(xpath = ".//*[@id='customer_firstname']")
	WebElement Fname;
	@FindBy(xpath = ".//*[@id='customer_lastname']")
	WebElement Lname;
	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement Pass;
	@FindBy(xpath = ".//*[@id='days']")
	WebElement day;
	@FindBy(xpath = ".//*[@id='months']")
	WebElement month;
	@FindBy(xpath = ".//*[@id='years']")
	WebElement year;
	@FindBy(xpath = ".//*[@id='submitAccount']")
	WebElement registerbutt;

	public LoginPage(WebDriver argDriver) {
		this.driver = argDriver;
		PageFactory.initElements(driver, this);
	}

	public void CreateAccwithInvalidemail(String argemail) throws Exception {
		signinLink.click();
		createaccountemail.sendKeys(argemail);
		createaccountsubmit.click();
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='create_account_error']")).isDisplayed());
		
//		invalidemailerror.getText().equals(invalidemailmessage);
		
	}

	public void CreateNewAccountAlreadyRegistered(String argrmail) {
		signinLink.click();
		createaccountemail.sendKeys(argrmail);
		createaccountsubmit.click();
		//invalidemailerror.getText().equals(invalidemailmessage);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='create_account_error']/ol/li")).isDisplayed());
	}

	public void CreateNewAccountvalidEmail(String argemail, String argF, String argL, String argP, String argD,
			String argM, String argY) {
		signinLink.click();
		createaccountemail.sendKeys(argemail);
		createaccountsubmit.click();
		gender.click();
		Fname.sendKeys(argF);
		Lname.sendKeys(argL);
		Pass.sendKeys(argP);
		day.sendKeys(argD);
		month.sendKeys(argM);
		year.sendKeys(argY);
		registerbutt.click();
	}
}
