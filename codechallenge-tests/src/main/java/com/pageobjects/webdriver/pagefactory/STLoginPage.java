package com.pageobjects.webdriver.pagefactory;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjects.Config;

public class STLoginPage extends FWBasePage {
	
	Config config;

	public STLoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver,wait);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "j_username")
    private WebElement txtUsername;
	
	@FindBy(how = How.ID, using = "j_password")
    private WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Sign in!']")
    private WebElement btnSignIn;
	
	public STHomePage defaultLogin() throws FileNotFoundException{
		config = new Config();
		String username = config.readConfig("username");
		String password = config.readConfig("password");
		clearAndSendKeys(txtUsername, username);
		clearAndSendKeys(txtPassword, password);
		btnSignIn.click();
		return new STHomePage(driver, wait);
	}
	
	public STHomePage Login(String username, String password) throws FileNotFoundException{
		clearAndSendKeys(txtUsername, username);
		clearAndSendKeys(txtPassword, password);
		btnSignIn.click();
		return new STHomePage(driver, wait);
	}
	
}
