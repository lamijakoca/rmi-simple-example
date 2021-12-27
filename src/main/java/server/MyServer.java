/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import shared.StudentServiceImpl;

/**
 *
 * @author korisnik
 */
public class MyServer {
    
    public static void main(String args[]) throws Exception{
        Registry reg = LocateRegistry.createRegistry(1099);
        StudentServiceImpl ss = new StudentServiceImpl();
        reg.rebind("SService", ss);
    }
}
