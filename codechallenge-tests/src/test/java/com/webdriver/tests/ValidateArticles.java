package com.webdriver.tests;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.webdriver.pagefactory.FWBaseTest;
import com.pageobjects.webdriver.pagefactory.FWMainArticle;
import com.pageobjects.webdriver.pagefactory.STHomePage;
import com.pageobjects.webdriver.pagefactory.STLoginPage;

public class ValidateArticles extends FWBaseTest {
	
	/** This is an example of POM page factory model without BDD (WEB)
	 * 	Please refer to the src/test/resources/feature for BDD solution
	 * **/
	
	@Test
	public void validateMainArticle() throws FileNotFoundException{
		STHomePage homePage = new STHomePage(driver, wait);
		homePage.gotoHomePage();
		homePage.closeAdIfAvailable();
		homePage.clickLoginLink();
		STLoginPage loginPage = new STLoginPage(driver, wait);
		loginPage.defaultLogin();
		Assert.assertTrue(homePage.isDefaultUserLogged(), "User has logged in properly");
		Assert.assertTrue(homePage.isTopStoryImageAvailable(), "Main Article image available");
		homePage.clickMainArticle();
		FWMainArticle mainArticle = new FWMainArticle(driver, wait);
		Assert.assertTrue(mainArticle.isMainArticleLoaded(), "Main article and the heading loaded properly");
		Assert.assertTrue(mainArticle.isImageOrVideoPresent(), "Image or the video loaded properly in the main article");
	}

}
