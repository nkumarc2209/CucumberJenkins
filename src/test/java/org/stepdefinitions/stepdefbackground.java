package org.stepdefinitions;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefbackground extends BaseClass {
	
	@Given("user opens the login page")
	public void user_opens_the_login_page() throws InterruptedException {
		
		browerLaunch("https://www.facebook.com/");
		
		System.out.println("Browser launched successfully");
		Thread.sleep(1000);
	   	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username) throws InterruptedException {
		 WebElement email = findElementByXpath("//input[@name='email']");
		 email.sendKeys(username);
		System.out.println("enter username successfully");
		Thread.sleep(1000);

	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String password) throws InterruptedException {
		 WebElement pass = findElementByXpath("//input[@name='pass']");
		 pass.sendKeys(password);
		System.out.println("enter password successfully");
		Thread.sleep(1000);

	    
	}

	@When("user clicks login")
	public void user_clicks_login() throws InterruptedException {
		 findElementByXpath("//span[text()='Log in']").click();
		System.out.println("Login successfully");
		Thread.sleep(1000);

	}

	@Then("user should see the home page")
	public void user_should_see_the_home_page() {
		browserClose();
		System.out.println("user should see the main page");
	}
	
	@Then("user should see the error message")
	public void user_should_see_the_error_message() {
		System.out.println("user should see the error message");

		browserClose();
	}




}
