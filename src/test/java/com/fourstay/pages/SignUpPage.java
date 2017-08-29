package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class SignUpPage {
	public SignUpPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(xpath = "//li[contains(@data-target,'#modal-signup')]")
	public WebElement signUp;

	@FindBy(xpath = "//input[@name='First']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@name='Last']")
	public WebElement lastName;

	@FindBy(xpath = "//form[@id='login-form2']/div[4]")
	public WebElement email;

	@FindBy(xpath = "//form[@id='login-form2']/div[3]")
	public WebElement password;

	@FindBy(css = "input#guest")
	public WebElement guestRadio;

	@FindBy(css = "#btn-signup")
	public WebElement signUpBtn;
}
