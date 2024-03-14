/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.automation;

/**
 *
 * @author juann
 */
public class Main {
    public static void main(String[] args){
        TestAutomation testAutomation = new TestAutomation();
        try {
            testAutomation.setUp();
            testAutomation.testLogin();
            testAutomation.testAdminPage();
            //testAutomation.tearDown();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
