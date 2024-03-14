/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.automation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.NoSingleSectionException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.*;

/**
 *
 * @author juann
 */
public class TestAutomation {
	private By name = By.name("name");
	private By password = By.name("password");
	private By sectionMenuIndex = By.className("section_menu_index");
	private By buttonMenu = By.className("profileAndButtonContainer");
	private By login = By.cssSelector("a[href='#/Login']");
	private By buttonLogin = By.className("btn-dark");
	private By userPicture = By.className("profileAndButtonContainer");
	private By newButtonMenu = By.className("nav-icon-5");
	private By linkToAdminPage = By.cssSelector("a[href='#/AdminPAge']");
	private By linkToUsersAdmin = By.className("element4");
	private By pageAdmin = By.className("sectionAdmin");
	private By tagsTd = By.tagName("td");

    	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/main/java/chromedriver/chromedriver2.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
	}

	@Test
	public void testLogin(){
		WebDriverWait ewait = new WebDriverWait(driver,10);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(this.sectionMenuIndex));
		if(driver.findElement(this.sectionMenuIndex).isDisplayed()){
			driver.findElement(this.buttonMenu).click();
			driver.findElement(this.login).click();
			ewait.until(ExpectedConditions.visibilityOfElementLocated(this.password));
			if(driver.findElement(this.password).isDisplayed()){
				driver.findElement(this.name).sendKeys("Admin");
				driver.findElement(this.password).sendKeys("3118514322s");
				driver.findElement(this.buttonLogin).click();
			}
		}else{
			System.out.println("No aparece");
		}

	}

	@Test
	public void testAdminPage(){
		WebDriverWait ewait = new WebDriverWait(driver,10);
		ewait.until(ExpectedConditions.visibilityOfElementLocated(this.userPicture));
		if (driver.findElement(this.userPicture).isDisplayed()){
			driver.findElement(this.newButtonMenu).click();
			driver.findElement(this.linkToAdminPage).click();
			ewait.until(ExpectedConditions.visibilityOfElementLocated(this.pageAdmin));
			ewait.until(ExpectedConditions.visibilityOfElementLocated(this.linkToUsersAdmin));
			Dimension windowSize = driver.manage().window().getSize();
			Long scrollHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + (scrollHeight / 2) + ")"); //Con el entero se define hasta donde llega el scroll
			Long newScrollY = (Long) ((JavascriptExecutor) driver).executeScript("return window.scrollY");
			driver.findElement(this.linkToUsersAdmin).click();
			List<WebElement> tdElements = driver.findElements(this.tagsTd);
			for (WebElement item: tdElements){
				String element = item.getText();
				if (element.equals("Juan Diaz")){
					System.out.println("El test pasó");
				}
			}
		}
	}
        
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
