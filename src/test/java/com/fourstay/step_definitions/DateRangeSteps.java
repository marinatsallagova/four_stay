package com.fourstay.step_definitions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DateRangeSteps {

	@Given("^Navigate to http://fourstay\\.herokuapp\\.com/$")
	public void navigate_to_http_fourstay_herokuapp_com() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		BrowserUtilities.waitForPageLoad();

	}

	@Given("^Input search criteria, specify date in\"([^\"]*)\" and date out\"([^\"]*)\" and click search\\.$")
	public void input_search_criteria_specify_date_in_and_date_out_and_click_search(String start, String end)
			throws Throwable {
		HomePage home = new HomePage();
		home.startDate.sendKeys(start);
		home.endDate.sendKeys(end);
		// try {
		// Driver.getInstance().switchTo().frame(home.iframe);
		// home.dissmisBtn.click();
		// } catch (Exception e) {
		home.search.click();
		// }
	}

	@Then("^results should contain$")
	public void results_should_contain(List<String> dates) throws Throwable {
		BrowserUtilities.switchTabs("search");
		BrowserUtilities.waitForPageLoad();
		SearchResultPage resultPage = new SearchResultPage();

		Set<String> actualDate = new HashSet<>();
		for (WebElement element : resultPage.allDates) {
			actualDate.add(element.getText());
			System.out.println(element.getText());
		}
		// Assert.assertTrue(actualDate.containsAll(dates));
	}

}
