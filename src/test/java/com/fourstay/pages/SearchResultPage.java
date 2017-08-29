package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class SearchResultPage {
	public SearchResultPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = ".col-md-12>p")
	public List<WebElement> allStates;

	@FindBy(xpath = "//span[@class='ng-binding']")
	public List<WebElement> allDates;

	@FindBy(xpath = "//span[@class='price-bold ng-binding']")
	public List<WebElement> allPrices;

	@FindBy(css = ".intercom-borderless-dismiss-button")
	public List<WebElement> bedResult;

}
