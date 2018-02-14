package com.pageobjects.webdriver.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWMainArticle extends FWBasePage {

	public FWMainArticle(WebDriver driver, WebDriverWait wait) {
		super(driver,wait);
		PageFactory.initElements(driver, this);
	}
	
	public Boolean isImageOrVideoPresent(){
		Boolean status = false;
		List<WebElement> videoIframe = null;
		List<WebElement> articleImg = null;
		try {
			videoIframe = driver.findElements(By.cssSelector("section#block-system-main figure > div > iframe"));
			articleImg = driver.findElements(By.cssSelector("section#block-system-main picture > img"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(isElementPresentAndVisible(articleImg) || videoIframe.size() == 1){
			status = true;
		}
		return status;
	}
	
	@FindBys({ @FindBy(how = How.CSS, using = "section#block-system-main h1") })
	private List<WebElement> txtArticleName;
	
	public Boolean isMainArticleLoaded(){
		Boolean status = false;
		if (isElementPresentAndVisible(txtArticleName)){
			status = true;
		}
		return status;
	}
}
