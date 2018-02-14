package com.pageobjects.webdriver.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWBasePage {
	
	public WebDriver driver;
	
	public WebDriverWait wait;

	public FWBasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
	}

	
	public void click(By elementLocation) {
		driver.findElement(elementLocation).click();
	}

	public WebElement element(By elementLocation) {
		return driver.findElement(elementLocation);
	}
	
	public void clearAndSendKeys(WebElement element, String value){
		try {
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean isElementPresentAndVisible(List<WebElement> element){
		Boolean status = false;
		Boolean isElemntPresent = false;
		Boolean isElementVisible = false;
		try {
			if (element.size() != 0){
				isElemntPresent = true;
			}
			for (int x = 0; x < element.size(); x++){
				if (element.get(x).isDisplayed()){
					isElementVisible = true;
				} else {
					isElementVisible = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isElemntPresent && isElementVisible){
			status = true;
		}
		return status;
	}

}
