package com.fourstay.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchBarStepDef {
	HomePage home = new HomePage();
	WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 60);

	@Given("^user is on fourstay home page$")
	public void user_is_on_fourstay_home_page() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
	}

	@When("^user clicks on the login link$")
	public void user_clicks_on_the_login_link() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 60);
		home.loginLink.click();

	}

	@When("^enter guest email and guest password$")
	public void enter_guest_email_and_guest_password() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(home.email));
		Thread.sleep(1000);
		home.email.sendKeys(ConfigurationReader.getProperty("guest.username"));
		Thread.sleep(1000);
		home.password.sendKeys(ConfigurationReader.getProperty("guest.password"));

	}

	@When("^hit enter$")
	public void hit_enter() throws Throwable {
		home.loginBtn.click();
	}

	@Then("^the search bar should be displayed$")
	public void the_search_bar_should_be_displayed() throws Throwable {
		String searchBar = home.searchBar.getText();
		Assert.assertTrue(searchBar, true);
		Assert.assertEquals("", searchBar);
	}

	@Then("^enter text and click on search$")
	public void enter_text_and_click_on_search() throws Throwable {
		home.searchBar.sendKeys(ConfigurationReader.getProperty("search.text") + Keys.ENTER);

	}

	@Then("^enter move in date$")
	public void enter_move_in_date() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(home.moveinCal));
		home.moveinCal.click();
		home.moveinDate.click();
	}

	@Then("^enter move out date$")
	public void enter_move_out_date() throws Throwable {
		home.moveoutDate.click();
	}

	@Then("^select number of beds$")
	public void select_number_of_beds() throws Throwable {
		home.searchBtn.click();
		home.numOfBeds.click();
	}

}
