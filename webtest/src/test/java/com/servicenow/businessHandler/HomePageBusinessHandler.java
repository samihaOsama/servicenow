package com.servicenow.businessHandler;

import com.servicenow.pageObject.BranchesPage;
import com.servicenow.pageObject.HomePage;
import com.servicenow.pageObject.LoginPage;
/**
 * This class is responsible for handling all business in regards of the home page
 * @author samihaosama
 *
 */
public class HomePageBusinessHandler {

	LoginPage loginPage ;
	HomePage homePage;
	BranchesPage branchesPage;
	
	
	public HomePageBusinessHandler(LoginPage loginPage, HomePage homePage, BranchesPage branchesPage){
		
		this.loginPage = loginPage;
		this.homePage = homePage;
		this.branchesPage = branchesPage;
		
	}
	
	public String greetMessageText(){
		return homePage.greetMessageText();
	}
	
	public HomePage loginSuccessfully(String username, String password){
		return homePage.clickOnLogin().setUserName(username).setPassword(password).clickSubmit_01();
	}
	
	public BranchesPage getBranches(){
		return homePage.clickOnEntities().getBranches();
	}
	
	
}
