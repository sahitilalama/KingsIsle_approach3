package com.selenium.kingslsle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCertificatesPage {

	WebDriver driver;

	public GiftCertificatesPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = Configuration.giftCert)
	public WebElement giftCertPage;

	public SelectBundle getToGiftCertificatesPage() {
		giftCertPage.click();
		return PageFactory.initElements(driver, SelectBundle.class);
	}
}
