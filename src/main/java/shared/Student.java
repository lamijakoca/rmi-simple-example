/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shared;

import java.io.Serializable;

/**
 *
 * @author korisnik
 */
public class Student implements Serializable{
    private String name;
    private String surname;
    private Integer age;
    private Integer mark;
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public Integer getAge(){
        return age;
    }
    
    public void setAge(Integer age){
        this.age = age;
    }
    
    public Integer getMark(){
        return mark;
    }
    
    public void setMark(Integer mark){
        this.mark = mark;
    }
}
