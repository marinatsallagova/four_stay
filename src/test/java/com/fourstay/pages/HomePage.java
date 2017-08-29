package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}

	@FindBy(css = ".not-login")
	public WebElement loginLink;

	@FindBy(id = "email")
	public WebElement email;

	// @FindBy(id = "key")
	// public WebElement password;

	@FindBy(id = "btn-login")
	public WebElement loginBtn;

	@FindBy(xpath = "//span[.='LOGOUT']")
	public WebElement logoutbtn;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement password;

	@FindBy(css = "#hLocName")
	public WebElement searchBar;

	@FindBy(css = "i.fa.fa-search")
	public WebElement searchBtn;

	@FindBy(xpath = "//table[@class='table-condensed']//tbody/tr[6]/td[3]")
	public WebElement moveinDate;

	@FindBy(css = "#rentoutfrom3")
	public WebElement moveinCal;

	@FindBy(xpath = "//table[@class='table-condensed']//tbody/tr[2]/td[2]")
	public WebElement moveoutDate;

	@FindBy(xpath = "//select[@id='inputGroupSuccess1']/option[3]")
	public WebElement numOfBeds;

	@FindBy(id = "inputGroupSuccess1")
	public WebElement selectBed;

	@FindBy(id = "iLocName")
	public WebElement schoolName;

	@FindBy(id = "rentoutfrom2")
	public WebElement startDate;

	@FindBy(id = "rentoutto2")
	public WebElement endDate;

	@FindBy(id = "search")
	public WebElement search;

	@FindBy(css = ".intercom-borderless-dismiss-button")
	public WebElement dissmisBtn;

	@FindBy(xpath = "//iframe[@class='intercom-borderless-frame']")
	public WebElement iframe;

	@FindBy(id = "rentoutfrom3")
	public WebElement userStartDate;

	@FindBy(id = "rentoutto3")
	public WebElement userEndDate;

	@FindBy(xpath = "//select[@id='inputGroupSuccess1']/option[4]")
	public WebElement newNumOfBeds;

}
