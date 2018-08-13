package com.servicenow.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BranchesPage extends BasePage {

	@FindBy(xpath = "//div[@class='col-md-4']/button[@class='btn btn-primary']/span[@class='ng-scope']")
	private WebElement createBranchBtn;
	
	@FindBy(id = "searchQuery")
	private WebElement searchQuery;
	
	@FindBy(xpath = "//form[@name='searchForm']/button[@class='btn btn-info']")
	private WebElement searchBtn;
	
	@FindBy(xpath= "//table/tbody")
	private WebElement branches;
	
	@FindBy(xpath="//form[@name='deleteForm']//button[@type='submit']/span[@class='ng-scope']")
	private WebElement deleteConfirm;
	
	
	@FindBy(css = "input[ng-model='branch.name']")
	private WebElement setNameField;
	
	@FindBy(css = "input[ng-model='branch.code']")
	private WebElement setcodeField;
	
	@FindBy(xpath = "//button[2][@class='btn btn-primary']/span[@class='ng-scope']")
	private WebElement saveBranchBtn;


	//view , edit & delete
	
	public BranchesPage(WebDriver driver) {
		super(driver);
	}
	
	//method for deleting all records
	public BranchesPage deleteAllBranches(){
		List<WebElement> deleteBranchesList = branches.findElements(By.xpath("//table/tbody/tr/td/button[3]"));
		
		for(int i = 0; i < deleteBranchesList.size(); i++){
			waitForVisibilityOf(deleteBranchesList.get(i));
			deleteBranchesList.get(i).click();
			confirmDeleting();
		}
		
		return this;
	}
	
	//confirming on deleting
	public void confirmDeleting(){
		
		waitForVisibilityOf(deleteConfirm);
		deleteConfirm.click();
		
		
	}
	
	//method for creating one
	public void createBranch(){
		waitForVisibilityOf(createBranchBtn);
		clickByAction(createBranchBtn);
		
//		setName(name);
//		setCode(code);
//		submitBranch();
		//return this;
	}

	public void submitBranch() {
		waitForVisibilityOf(saveBranchBtn);
		clickByAction(saveBranchBtn);
		//return this;
		
	}

	public void setCode(String code) {
		waitForVisibilityOf(setcodeField);
		setText(setNameField, code);
		//return this;
		
	}

	public void setName(String name) {
		waitForVisibilityOf(setNameField);
		setText(setNameField, name);
		//return this;
		
	}
	
	//method of searching one
	private BranchesPage searchQuery(String query){
		waitForVisibilityOf(searchQuery);
		setText(searchQuery, query);
		submitSearch();
		return this;
	}

	private void submitSearch() {
		waitForVisibilityOf(searchBtn);
		searchBtn.click();
	}
	
	
	//method for searching by id in table
	public BranchesPage viewById(String id){
		
		List<WebElement> idsList = branches.findElements(By.xpath("//tbody/tr/td[1]")); 
		for(int i = 0 ; i <idsList.size();i++){
			if(idsList.get(i).getText().equals(id)){
				idsList.get(i).click();
			}
		}
		return this;
		
	}
	
	public boolean isEmpty(){
		List<WebElement> branchesList = branches.findElements(By.xpath("//table/tbody/tr/td/button[3]"));
		if(branchesList.size() == 0)
			return true;
		return false;
	}
	


}
