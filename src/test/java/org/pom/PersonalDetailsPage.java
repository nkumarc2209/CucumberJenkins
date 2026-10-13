
	package org.pom;

	

import java.util.List;
import java.sql.Driver;
import java.time.Duration;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class PersonalDetailsPage extends BaseClass {

		WebDriverWait wait;
		
		
		
		
	    // Country dropdown
	    @FindBy(id = "forms-country")
	    private WebElement country;
	    
	    // Title dropdown
	    @FindBy(id = "forms-title")
	    private WebElement title;

	    // First Name
	    @FindBy(id = "forms-first-name")
	    private WebElement firstName;

	    // Last Name
	    @FindBy(id = "forms-last-name")
	    private WebElement lastName;

	    // Date of Birth
	    @FindBy(id = "forms-dob")
	    private WebElement dateOfBirth;

	    // Date of Joining
	    @FindBy(id = "forms-doj")
	    private WebElement dateOfJoining;

	    // Email
	    @FindBy(id = "forms-email")
	    private WebElement email;

	    // Phone Code dropdown
	    @FindBy(id = "forms-phone-code")
	    private WebElement phoneCode;

	    // Phone Number
	    @FindBy(id = "forms-phone-number")
	    private WebElement phoneNumber;

	    
	    // Communication Phone
	    @FindBy(id = "forms-comm-phone")
	    private WebElement communicationPhone;
	    
	 // Communication Email
	    @FindBy(id = "forms-comm-email")
	    private WebElement communicationEmail;

	    // Submit button
	    @FindBy(id = "forms-submit")
	    private WebElement submitButton;

	    // Success message
	    @FindBy(id = "forms-success")
	    private WebElement successMessage;

//------------------------------------------------------------
	    // Constructor
	    public PersonalDetailsPage() {

	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    }


	    // Method to enter all personal details
	    public void enterPersonalDetails(List<String> details) {
	    	
	        // Country
	        Select countrySelect = new Select(country);
	        countrySelect.selectByVisibleText(details.get(0));

	        // Title
	        Select titleSelect = new Select(title);
	        titleSelect.selectByVisibleText(details.get(1));

	        // First Name
	        firstName.sendKeys(details.get(2));

	        // Last Name
	        lastName.sendKeys(details.get(3));

	        // Date of Birth
	        dateOfBirth.sendKeys(details.get(4));

	        // Date of Joining
	        dateOfJoining.sendKeys(details.get(5));

	        // Email
	        email.sendKeys(details.get(6));

	        // Phone Code
	        Select phoneCodeSelect = new Select(phoneCode);
	        phoneCodeSelect.selectByVisibleText(details.get(7));

	        // Phone Number
	        phoneNumber.sendKeys(details.get(8));
	    


	 // 10. Communication
        
	        String communication = details.get(9);
	        
        if (communication.equalsIgnoreCase("Email")) {
        	
//        	communicationPhone.click();
        	
            WebElement emailRadio = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.id("forms-comm-email")
                )
            );

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                emailRadio
            );

        } else if (communication.equalsIgnoreCase("Phone")) {
        	
//        	communicationPhone.click();

            WebElement phoneRadio = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.id("forms-comm-phone")
                )
            );

//            ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].click();",
//                phoneRadio
//            );
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
            	    "arguments[0].click();",
            	    phoneRadio);
            
            // click the submit button
            
//            submitButton.click();
        }
	    }
	    
	    // Click the Submit Button
	    public void clickSubmit() {

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            submitButton
	        );

	        js.executeScript(
	            "arguments[0].click();",
	            submitButton
	        );
	    }


	    // Get success message
	    public String getSuccessMessage() {

	        return successMessage.getText();

	    }
	}

