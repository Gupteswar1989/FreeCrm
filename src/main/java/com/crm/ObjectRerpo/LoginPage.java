package com.crm.ObjectRerpo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericLib.Filelibrary;

public class LoginPage {

	Filelibrary filelibrary;

	@FindBy(name="email")
	private WebElement USERNAME_TesxtBox;

	@FindBy(name = "password")
	private WebElement PASSWORD_TesxtBox;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement loginButton;

	public void LogInToApp() throws Throwable {

		Filelibrary filelibrary = new Filelibrary();

		USERNAME_TesxtBox.sendKeys(filelibrary.getPropertiesObect().getProperty("username"));
		PASSWORD_TesxtBox.sendKeys(filelibrary.getPropertiesObect().getProperty("password"));
		loginButton.click();

	}

}
