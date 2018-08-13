package com.servicenow.businessHandler;

import com.servicenow.pageObject.HomePage;
import com.servicenow.pageObject.LoginPage;

/**
 * This class is responsible for holding business that can be done on Login Page
 * @author samihaosama
 *
 */
public class LoginBusinessHandler {

	//Instance of login page
	LoginPage loginPage;
	
	//instance of home page
	HomePage homePage;

	/**
	 * This is a constructor
	 * @param loginPage
	 * @param homePage
	 */
	public LoginBusinessHandler(LoginPage loginPage, HomePage homePage) {
		this.loginPage = loginPage;
		this.homePage = homePage;
	}

	/**
	 * This method logs in successfully
	 * @param userName
	 * @param password
	 * @return homepage with a logged in user
	 */
	public HomePage loginSuccessfully(String userName, String password) {
		return homePage.clickOnLogin().setUserName(userName).setPassword(password).clickSubmit_01();
	}
	
	/**
	 * This method logs out successfully
	 * @return homepage with no user logged in
	 */
	public HomePage logoutSuccessfully(){
		return homePage.clickOnAccountBtn().logout();
	}
	
	/**
	 * This method logs in with no password
	 * @param userName
	 * 
	 */
	public void loginNoPassword(String userName){
		loginPage.setUserName(userName).setPassword("").clickSubmit();
	}
	/**
	 * This method logs in with no username
	 * @param password
	 */
	public void loginNoUserName(String password){
		loginPage.setUserName("").setPassword(password).clickSubmit();
	}
	
	/**
	 * This method logs in with wrong credentials
	 * @param userName
	 * @param password
	 */
	public void loginWrongCreds(String userName, String password) {
		homePage.clickOnLogin().setUserName(userName).setPassword(password).clickSubmit();

	}
	
	public void getHomePage(){
		loginPage.getHome();
	}
	
	
}
