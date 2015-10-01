package com.selenium.kingslsle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardsPage {

	WebDriver driver;

	public GiftCardsPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = Configuration.giftCard)
	public WebElement giftCardPage;
	
	//WebElement giftCardPage = driver.byXpath(Configuration.giftCard);

	public GiftCertificatesPage getToGiftCardsPage() {
		giftCardPage.click();
		return PageFactory.initElements(driver, GiftCertificatesPage.class);
	}

}
