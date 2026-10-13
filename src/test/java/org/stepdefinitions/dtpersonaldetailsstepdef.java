package org.stepdefinitions;

import java.util.List;

import org.base.BaseClass;
import org.pom.PersonalDetailsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dtpersonaldetailsstepdef extends BaseClass {

    // Page Object reference
    PersonalDetailsPage personalDetailsPage;


    @Given("User is on the personal details page")
    public void user_is_on_the_personal_details_page() {

    	browerLaunch("https://www.qapractice.com/practice-forms");

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page title: " + driver.getTitle());

        personalDetailsPage = new PersonalDetailsPage();
    }


    @When("User enters the following personal details")
    public void user_enters_the_following_personal_details(DataTable dataTable) throws InterruptedException {

        // Convert Cucumber DataTable into List
        List<String> details = dataTable.asList();

        // Pass the complete list to Page Class
        personalDetailsPage.enterPersonalDetails(details);

        personalDetailsPage.clickSubmit();
    
        
        Thread.sleep(2000);
    }


    @Then("User should verify the entered details")
    public void user_should_verify_the_entered_details() {

        // Get success message
        String message = personalDetailsPage.getSuccessMessage();

        // Print success message
        System.out.println("Success Message: " + message);
        
        browserClose();
    }
}