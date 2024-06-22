/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.travaillermi01;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Factorielle extends UnicastRemoteObject implements InterfaceRMI{
    private HashMap<Integer, Long> factMap;
    
    
    public Factorielle() throws RemoteException{
        super();
        factMap = new HashMap<>();
    }

    @Override
    public long calculeFact(int n) throws RemoteException {
        return factorielleNbr(n);
    }
    
    private long factorielleNbr(int n) throws RemoteException{
        if (n == 0) return 1; 
        if(factMap.containsKey(n)){
            return factMap.get(n);
        }
        
        long fact = n*calculeFact(n-1);
        factMap.put(n, fact);
        return fact;
        
    }

    
    
    
    

    
    
    
}
