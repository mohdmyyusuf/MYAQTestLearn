package com.ndtv.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ndtv.qa.base.TestBase;
import com.ndtv.qa.pages.NDTVHomePage;
import com.ndtv.qa.pages.NDTVWetherPage;

public class NDTVWetherPageTest extends TestBase{
	
	NDTVWetherPage obj;
	NDTVHomePage ndtvHP;
	
	
	NDTVWetherPageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		ndtvHP = new NDTVHomePage();
		obj = ndtvHP.clickWeatherLink();
		
	}
	
	@Test
	public void verifyWetherLink() {
		
		obj.clickCityName();
	}
	
	@AfterMethod
	public void closeTest() {
		
		driver.quit();
	}

}
