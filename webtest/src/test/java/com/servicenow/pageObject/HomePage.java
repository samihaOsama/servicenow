package com.servicenow.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is responsible for the home page before and after logging in
 * @author samihaosama
 *
 */
public class HomePage extends BasePage {

	// home page on top of every page
	@FindBy(css = "span[class='glyphicon glyphicon-home']")
	private WebElement homeBtn;

	// entities button on top of every logged in page
	@FindBy(css = "span[class='glyphicon glyphicon-th-list']")
	private WebElement entitiesBtn;

	// Account button on top of every page
	@FindBy(css = "span[translate='global.menu.account.main']")
	private WebElement accountBtn;

	// branches button
	@FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[2]/ul/li[1]/a")
	private WebElement branches;

	// staff button
	@FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[2]/ul/li[2]/a")
	private WebElement staff;

	// Greet message
	@FindBy(css = "div[translate='main.logged.message']")
	private WebElement greetMessage;
	
	//login link before authentication
	@FindBy(xpath = "//div[@class='col-md-8']/div/div[1]/a[@href='#/login']")
	private WebElement loginLink;
	
	//logout button in logged in account
	@FindBy(xpath = "//a[@href='']/span[@class='ng-scope']")
	private WebElement logoutBtn;

	public HomePage(WebDriver driver) {
		super(driver);

	}

//	public HomePage getHomePage() {
//		waitForVisibilityOf(homeBtn);
//		homeBtn.click();
//		return this;
//	}

	public HomePage clickOnEntities() {
		waitForVisibilityOf(entitiesBtn);
		entitiesBtn.click();
		return this;

	}
	
	public BranchesPage getBranches(){
		waitForVisibilityOf(branches);
		branches.click();
		return new BranchesPage(driver);
	}

	public StaffPage getEntitiesStaff() {
	
		waitForVisibilityOf(staff);
		staff.click();
		return new StaffPage(driver);
	}

	public HomePage checkUserName(String name) {
		waitForVisibilityOf(greetMessage);
		greetMessage.equals("You are logged in as user " + name + ".");

		return this;
	}
	
	public String greetMessageText(){
		return greetMessage.getText();
	}
	
	public LoginPage clickOnLogin(){
		waitForVisibilityOf(loginLink);
		loginLink.click();
		return new LoginPage(driver);
		
	}
	
	
	public HomePage clickOnAccountBtn(){
		waitForVisibilityOf(accountBtn);
		accountBtn.click();
		return this;
	}
	
	public HomePage logout(){
		waitForVisibilityOf(logoutBtn);
		logoutBtn.click();
		return this;
	}

}
