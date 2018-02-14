package com.pageobjects.androd.pagefactory;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.pageobjects.Config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ADHomePage extends ADBasePage{

	public ADHomePage(AppiumDriver<MobileElement> androidDriver) {
		super(androidDriver);
	}
	
	WebElement lnkDrawerMenu = androidDriver.findElementByAccessibilityId("Navigate up");
	
	public void clickDrawerMenu(){
		lnkDrawerMenu.click();
	}
	
	WebElement lnkLogin = androidDriver.findElementById("com.buuuk.st:id/tv_login");
	
	public void clickLoginLink(){
		lnkLogin.click();
	}
	
	WebElement txtUsername = androidDriver.findElementById("com.buuuk.st:id/et_ldap_login_username");
	WebElement txtPassword = androidDriver.findElementById("com.buuuk.st:id/et_ldap_login_password");
	WebElement btnContinue = androidDriver.findElementById("com.buuuk.st:id/btn_ldap_login_continue");
	
	public void defaultLogin(){
		Config config = new Config();
		try {
			txtUsername.sendKeys(config.readConfig("username"));
			txtPassword.sendKeys(config.readConfig("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		btnContinue.click();		
	}
	
	public void login(String username, String password){
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnContinue.click();
	}
	
	WebElement lnkLoginName = androidDriver.findElementById("com.buuuk.st:id/tv_login_name");
	WebElement lnkHome = androidDriver.findElementById("com.buuuk.st:id/iv_home");
	
	public Boolean isValidLogin(String username){
		Boolean status = false;
		if (lnkLoginName.getText().trim().equalsIgnoreCase(username)){
			status = true;
		}
		lnkHome.click();
		return status;
	}
	
	List<MobileElement> thumbnailImage = androidDriver.findElementsById("com.buuuk.st:id/article_image_back");
	
	public Boolean isMainaArticleImageAvailable(){
		Boolean status = false;
		if(thumbnailImage.size() == 1){
			status = true;
		}
		return status;
	}
	
	WebElement lnkThumbnailImage = androidDriver.findElementById("com.buuuk.st:id/article_image_back");
	
	public void clickMainArticle(){
		lnkThumbnailImage.click();
	}
	
	List<MobileElement> headLine = androidDriver.findElementsById("com.buuuk.st:id/article_headline");
	List<MobileElement> image = androidDriver.findElementsById("com.buuuk.st:id/article_image");
	
	public Boolean isHeadlineAvailable(){
		Boolean status = false;
		if(headLine.size() == 1){
			status = true;
		}
		return status;
	}
	
	public Boolean isArticleImageAvailable(){
		Boolean status = false;
		if(image.size() == 1){
			status = true;
		}
		return status;
	}


}
