package com.ndtv.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ndtv.qa.util.TestUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase()
	{
		prop = new Properties();
		try{
			FileInputStream fis = new FileInputStream("D:\\Eclipse_Workspace\\NDTVWeatherTest\\src\\main\\java\\com\\ndtv\\qa\\config\\config.properties");
			prop.load(fis);
			} 
		
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		
		String browserName = prop.getProperty("browser");
		String chrome_path = prop.getProperty("chromedriver_path");
		String gecko_path = prop.getProperty("chromedriver_path");
		if(browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", chrome_path);
			
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--disable-notifications");
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);			
		}
		else if(browserName.equals("ff")) 
		{
			System.setProperty("webdriver.gecko.driver", gecko_path);
			DesiredCapabilities capab = new DesiredCapabilities().firefox();
			capab.setCapability("marionette", true);
			driver = new FirefoxDriver(capab);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
}
