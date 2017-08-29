package com.fourstay.step_definitions;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultPage;

import cucumber.api.java.en.When;

public class BedSwitchStepDef {
	HomePage home = new HomePage();
	SearchResultPage searchResult = new SearchResultPage();

	@When("^Change search criteria, specify number of beds\"([^\"]*)\"$")
	public void change_search_criteria_specify_number_of_beds(String arg1) throws Throwable {
		home.searchBtn.click();
		home.newNumOfBeds.click();
	}

	@When("^Verify that search result is updated and matching new search criteria$")
	public void verify_that_search_result_is_updated_and_matching_new_search_criteria() throws Throwable {
		Set<String> threeBeds = new HashSet<>();
		for (WebElement element : searchResult.bedResult) {
			System.out.println(element.getText());
		}
	}
}
