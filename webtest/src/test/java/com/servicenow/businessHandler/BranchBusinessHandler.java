package com.servicenow.businessHandler;

import com.servicenow.pageObject.BranchesPage;
import com.servicenow.pageObject.HomePage;
/**
 * Handling the business of branch entities, from creating, viewing, deleting and editing branches
 * @author samihaosama
 *
 */
public class BranchBusinessHandler {
	
	HomePage homePage;
	BranchesPage branchesPage;
	
	public BranchBusinessHandler(HomePage homePage,BranchesPage branchesPage){
		this.homePage = homePage;
		this.branchesPage = branchesPage;
	}
	
//	public BranchesPage checkBranchesAreEmpty(){
//		return this.branchesPage;
//	}
	
	/**
	 * This method is responsible for deleting all branches
	 * @return empty branches page
	 * *NOTE* this method should be handled differently and the method in the branchesPage should be changed as well
	 * 
	 */
	public BranchesPage deleteAllBranches(){
		 branchesPage.deleteAllBranches();
		 if(branchesPage.isEmpty())
			 return branchesPage;
		 else
			 return deleteAllBranches();
	}
	
	public boolean checkIfEmpty(){
		return branchesPage.isEmpty();
	}
	
	public void createNewBranch(String name, String code){
		branchesPage.createBranch();
		
		 branchesPage.setName(name);
		 branchesPage.setCode(code);
		 branchesPage.submitBranch();
	}
	

}
