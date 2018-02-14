package com.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.pageobjects.androd.pagefactory.ADBaseTest;
import com.pageobjects.webdriver.pagefactory.FWBaseTest;

public class FwOpenDriver extends FWBaseTest implements ADBaseTest {
	
	protected AppiumDriver<MobileElement> androidDriver;
	
	Config config;
	
	private String environment;
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	/** Android driver is not initiating Straitstimes mobile app. 
	 * 	I have tried the same code invoking other apps, and verified the code.
	 * 	I went through internet searching for a reason and from what I understood was this is happening due android:exported="true" in the AndroidManifest.xml
	 * 	Due to this I could not verified the element for andorid app.
	 * 	https://stackoverflow.com/questions/19829507/android-java-lang-securityexception-permission-denial-starting-intent
	 * **/
	
	public void setupAndroidDriver(){
		config = new Config();
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "My Phone");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("noReset", "true");
		try {
			desiredCapabilities.setCapability("udid", config.readConfig("udid"));
			desiredCapabilities.setCapability("platformVersion", config.readConfig("platformVersion"));
			desiredCapabilities.setCapability("appPackage", config.readConfig("appPackage"));
			desiredCapabilities.setCapability("appActivity", config.readConfig("appActivity"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void closeAndroidDriver(){
		androidDriver.closeApp();
	}

}
