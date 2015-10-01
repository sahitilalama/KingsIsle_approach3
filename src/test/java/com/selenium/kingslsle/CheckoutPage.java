package com.selenium.kingslsle;

import junit.framework.TestCase;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends TestCase{

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = Configuration.oneMonth)
	public WebElement oneMonth;

	@FindBy(xpath = Configuration.numberOfCrowns)
	public WebElement numberOfCrowns;

	@FindBy(xpath = Configuration.arcaneBuildersBundle)
	public WebElement arcaneBuildersBundle;

	@FindBy(xpath = Configuration.account)
	public WebElement account;

	@FindBy(xpath = Configuration.quantityPrepaid)
	public WebElement quantityPrepaid;

	@FindBy(xpath = Configuration.quantityCrowns)
	public WebElement quantityCrowns;

	@FindBy(xpath = Configuration.quantityBundles)
	public WebElement quantityBundles;

	@FindBy(xpath = Configuration.pricePrepaid)
	public WebElement pricePrepaid;

	@FindBy(xpath = Configuration.priceCrowns)
	public WebElement priceCrowns;

	@FindBy(xpath = Configuration.priceBundles)
	public WebElement priceBundles;

	@FindBy(xpath = Configuration.tax)
	public WebElement tax;

	@FindBy(xpath = Configuration.total)
	public WebElement total;

	public FinalCheckOut verifyPaymentInformation() {

		// Write the assert Statements.
		assertEquals("Gift Item: KI Prepaid 1 Month",
				driver.findElement(By.xpath(Configuration.oneMonth)).getText());
		
		assertEquals("Gift Item: 5000 Crowns",
				driver.findElement(By.xpath(Configuration.numberOfCrowns))
						.getText());

		assertEquals(
				"Gift Bundle: Arcane Builders Bundle  + show items",
				driver.findElement(By.xpath(Configuration.arcaneBuildersBundle))
						.getText());

		assertEquals("Gift Certificate",
				driver.findElement(By.xpath(Configuration.account)).getText());
		assertEquals("1",
				driver.findElement(By.xpath(Configuration.quantityPrepaid))
						.getText());

		assertEquals("5,000",
				driver.findElement(By.xpath(Configuration.quantityCrowns))
						.getText());

		assertEquals("1",
				driver.findElement(By.xpath(Configuration.quantityBundles))
						.getText());

		assertEquals("$9.95",
				driver.findElement(By.xpath(Configuration.pricePrepaid))
						.getText());

		assertEquals("$10.00",
				driver.findElement(By.xpath(Configuration.priceCrowns))
						.getText());

		assertEquals("$39.00",
				driver.findElement(By.xpath(Configuration.priceBundles))
						.getText());

		assertEquals("$0.00", driver.findElement(By.xpath(Configuration.tax))
				.getText());

		assertEquals("$58.95", driver
				.findElement(By.xpath(Configuration.total)).getText());

		return PageFactory.initElements(driver, FinalCheckOut.class);
	}

}
