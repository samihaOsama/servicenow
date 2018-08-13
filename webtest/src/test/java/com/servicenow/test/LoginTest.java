package com.servicenow.test;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.servicenow.businessHandler.HomePageBusinessHandler;
import com.servicenow.businessHandler.LoginBusinessHandler;
import com.servicenow.pageObject.BranchesPage;
import com.servicenow.pageObject.HomePage;
import com.servicenow.pageObject.LoginPage;
import com.servicenow.utilities.Log;

public class LoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	BranchesPage branchesPage;
	
	LoginBusinessHandler loginBusinessHandler;
	HomePageBusinessHandler homePageBusinessHandler;
	
	String userName;
	String password;
	
	@BeforeClass
    public void init() {
		loginPage =  new LoginPage(driver);
		homePage = new HomePage(driver);
		loginBusinessHandler = new LoginBusinessHandler(loginPage, homePage);
		homePageBusinessHandler =  new HomePageBusinessHandler(loginPage, homePage,branchesPage);
		
		//initially username and password are initialized as admin
		userName = jsonTestData.getData("loginAdmin").get("userName");
		password = jsonTestData.getData("loginAdmin").get("password");
		Log.info("Data is initialized successfully");
	}
	
	
	
	@Test(priority = 1)
	public void adminLoginSuccessfully(){
		Log.info("Test login with: " + userName + " " + password);
		homePage = loginBusinessHandler.loginSuccessfully(userName, password);
		assertTrue(homePageBusinessHandler.greetMessageText().contains(userName));
		assertTrue(driver.getCurrentUrl().contains(""));
        Log.info("Test Passed successfully");
		
	}
	
	@Test(priority =2)
	public void logoutSuccessfully(){
		Log.info("logging out successfully");
		homePage = loginBusinessHandler.logoutSuccessfully();
	}
	
	@Test(priority = 3)
	public void loginEmptyUserName(){
		Log.info("Test login with: '' " + password );
		loginBusinessHandler.getHomePage();
		loginBusinessHandler.loginWrongCreds("", password);
		//TODO Assert
		
	}
	
	
	@Test(priority = 4)
	public void loginEmptyPassword(){
		Log.info("Test login with: " + password +" ''");
		loginBusinessHandler.getHomePage();
		loginBusinessHandler.loginWrongCreds(userName, "");
		//TODO Assert
		
	}
	
	@Test(priority = 5)
	public void loginWrongCreds(){
		userName = jsonTestData.getData("fakeUser").get("userName");
		password = jsonTestData.getData("fakeUser").get("password");
		Log.info("Test login with: " + userName + " " + password);
		loginBusinessHandler.getHomePage();
		loginBusinessHandler.loginWrongCreds(userName, password);
		//TODO Assert
		
	}
	
	
	
	

}
