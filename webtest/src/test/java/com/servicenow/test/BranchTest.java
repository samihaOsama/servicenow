package com.servicenow.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.servicenow.businessHandler.BranchBusinessHandler;
import com.servicenow.businessHandler.HomePageBusinessHandler;
import com.servicenow.businessHandler.LoginBusinessHandler;
import com.servicenow.pageObject.BranchesPage;
import com.servicenow.pageObject.HomePage;
import com.servicenow.pageObject.LoginPage;
import com.servicenow.utilities.Log;

/**
 * Executing test Cases for testing branches
 * @author samihaosama
 *
 */
public class BranchTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	BranchesPage branchesPage;
	
	LoginBusinessHandler loginBusinessHandler;
	HomePageBusinessHandler homePageBusinessHandler;
	BranchBusinessHandler branchBusinessHandler;
	
	String userName;
	String password;
	
	@BeforeClass
    public void init() {
		this.loginPage = new LoginPage(driver);
		this.homePage = new HomePage(driver);
		this.branchesPage = new BranchesPage(driver);
		
		loginBusinessHandler = new LoginBusinessHandler(loginPage, homePage);
		homePageBusinessHandler =  new HomePageBusinessHandler(loginPage, homePage,branchesPage);
		branchBusinessHandler = new BranchBusinessHandler(homePage, branchesPage);
		
		userName = jsonTestData.getData("loginAdmin").get("userName");
		password = jsonTestData.getData("loginAdmin").get("password");
		
		Log.info("Data is initialized successfully");
		
		
	}
	
	@Test(priority = 1)
	public void adminLogin(){
		Log.info("Test login with: " + userName + " " + password);
		homePage = loginBusinessHandler.loginSuccessfully(userName, password);
		assertTrue(homePageBusinessHandler.greetMessageText().contains(userName));
		
        Log.info("Test Passed successfully");
		
	}
	
	@Test(priority = 2)
	public void checkBranchesAreEmpty(){
		homePageBusinessHandler.getBranches().deleteAllBranches();
		assertTrue(branchBusinessHandler.checkIfEmpty());
		Log.info("Test Passed successfully");
		
	}
	
	@Test(priority = 3)
	public void addNewBranch(){
		branchBusinessHandler.createNewBranch(jsonTestData.getData("Branch_one").get("name"), jsonTestData.getData("Branch_one").get("code"));
				
	}

}
