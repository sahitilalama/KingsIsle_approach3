package com.selenium.kingslsle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalizedMessagePage {

	WebDriver driver;

	public PersonalizedMessagePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = Configuration.personalizeTo)
	public WebElement toMessage;

	@FindBy(id = Configuration.personalizeFrom)
	public WebElement fromMessage;

	@FindBy(id = Configuration.personalizeMessage)
	public WebElement messageField;

	@FindBy(id = Configuration.checkOutButton)
	public WebElement checkoutButton;

	@FindBy(id = Configuration.payPalButton)
	public WebElement payPalButton;
	
	public void getToPersonalizedMessagePage() {
		toMessage.sendKeys("Kingsisle");
		fromMessage.sendKeys("Sahiti");
		messageField.sendKeys("Hello Kingsisle");

		checkoutButton.click();

		// Switch to the jPopFrame.
		driver.switchTo().frame(
				driver.findElement(By.name("jPopFrame_content")));
		
		//clickAnElementById(Configuration.payPalButton);
		//clickAnElementByXpath(Configuration.cancelXpath);
		//driver.findElement(By.id(Configuration.checkoutButton)).click();
		
		clickAnElementByLinkText("Checkout with Credit Card");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void clickAnElementById(String idString) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idString)));
		driver.findElement(By.id(idString)).click();
	}
	
	public void clickAnElementByLinkText(String linkText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText(linkText)));
		driver.findElement(By.linkText(linkText)).click();
	}

	public void clickAnElementByXpath(String xpathString) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(xpathString)));
		driver.findElement(By.xpath(xpathString)).click();
	}
}
