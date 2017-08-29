package com.fourstay.step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.fourstay.pages.VerifyInfoPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.DBUtility;
import com.fourstay.utilities.DBUtility.DBType;

import cucumber.api.java.en.Then;

public class InfoVarificationStepDef {
	VerifyInfoPage verifyInfoPage = new VerifyInfoPage();

	@Then("^verify first name, last name, phone number for each user is correctly displayed$")
	public void verify_first_name_last_name_phone_number_for_each_user_is_correctly_displayed() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		verifyInfoPage.profileDropDown.click();
		Thread.sleep(2000);
		verifyInfoPage.profileGeneral.click();
		Thread.sleep(3000);

		String firstName = verifyInfoPage.firstName.getAttribute("value");
		String lastName = verifyInfoPage.lastName.getAttribute("value");
		String phoneNumber = verifyInfoPage.phoneNumber.getAttribute("value");
		System.out.println(firstName + lastName + phoneNumber);

		DBUtility.establishConnection(DBType.MYSQL);
		List<String[]> queryResult = DBUtility.runSQLQuery("SELECT first_name, last_name, phone_number FROM employees");
		DBUtility.closeConnections();
		List<String[]> actualData = new ArrayList<>();
		Thread.sleep(2000);
		for (int i = 0; i < queryResult.size(); i++) {

			String[] eachItem = queryResult.get(i);
			String dataFirstName = eachItem[0];
			String dataLastName = eachItem[1];
			String dataPhoneNumber = eachItem[2].replace(".", "");
			if (dataFirstName.equals(firstName) && dataLastName.equals(lastName)
					&& dataPhoneNumber.equals(phoneNumber)) {
				Assert.assertEquals(firstName, dataFirstName);
				Assert.assertEquals(lastName, dataLastName);
				Assert.assertEquals(phoneNumber, dataPhoneNumber);
			}

		}
	}
}
