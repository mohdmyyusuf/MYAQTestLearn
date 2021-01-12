package com.ndtv.qa.testcases;

import java.io.FileNotFoundException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ndtv.qa.base.TestBase;
import com.ndtv.qa.pages.NDTVHomePage;
import com.ndtv.qa.pages.NDTVWetherPage;

public class NDTVHomePageTest extends TestBase{
	
	NDTVHomePage ndtvHomePageObj;
	NDTVWetherPage ndtvWetherPage;
	
	NDTVHomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void testSetUp() throws FileNotFoundException
	{
		initialization();
		ndtvHomePageObj = new NDTVHomePage();
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String title = ndtvHomePageObj.validateHomePageTitle();
		Assert.assertEquals(prop.getProperty("pagetitle"), title);
	}
	
	@Test(priority = 2)
	public void validateLogoTest() {
		boolean flag = ndtvHomePageObj.validateLogo();
		Assert.assertTrue(flag);
	}
		
	@Test(priority = 3)
	public void logiTest()
	{
		System.out.println("Thats all");
		ndtvWetherPage= ndtvHomePageObj.clickWeatherLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
