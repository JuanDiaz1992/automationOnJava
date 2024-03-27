package com.project.pom;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Main {
    static WebDriver driver;
    static Test1 init1;
    static Test2 init2;
    public static void main (String[] args){
        firtsTest();
    }



    public static void firtsTest(){
        Scanner scanner = new Scanner(System.in);
        int option;

        do{
            
            System.out.println("1) Vuelos");
            System.out.println("2) Hotel");
            System.out.println("0) Salir");
            System.out.print("Ingrese una opción: ");
            option = scanner.nextInt();
            switch(option){
                case 1:
                        try {
                            init1 = new Test1(driver);
                            driver = init1.cromeDriverConection();
                            init1.visit("https://ideas.kontroltravel.com/");
                            init1.selectAndinsertData();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
                case 2:
                        try {
                            init2 = new Test2(driver);
                            driver = init2.cromeDriverConection();
                            init2.visit("https://ideas.kontroltravel.com/");
                            init2.selectAndinsertData();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    break;
            }
            
        }while(option != 0);
        

    }


}
