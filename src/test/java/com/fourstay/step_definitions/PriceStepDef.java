package com.fourstay.step_definitions;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultPage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PriceStepDef {
	HomePage home = new HomePage();
	WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 60);
	SearchResultPage searchResult = new SearchResultPage();

	@When("^Login using valid username and password$")
	public void login_using_valid_username_and_password() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(home.loginLink));
		home.loginLink.click();

		wait.until(ExpectedConditions.visibilityOf(home.email));
		Thread.sleep(1000);
		home.email.sendKeys(ConfigurationReader.getProperty("guest.username"));
		Thread.sleep(1000);
		home.password.sendKeys(ConfigurationReader.getProperty("guest.password"));

		home.loginBtn.click();
	}

	@When("^Input search criteria, specify city\"([^\"]*)\"$")
	public void input_search_criteria_specify_city(String arg1) throws Throwable {

		wait.until(ExpectedConditions.visibilityOf(home.searchBar));
		home.searchBar.sendKeys(ConfigurationReader.getProperty("search.text") + Keys.ENTER);

	}

	@When("^Input  criteria, specify date in\"([^\"]*)\" and date out\"([^\"]*)\" and click search\\.$")
	public void input_criteria_specify_date_in_and_date_out_and_click_search(String start, String end)
			throws Throwable {
		home.moveinCal.click();
		home.userStartDate.sendKeys(start);
		home.userEndDate.sendKeys(end);
	}

	@When("^Input search criteria, specify number of beds\"([^\"]*)\"$")
	public void input_search_criteria_specify_number_of_beds(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(home.searchBtn));

		home.searchBtn.click();
		home.numOfBeds.click();
	}

	@Then("^Result page will be opened with stays meeting search criteria$")
	public void result_page_will_be_opened_with_stays_meeting_search_criteria() throws Throwable {
		Set<String> actualPrice = new HashSet<>();
		for (WebElement element : searchResult.allPrices) {
			System.out.println(element.getText());
		}
		// Assert.assertTrue(actualPrice.contains(searchResult.allPrices));

	}
}
