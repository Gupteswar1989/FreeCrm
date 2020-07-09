package com.crm.ObjectRerpo;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AmazonTest {
	
	@Test
	public void amazonTest(){
		
		/*
		 * For Chrome Browserwe need the provied the path
		 */
		System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*
		 * Navigate to amazon.in	
		 */
	    driver.navigate().to("https://www.amazon.in"); 
	    /*
	     * wait statement for page to be loaded in UI 
	     */
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    /*
	     * go to Hamburger Menu and Click on it
	     */
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
		/*
		 * Click on Hello ,Sign in
		 */ 
		driver.findElement(By.xpath("//div[contains(text(),'Hello, Sign in')]")).click();
		/*
		 * After Post click On Hello Sign in ,It Navigate to Login Page,where it ask For username 
		 * Pass the userName Value using SendKeys();
		 */
		driver.findElement(By.name("email")).sendKeys("");
		/*
		 * Click on continue button
		 */
		driver.findElement(By.xpath("//span[@id='continue-announce']")).submit();
		/*
		 * After Post click On continue button ,It will ask for Password 
		 * Pass the password Value using SendKeys();
		 */
		driver.findElement(By.name("password")).sendKeys("");
		/*
		 * Click on login button
		 */
		driver.findElement(By.xpath("//span[@id='auth-signin-button-announce']")).submit();
		/*
		 * After Post click On login button ,It will navigate to Home Page Where Need to Search an item
		 * Pass the Search an item using SendKeys() on Serach Box
		 */
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("one plus8 latest phone"); 
		
		/*
		 * After Entering the Value ,we will get auto suggestion,for that we need to perform KeyBord Operation
		 */
		Actions actions= new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		
		/*
		 * After performing KeyBord Operation,we will get a List of result ,Select one item from the result list, and click on it (I have Choose 1st item )
		 */
		driver.findElement(By.xpath("//span[text()='OnePlus 8 5G (Glacial Green 6GB RAM+128GB Storage)']")).click(); 
		/*
		 * post Selecting the item from result list,a new Window will Open .to Handle New Window ,We need to perform Window Handle Operation 
		 * with the help of getWindowHandles() on Driver Object and Store in to set Reference,because getWindowHandles() returns LinkedHashSet<>
		 * 
		 */
		
		Set<String> set=driver.getWindowHandles();
		
		/*
		 * We need to Collect the session id with the help of Iterator interface,initially its hidden to as 
		 */
		Iterator<String> iterator =set.iterator();
		
		String sessionId1= iterator.next();
		String sessionId2=iterator.next();
		/*
		 * Now We need to Switch to Window with the help of session Id2  by driver.switchTo().window(sessionId2)
		 */
		driver.switchTo().window(sessionId2);
		 
		/*
		 * We need to scroll little bit down because buy-now-button is not visible properly
		 */
		
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window. scrollBy(0,250)");
		
		/*
		 * Click on Bay Now button it will navigate to Deliver address page
		 */
		driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
		/*
		 * by clicking on Deliver to this address, it will  Navigate to  payment page
		 */
		driver.findElement(By.linkText("Deliver to this address")).click();
		
		
		/*
		 * We need to scroll little bit down because EMI Option is not visible properly
		 */
		JavascriptExecutor javascriptExecutor1=(JavascriptExecutor)driver;
		javascriptExecutor1.executeScript("window. scrollBy(0,150)");
	
		/*
		 * Select EMI Option 
		 */
		driver.findElement(By.xpath("//input[@type='radio' and @value='instrumentId=EMI&isExpired=false&paymentMethod=CC&tfxEligible=false']")).click();
	 
		
	}

}
