/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.travaillermi01;

import java.rmi.RemoteException;
import java.rmi.Remote;
public interface InterfaceRMI extends Remote{
    
    public long calculeFact(int n) throws RemoteException;
    
}
