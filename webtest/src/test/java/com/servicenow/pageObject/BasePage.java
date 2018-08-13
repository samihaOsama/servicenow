package com.servicenow.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author samihaosama
 *
 */
public class BasePage {

	//home page on top of every page
	@FindBy(css="span[class='glyphicon glyphicon-home']")
    private WebElement homeBtn;

	//entities button on top of every logged in page
    @FindBy(css="span[class='glyphicon glyphicon-th-list']")
    private WebElement entitiesBtn;
    
    //Account button on top of every page
    @FindBy(css="span[translate='global.menu.account.main']")
    private WebElement accountBtn;
    
    //branches button
    @FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[2]/ul/li[1]/a")
    private WebElement branches;
    
    //staff button
    @FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[2]/ul/li[2]/a")
    private WebElement staff;
	
	//webdriver to be used
	protected WebDriver driver;

    public int timeInMillis = 50;

    public int timeInSecs = 10;

    //Action object for dragging and drop
    Actions action;

    final WebDriverWait wait;
    
    Select select;
    
    BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, timeInSecs, timeInMillis);
    }
    
    /**
     * Click on home button
     */
    public void getHome(){
    	waitForVisibilityOf(homeBtn);
    	homeBtn.click();
    }
    


    /**
     * Click method that takes a web element and perform a click on it
     * @param element
     */
    public void click(WebElement element) {
        element.click();
    }

    /**
     * setText method that takes a web element and write down the given text in it
     * @param element
     * @param text
     */
    public void setText(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Hover method, takes a web element and scroll down to the element
     * @param element
     */
    public void hover(WebElement element) {
        action.moveToElement(element).build().perform();
    }

    /**
     * waitForVisibilityof method, takes a webelement and wait until it shows on browser
     * @param element
     */
    public void waitForVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * clickByAction method, takes a web element and click on by action object
     * @param element
     */
    public void clickByAction(WebElement element) {
        action.moveToElement(element).click().perform();
    }

    /**
     * Wait for a visible button to be enabled
     * @param element
     */
    public void waitForEnableOf(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * waitForInvisibilityOf method, takes a web element and wait until it is invisible
     * @param element
     */
    public void waitForInvisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    

}
