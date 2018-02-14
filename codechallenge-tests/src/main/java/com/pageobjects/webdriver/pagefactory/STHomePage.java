package com.pageobjects.webdriver.pagefactory;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjects.Config;

public class STHomePage extends FWBasePage {
	
	Config config;
	
	public STHomePage(WebDriver driver, WebDriverWait wait) {
		super(driver,wait);
		PageFactory.initElements(driver, this);
	}
	
	private String getURLFromConfig(String configKey){
		Config config = new Config();
		String url = null;
		try {
			url = config.readConfig(configKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	public void gotoHomePage(){
		driver.get(getURLFromConfig("url"));
	}
	
	@FindBy(how = How.XPATH, using = "//li/a[text()='Login']")
    private WebElement lnkLogin;
	
	public STLoginPage clickLoginLink(){
		lnkLogin.click();
		return new STLoginPage(driver, wait);
	}
	
	@FindBys({ @FindBy(how = How.XPATH, using = "//div[@id='eyeDiv']/div/iframe") })
	private List<WebElement> iframesAd;
	
	public void closeAdIfAvailable(){
		int count = iframesAd.size();
		if (0 < count && count < 2){
			driver.switchTo().frame(iframesAd.get(0).getAttribute("id"));
			WebElement btnClose = element(By.id("close-button"));
			btnClose.click();
		}
	}
	
	@FindBy(how = How.XPATH, using = "//a[@name='login-user-name']")
    private WebElement lnkLoginUsername;
	
	public Boolean isDefaultUserLogged() throws FileNotFoundException{
		config = new Config();
		Boolean status = false;
		String defaultUser = config.readConfig("username").trim();
		String uiUsername = null;
		try {
			uiUsername = lnkLoginUsername.getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (uiUsername.equalsIgnoreCase(defaultUser)){
			status = true;
		}
		return status;
	}
	
	public Boolean isUserLogged(String username) throws FileNotFoundException{
		Boolean status = false;
		String uiUsername = null;
		try {
			uiUsername = lnkLoginUsername.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (uiUsername.equalsIgnoreCase(username)){
			status = true;
		}
		return status;
	}
	
	@FindBys({ @FindBy(how = How.CSS, using = ".image-full.background-stblue.main-featured-story.classy-panel-styles-pane.firstOfRow.no-border > div > div > div > div > div.pull-left > div > ul > li:nth-child(1) > div > div > div") })
	private List<WebElement> imgTopStory;
	
	public Boolean isTopStoryImageAvailable(){
		Boolean status = false;
		try {
			status = isElementPresentAndVisible(imgTopStory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@FindBy(how = How.CSS, using = ".background-stblue.main-featured-story.classy-panel-styles-pane.firstOfRow.no-border > div > div > div > div > a.block-link")
	private WebElement imgMainStory;
	
	public FWMainArticle clickMainArticle(){
		imgMainStory.click();
		return new FWMainArticle(driver, wait);
	}
	

}
