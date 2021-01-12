package com.ndtv.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ndtv.qa.base.TestBase;

public class NDTVWetherPage extends TestBase {

	@FindBy(xpath = "//a[text() = 'WEATHER']")
	WebElement weatherLink;

	@FindBy(xpath = "//a[@id = 'h_sub_menu']")
	WebElement submenulink;

	@FindBy(xpath = "//a[@class = 'notnow']")
	WebElement notificationLink;

	@FindBy(xpath = "(//div[@class = 'cityText'])[8]")
	WebElement CityName;

	@FindBy(xpath = "(//div[@class = 'leaflet-popup-content'])")
	WebElement wetherTooltip;

	public NDTVWetherPage() {

		PageFactory.initElements(driver, this);
	}

	public String clickCityName() {

		CityName.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String text = wetherTooltip.getText();
		System.out.println(text);

		return text;
	}

}
