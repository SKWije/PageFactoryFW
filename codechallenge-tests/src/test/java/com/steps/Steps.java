package com.steps;

import org.testng.Assert;

import com.pageobjects.FwOpenDriver;
import com.pageobjects.androd.pagefactory.ADHomePage;
import com.pageobjects.webdriver.pagefactory.FWMainArticle;
import com.pageobjects.webdriver.pagefactory.STHomePage;
import com.pageobjects.webdriver.pagefactory.STLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends FwOpenDriver {

	STHomePage homePage;
	STLoginPage loginPage;
	FWMainArticle mainArticle;
	ADHomePage droidHomepage;
	
	@Given("^Open the \"([^\"]*)\"$")
	public void open_the(String env) throws Throwable {
		setEnvironment(env);
		if(getEnvironment().equalsIgnoreCase("web")){
			openDriver();
			homePage = new STHomePage(driver, wait);
			homePage.gotoHomePage();
			homePage.closeAdIfAvailable();
			homePage.clickLoginLink();
		} else {
			setupAndroidDriver();
			droidHomepage = new ADHomePage(androidDriver);
			droidHomepage.clickDrawerMenu();
			droidHomepage.clickLoginLink();
		}
		
	}

	@When("^Login to the system using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_to_the_system_using_and(String username, String password) throws Throwable {
		if (getEnvironment().equalsIgnoreCase("web")) {
			loginPage = new STLoginPage(driver, wait);
			loginPage.Login(username, password);
		} else {
			droidHomepage.login(username, password);
		}
	}

	@Then("^Validate user login using \"([^\"]*)\"$")
	public void validate_user_login_using(String username) throws Throwable {
		if (getEnvironment().equalsIgnoreCase("web")) {
			Assert.assertTrue(homePage.isUserLogged(username), "User has logged in properly");
		} else {
			droidHomepage.clickDrawerMenu();
			Assert.assertTrue(droidHomepage.isValidLogin(username), "User has logged in properly");
		}
	}
	
	@Then("^Valdate the main article on thumbnail image or video$")
	public void valdate_the_main_article_on_thumbnail_image_or_video() throws Throwable {
		if(getEnvironment().equalsIgnoreCase("web")){
			Assert.assertTrue(homePage.isTopStoryImageAvailable(), "Main Article image available");
		} else{
			Assert.assertTrue(droidHomepage.isMainaArticleImageAvailable(), "Main Article image available");
		}
	}

	@When("^Go to the main article page$")
	public void go_to_the_main_article_page() throws Throwable {
		if(getEnvironment().equalsIgnoreCase("web")){
			homePage.clickMainArticle();
		} else{
			droidHomepage.clickMainArticle();
		}
	}

	@When("^Validate the main article multimedia contents$")
	public void validate_the_main_article_multimedia_contents() throws Throwable {
		if(getEnvironment().equalsIgnoreCase("web")){
			mainArticle = new FWMainArticle(driver, wait);
			Assert.assertTrue(mainArticle.isMainArticleLoaded(), "Main article and the heading loaded properly");
			Assert.assertTrue(mainArticle.isImageOrVideoPresent(), "Image or the video loaded properly in the main article");
		} else {
			Assert.assertTrue(droidHomepage.isHeadlineAvailable(), "Main article and the heading loaded properly");
			Assert.assertTrue(droidHomepage.isArticleImageAvailable(), "Image or the video loaded properly in the main article");
		}
	}
	
}
