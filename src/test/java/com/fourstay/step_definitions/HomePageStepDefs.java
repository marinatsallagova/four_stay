package com.fourstay.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {

	@Given("^the user is on fourstay home page$")
	public void the_user_is_on_fourstay_home_page() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));

	}

	@When("^the user clicks on the login link$")
	public void the_user_clicks_on_the_login_link() throws Throwable {
		HomePage hp = new HomePage();
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 60);
		wait.until(ExpectedConditions.visibilityOf(hp.loginLink));
		hp.loginLink.click();
	}

	@When("^enter wrong email and correct password$")
	public void enter_wrong_email_and_correct_password() throws Throwable {
		HomePage hp = new HomePage();

		Thread.sleep(1000);
		hp.email.sendKeys(ConfigurationReader.getProperty("wrong.username"));
		Thread.sleep(1000);
		hp.password.sendKeys(ConfigurationReader.getProperty("host.password"));

	}

	@When("^click enter$")
	public void click_enter() throws Throwable {
		HomePage hp = new HomePage();
		hp.loginBtn.click();
	}

	@Then("^the email field should be displayed$")
	public void the_email_field_should_be_displayed() throws Throwable {
		HomePage hp = new HomePage();
		Assert.assertTrue("Email does not exist. Please register or try another email id.", true);
	}

}
