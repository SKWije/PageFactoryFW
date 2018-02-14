package com.pageobjects.androd.pagefactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ADBasePage {
	
	public AppiumDriver<MobileElement> androidDriver;
	
	public ADBasePage(AppiumDriver<MobileElement> androidDriver) {
		this.androidDriver = androidDriver;
	}

}
