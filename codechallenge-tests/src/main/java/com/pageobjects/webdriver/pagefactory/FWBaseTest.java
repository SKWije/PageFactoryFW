package com.pageobjects.webdriver.pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWBaseTest {
	
	public WebDriver driver;
	
	public WebDriverWait wait;
    
    private String systemDir = System.getProperty("user.dir");
	
	private String chromePath = systemDir + "\\src\\test\\resources\\config\\drivers\\chromedriver.exe";
 
    //@Before
    public void openDriver() {
    	System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,15);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    //@After
    public void closeDrivers() {
        driver.quit();
    }

}
