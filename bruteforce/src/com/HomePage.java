package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
WebDriver driver;
@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
WebElement signinlink;
@FindBy(xpath=".//*[@id='search_query_top']")
WebElement search;
@FindBy(xpath=".//*[@id='searchbox']/button")
WebElement searchbutt;
@FindBy(xpath=".//*[@id='center_column']/h1/span[1]")
WebElement searhvarify;
@FindBy(xpath=".//*[@id='homefeatured']/li[2]/div/div[1]/div/a[1]/img")
WebElement prod;
@FindBy(xpath=".//*[@id='add_to_cart']/button")
WebElement addcart;
@FindBy(xpath=".//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[2]/span")
WebElement more;
@FindBy(xpath=".//*[@id='quantity_wanted_p']/a[2]/span/i")
WebElement quantity;
@FindBy(xpath=".//*[@id='group_1']")
WebElement size;
@FindBy(xpath=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
WebElement proced;
public HomePage(WebDriver argdriver){
	this.driver=argdriver;
	PageFactory.initElements(driver, this);
}
public void Clicksignin(){  
	signinlink.click();
}
public void Productsearch(String argstr){
	search.sendKeys(argstr);
	searchbutt.click(); 
	Assert.assertEquals(true, searhvarify.isDisplayed());
}
public void  cartvalidation(){	
Actions builder=new Actions(driver);
builder.moveToElement(prod).perform();
builder.click(more).build().perform();	
builder.doubleClick(quantity).build().perform();
size.sendKeys("L");
addcart.click();
proced.click();
}
}
