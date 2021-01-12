package com.ndtv.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.ndtv.qa.base.TestBase;

public class NDTVHomePage extends TestBase{
	
	@FindBy(xpath = "//img[@src ='https://drop.ndtv.com/homepage/images/ndtvlogo23march.png']")
	WebElement logoImage;
	
	@FindBy(xpath = "//a[@id = 'h_sub_menu']")
	WebElement submenulink;
	
	@FindBy(xpath = "//a[text() = 'WEATHER']")
	WebElement weatherLink;
	
	@FindBy(xpath = "//a[@class = 'notnow']")
	WebElement notificationLink;
	
	
	public NDTVHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
		
	}
	
	public boolean validateLogo() {
		boolean tf = logoImage.isDisplayed();
		
		return tf;
	}
	
	public NDTVWetherPage clickWeatherLink() 
	{
		System.out.println("Executing wather click method");
		
		
		if(notificationLink.isDisplayed()) 
		{	
			notificationLink.click();
			 
			 System.out.println("Link is displayed and clicked...");
		}
		submenulink.click(); 
	 try {
		 	Thread.sleep(3000); 
		 } 
	 	catch(InterruptedException e) 
	 	{
	 		
	 	}
	 weatherLink.click();
	 

	 
	 		
	 	return new NDTVWetherPage();
	 }
}
