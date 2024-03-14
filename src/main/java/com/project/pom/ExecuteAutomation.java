package com.project.pom;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExecuteAutomation {
    static WebDriver driver;
    static Test1 loginPage;

    public static void main(String[] args){
        firtsTest();
    }

    public static void firtsTest(){
        loginPage = new Test1(driver);
        driver = loginPage.cromeDriverConection();
        loginPage.visit("http://localhost:3000/");
        loginPage.loginUser();
        loginPage.toAdminPage();
        if (loginPage.isNavigateAdminPage()){
            System.out.println("Test ok");
        }else {
            System.out.println("Test con fallas");
        }
    }


}
