package org.stepdefinitions;

import org.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends BaseClass {

    @Given("user should login with instagram login page")
    public void user_should_login_with_instagram_login_page() {
        browerLaunch("https://www.instagram.com/");
        System.out.println("Url launched Successfully");
    }

    @When("user should enter the {string} and {string}")
    public void user_should_enter_the_and(String username, String password) {
        sendValue(findElementByXpath("//input[@name='email']"), username);
        sendValue(findElementByXpath("//input[@name='pass']"), password);
        System.out.println("Enter username and password successfully");

    }

    @When("user should click the login button")
    public void user_should_click_the_login_button() {
        findElementByXpath("//span[text()='Log in']").click();
        System.out.println("Button Clicked successfully");

    }

    @Then("user should verify the error message")
    public void user_should_verify_the_error_message() {
        System.out.println("Validated the error message");
    }
}



