package com.project.pom;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.pom.tests.Vehiculos;
import com.project.pom.tests.Vuelos;
import com.project.pom.tests.Hoteles;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Main {
    static WebDriver driver;
    static Vuelos vuelos;
    static Hoteles hoteles;
    static Vehiculos vehiculos;
    public static void main (String[] args){
        menuTest();
    }



    public static void menuTest(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            System.out.println("////Menú principal////");
            System.out.println("1) Vuelos");
            System.out.println("2) Hotel");
            System.out.println("3) Vehiculos");
            System.out.println("0) Salir");
            System.out.print("Ingrese una opción: ");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    vuelos = new Vuelos(driver);
                    driver = vuelos.cromeDriverConection();
                    vuelos.visit("https://ideas.kontroltravel.com/");
                    vuelos.selectAndinsertData();
                    break;
                case 2:
                    hoteles = new Hoteles(driver);
                    driver = hoteles.cromeDriverConection();
                    hoteles.visit("https://ideas.kontroltravel.com/");
                    hoteles.selectAndinsertData();
                    break;

                case 3:
                    vehiculos = new Vehiculos(driver);
                    driver = vehiculos.cromeDriverConection();
                    vehiculos.visit("https://ideas.kontroltravel.com/");
                    vehiculos.selectAndinsertData();
                    break;
            }
            
        }while(option != 0);
        

    }


}
