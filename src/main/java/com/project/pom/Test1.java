package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test1 extends Base{

    private By name = By.name("name");
    private By password = By.name("password");
    private By sectionMenuIndex = By.className("section_menu_index");
    private By buttonMenu = By.className("profileAndButtonContainer");
    private By login = By.cssSelector("a[href='#/Login']");
    private By buttonLogin = By.className("btn-dark");
    private By userPicture = By.className("typeUserNav");
    private By newButtonMenu = By.className("nav-icon-5");
    private By linkToAdminPage = By.cssSelector("a[href='#/AdminPAge']");
    private By linkToUsersAdmin = By.className("element4");
    private By pageAdmin = By.className("sectionAdmin");
    private By tagsTd = By.tagName("td");


    public Test1(WebDriver driver) {
        super(driver);
    }

    public void loginUser(){
        waitForItem(this.sectionMenuIndex);
        if (isDisplayed(this.sectionMenuIndex)){
            click(this.buttonMenu);
            click(this.login);
            waitForItem(this.password);
            if (isDisplayed(this.password)){
                type("Admin",this.name);
                type("3118514322s",this.password);
                click(this.buttonLogin);
            }
        }else{
            System.out.println("El test a fallado");
        }
    }
    public void toAdminPage(){
        waitForItem(this.userPicture);
        click(this.newButtonMenu);
        click(this.linkToAdminPage);
        waitForItem(this.pageAdmin);
        scrollY(1);
        waitForItem(this.linkToUsersAdmin);
        click(this.linkToUsersAdmin);
    }
    public Boolean isNavigateAdminPage(){
        waitForItem(this.tagsTd);
        return validateTags("Juan Diaz",this.tagsTd);
    }

}
