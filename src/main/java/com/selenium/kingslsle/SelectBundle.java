package com.selenium.kingslsle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectBundle {
	
	WebDriver driver;

	public SelectBundle(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = Configuration.prepaidMembership)
	public WebElement month;
	
	@FindBy(id = Configuration.crowns)
	public WebElement crowns;
	
	@FindBy(xpath = Configuration.bundle)
	public WebElement bundle;
	
	@FindBy(xpath = Configuration.continueButton)
	public WebElement continueButton;
	
	public PersonalizedMessagePage getToBundlePage() {
		month.click();
		crowns.click();
		bundle.click();
		
		//Click on continue and return PersonalizedMessagePage.
		//clickAnElementByLinkText("Continue");
		//continueButton.click();
		
		//clickAnElementByLinkText("Continue");
		return PageFactory.initElements(driver, PersonalizedMessagePage.class);
		
	}
	
	public void clickAnElementByLinkText(String linkText) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(Configuration.continueButton)));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText(linkText)));
		
	}

}
