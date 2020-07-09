package com.crm.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Asish
 *
 */
public class WebdriverCommonLib {

	/**
	 * This Method is use to wait for the static element to be loaded in UI
	 * 
	 * @param driver
	 *            : We are passing the Webdriver reference
	 */

	public void waitToPageLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

}
