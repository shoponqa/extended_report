package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends HomePage{
	@FindBy(xpath=".//*[@id='center_column']/p[2]/a[1]/span")
	WebElement process;
	@FindBy(xpath=".//*[@id='email']")
	WebElement user;
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement passw;
	@FindBy(xpath=".//*[@id='SubmitLogin']")
	WebElement signbutt;
	@FindBy(xpath=".//*[@id='address1']")
	WebElement address;
	@FindBy(xpath=".//*[@id='city']")
	WebElement city;
	@FindBy(xpath=".//*[@id='id_state']")
	WebElement state;
	@FindBy(xpath=".//*[@id='postcode']")
	WebElement postcod;
	@FindBy(xpath=".//*[@id='id_country']")
	WebElement country;
	@FindBy(xpath=".//*[@id='phone']")
	WebElement phone;
	@FindBy(xpath=".//*[@id='alias']")
	WebElement ref;
	@FindBy(xpath=".//*[@id='submitAddress']")
	WebElement savebut;
	
	public OrderPage(WebDriver argdriver) {
		super(argdriver);
	}
public void placeorder(){
	
	Actions builder=new Actions(driver);
	builder.moveToElement(prod).perform();
	builder.click(more).build().perform();	
	builder.doubleClick(quantity).build().perform();
	size.sendKeys("L");
	addcart.click();
	proced.click();
	process.click();
	user.sendKeys("mizan@gmail.com");
	passw.sendKeys("password123");
	signbutt.click();
	address.sendKeys("123 main street");
	city.sendKeys("Queens");
	state.sendKeys("New York");
	postcod.sendKeys("11290");
	country.sendKeys("United States");
	phone.sendKeys("2122133211");
	ref.sendKeys("shoping");
	savebut.click();
}
	
	

}
