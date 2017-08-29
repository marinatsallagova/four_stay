package com.fourstay.step_definitions;

import java.util.UUID;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpStepDef {
	SignUpPage signUp = new SignUpPage();
	WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 60);
	String email;
	final String randomEmail = randomEmail();

	private static String randomEmail() {
		return "John" + UUID.randomUUID().toString() + "test.com";
	}

	@Given("^the user is on the FourStay sign up dialog$")
	public void the_user_is_on_the_FourStay_sign_up_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		signUp.signUp.click();
	}

	@Given("^the user enters enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void the_user_enters_enter_first_name_and_last_name(String firstName, String lastName) throws Throwable {
		signUp.firstName.sendKeys(firstName);
		signUp.lastName.sendKeys(lastName);

		// email = firstName + lastName + "@test,com";
	}

	@Given("^the user enters any unregistered email and password$")
	public void the_user_enters_any_unregistered_email_and_password() throws Throwable {
		signUp.guestRadio.click();
		wait.until(ExpectedConditions.visibilityOf(signUp.email));

		signUp.email.sendKeys(randomEmail);
		signUp.password.sendKeys(ConfigurationReader.getProperty("new.password"));

	}

	@Given("^click on the Sign up button$")
	public void click_on_the_Sign_up_button() throws Throwable {
		signUp.signUpBtn.click();
	}

	@When("^the user goes the account details page$")
	public void the_user_goes_the_account_details_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^first name \"([^\"]*)\" and last name \"([^\"]*)\" should be displayed in the right fields$")
	public void first_name_and_last_name_should_be_displayed_in_the_right_fields(String arg1, String arg2)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
