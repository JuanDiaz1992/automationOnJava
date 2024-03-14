package com.project.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base {
    private WebDriver driver;
    public Base(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver cromeDriverConection(){
        System.setProperty("webdriver.chrome.driver", "./src/main/java/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        Point position = new Point(400, 0); // Posición en la pantalla
        driver.manage().window().setPosition(position);
        return driver;
    }

    public WebElement finElemet(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElemets(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchContextException e){
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }

    public void waitForItem(By locator){
        WebDriverWait ewait = new WebDriverWait(driver,10);
        ewait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void scrollY(int cant){
        Dimension windowSize = driver.manage().window().getSize();
        Long scrollHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + (scrollHeight / cant) + ")"); //Con el entero se define hasta donde llega el scroll
        Long newScrollY = (Long) ((JavascriptExecutor) driver).executeScript("return window.scrollY");
    }

    public Boolean validateTags(String data,By locator){
        List<WebElement> tdElements = driver.findElements(locator);
        Boolean isLocate = false;
        for (WebElement item: tdElements){
            String element = item.getText();
            if (element.equals(data)){
                isLocate = true;
            }
        }
        return isLocate;
    }
}
