package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class VerifyInfoPage {
	public VerifyInfoPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(xpath = "//li[@class='nav-gravicon dropdown']")
	public WebElement profileDropDown;

	@FindBy(xpath = "//a[@ui-sref='profile.general']")
	public WebElement profileGeneral;

	@FindBy(xpath = "//input[contains(@ng-model,'$parent.other.FirstName')]")
	public WebElement firstName;

	@FindBy(xpath = "//input[contains(@ng-model,'$parent.other.LastName')]")
	public WebElement lastName;

	@FindBy(xpath = "//input[contains(@ng-model,'$parent.other.email')]")
	public WebElement email;

	@FindBy(xpath = "//input[contains(@ng-model,'$parent.profile.general.phone')]")
	public WebElement phoneNumber;

	// @FindBy(xpath = "//input[contains(@ng-model,'$parent.other.FirstName')]")
	// public WebElement firstName;
}
