/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author korisnik
 */
public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {
    public StudentServiceImpl() throws RemoteException{
        super();
    }
    
    @Override
    public String getStudent(String name, String surname, Integer age) throws RemoteException {
        return "Student " + name + " " + surname + " with age: " + age + " has been received!";
    }
} 
