package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test1 extends Base{
    //Selectores login
    private By username = By.id("userName");
    private By boton = By.id("");
    private By password = By.id("password");
    private By loginButton = By.id("btnLoginBoxAccept");

    //Selectores opciones 
    private By vuelos = By.className("icoPlane");
    private By input1Ciudad = By.id("OrigemText_searchBox_flights_div");
    private By inputFecha = By.id("FechaIni_searchBox_flights_div");
    private By horario1 = By.id("HoraIda_searchBox_flights_div");
    private By inputDestino = By.id("DestinoText_searchBox_flights_div");
    private By inputFechaFinal = By.id("FechaFin_searchBox_flights_div");
    private By option1 = By.className("ui-menu-item");
    private By option2 = By.cssSelector("ul[id=\"ui-id-23\"]>li[class = \"ui-menu-item\"]");
    private By horirario2 = By.id("HoraVolta_searchBox_flights_div");
    private By selectPasager = By.id("selAdults_searchBox_flights_div");
    private By selectNinhos = By.id("selChildren_searchBox_flights_div");
    private By selectBabys = By.id("selBabies_searchBox_flights_div");
    private By cabina = By.id("Cabine_searchBox_flights_div");
    private By moneda = By.id("Currency_searchBox_flights_div");
    private By buttonSearch = By.id("btnSearchByPrice_searchBox_flights_div");
    
    //selectores agendar
    
    private By butonSelect = By.id("buttonSelectGroup_0");
    private By butonreserve = By.cssSelector("span[id=\"btnMakeReserve_0\"]>a[class=\"slidingButton\"]");
    private By buttonAceptar = By.id("btnCerrar");



    public Test1(WebDriver driver) {
        super(driver);
    }

    public void selectAndinsertData() throws InterruptedException {
        
        
        try {
            
            //Login
            escribir("fer.salazar",this.username);
            escribir("1234Godie1987*",this.password);
            click(this.loginButton);

            //Opción Vuelos
            waitForItem(this.vuelos, 120);
            click(this.vuelos);
            escribir("BOG", this.input1Ciudad);
            waitForItem(option1,20);
            click(option1);
            escribir("01-12-2024",this.inputFecha);
        selectOption(2, this.horario1);
            escribir("MAD",this.inputDestino);
            Thread.sleep(1000);
            click(option2);
            escribir("17-12-2024",this.inputFechaFinal);
            selectOption(3,this.horirario2);
            selectOption(2,this.selectPasager);
            selectOption(2,this.selectNinhos);
            selectOption(2,this.selectBabys);
            selectOption(1,this.cabina);
            selectOption(1,this.moneda);
            click(this.buttonSearch);

            //Agendar Vuelo
            waitForItem(this.butonSelect,120);
            click(this.butonSelect);
            waitForItem(this.butonreserve,120);
            click(this.butonreserve);
            waitForItem(this.buttonAceptar,120);
            click(this.buttonAceptar);
            System.out.println("Prueba exitosa");
            
        }catch (Exception e){
            System.out.println("Error al ejecutar el test");
        }

        


    }

}
