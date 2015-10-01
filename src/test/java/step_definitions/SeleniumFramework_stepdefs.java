package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.kingslsle.CheckoutPage;
import com.selenium.kingslsle.Configuration;
import com.selenium.kingslsle.FinalCheckOut;
import com.selenium.kingslsle.GiftCardsPage;
import com.selenium.kingslsle.GiftCertificatesPage;
import com.selenium.kingslsle.PersonalizedMessagePage;
import com.selenium.kingslsle.SelectBundle;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeleniumFramework_stepdefs {

	WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	
	// Implement PageObjectModel.
	GiftCertificatesPage gcp = PageFactory.initElements(driver,
			GiftCertificatesPage.class);
	SelectBundle sb = PageFactory.initElements(driver, SelectBundle.class);
	PersonalizedMessagePage pmp = PageFactory.initElements(driver,
			PersonalizedMessagePage.class);
	CheckoutPage cop = PageFactory.initElements(driver, CheckoutPage.class);
	FinalCheckOut vcoe = PageFactory.initElements(driver, FinalCheckOut.class);

	@Given("^I open wizard(\\d+) game website$")
	public void i_open_wizard_game_website(int arg1) throws Throwable {
		driver.get(Configuration.gamepage);
		driver.manage().window().maximize();

	}

	@When("^I click on gift cards$")
	public void i_click_on_gift_cards() throws Throwable {
		GiftCardsPage giftCardsPage = PageFactory.initElements(driver,
				GiftCardsPage.class);
		gcp = giftCardsPage.getToGiftCardsPage();
	}

	@Then("^I am navigated to gift cards$")
	public void i_am_navigated_to_gift_cards() throws Throwable {
		Assert.assertEquals(Configuration.navigationPage,
				driver.getCurrentUrl());

	}

	@Then("^I click on gift certificate$")
	public void i_click_on_gift_certificate() throws Throwable {
		sb = gcp.getToGiftCertificatesPage();
	}

	@Then("^I select option from prepaid memberships$")
	public void i_select_option_from_prepaid_memberships() throws Throwable {
		System.out.println("");
		
	}

	@Then("^I select option from crowns$")
	public void i_select_option_from_crowns() throws Throwable {
		System.out.println("");
	}

	@Then("^I select option from bundles$")
	public void i_select_option_from_bundles() throws Throwable {
		pmp = sb.getToBundlePage();
	}

	@Then("^I click on continue button$")
	public void i_click_on_continue_button() throws Throwable {

		clickAnElementByLinkText("Continue");
	}

	public void clickAnElementByLinkText(String linkText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText(linkText)));
		driver.findElement(By.linkText(linkText)).click();
	}

	@Then("^I am navigated to personalize gift page$")
	public void i_am_navigated_to_personalize_gift_page() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains(
				Configuration.personalizeGiftPage));

	}

	@Then("^I enter text in To$")
	public void i_enter_text_in_To() throws Throwable {
		System.out.println("");
	}

	@Then("^I enter text in From$")
	public void i_enter_text_in_From() throws Throwable {
		System.out.println("");
	}

	@Then("^I enter text in Message$")
	public void i_enter_text_in_Message() throws Throwable {
		pmp.getToPersonalizedMessagePage();
	}
	
	@Then("^I click on checkout with creditcard$")
	public void i_click_on_checkout_with_creditcard() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//clickAnElementByLinkText("Checkout with Credit Card");
		System.out.println("");
	}

	@Then("^I assert current charges on Payment Information page$")
	public void i_assert_current_charges_on_Payment_Information_page()
			throws Throwable {
		vcoe = cop.verifyPaymentInformation();
		vcoe.print();
	}
	
	@Then("^I quit driver and browser$")
	public void i_quit_driver_and_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
		driver.quit();
	}
	
	public void clickAnElementById(String idString) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idString)));
		driver.findElement(By.id(idString)).click();

	}

	public void clickAnElementByXpath(String xpathString) {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(xpathString)));
		driver.findElement(By.xpath(xpathString)).click();
	}
	
}
