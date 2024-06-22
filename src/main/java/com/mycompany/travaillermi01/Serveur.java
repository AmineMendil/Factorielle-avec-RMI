/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.travaillermi01;
import java.rmi.Naming;
import java.rmi.registry.*;
import java.util.Scanner;

public class Serveur {
    public static void main(String[] args) {
        try {
            
            Factorielle fact = new Factorielle();
            LocateRegistry.createRegistry(1099);
            System.out.println("Serveur en ligne...");
            
            Naming.rebind("rmi://localhost:1099/factorielle", fact);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
