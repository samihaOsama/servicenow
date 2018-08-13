package com.servicenow.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.WebDriverEventListener;

//done
public class LoginPage extends BasePage{
	
	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(css= "button[class='btn btn-primary ng-scope']")
	private WebElement submitButton;
	
	@FindBy(css= "a[class='ng-scope']")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//div[@class='alert alert-warning ng-scope']/a[@href='#/register']")
	private WebElement register;
	
	@FindBy(css = "div[ng-show='authenticationError']")
	private WebElement authenticationFailedMsg;
	
	
	//constructor
	public LoginPage(WebDriver driver) {
        super(driver);
    }
	
	/**
	 * This method returns LoginPage with userName setting on it
	 * @param userName
	 * @return
	 */
	public LoginPage setUserName(String userName){
		waitForVisibilityOf(this.userName);
		setText(this.userName, userName);
		return this;
		
	}
	
	/**
	 * this method sets the password field with password
	 * @param password
	 * @return
	 */
	public LoginPage setPassword(String password){
		waitForVisibilityOf(this.password);
		setText(this.password, password);
		return this;
	}
	
	/**
	 * This method clicks on Submit button and return a homepage
	 */
	public HomePage clickSubmit_01(){
		waitForVisibilityOf(submitButton);
		click(submitButton);
		return new HomePage(driver);
	}
	
	/**
	 * This method clicks on Submit button
	 */
	public void clickSubmit(){
		waitForVisibilityOf(submitButton);
		click(submitButton);
	}
	
	public String returnAuthMessageFailed(){
		waitForVisibilityOf(authenticationFailedMsg);
		return authenticationFailedMsg.getText();
	}

}
