/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.*;
import shared.StudentService;

/**
 *
 * @author korisnik
 */
public class MyClient implements ActionListener{
    JFrame frame;
    JPanel panel;
    JLabel labelName;
    JLabel labelSurname;
    JLabel labelAge;
    JLabel labelMark;
    JTextField txtName;
    JTextField txtSurname;
    JTextField txtAge;
    JTextField txtMark;
    JButton button;
    JTextArea area;
    
    static StudentService student;
    
    public void GUI(){
        frame = new JFrame("Simple Client-Server App");
        panel = new JPanel();
        labelName = new JLabel("Name: ");
        labelSurname = new JLabel("Surname: ");
        labelAge = new JLabel("Age: ");
        labelMark = new JLabel("Mark: ");
        txtName = new JTextField();
        txtSurname = new JTextField();
        txtAge = new JTextField();
        txtMark = new JTextField();
        button = new JButton();
        area = new JTextArea();

        labelName.setBounds(10,10,90,21);
        labelSurname.setBounds(10,35,90,21);
        labelAge.setBounds(10,65, 90,21);
        labelMark.setBounds(10,95,90,21);

        txtName.setBounds(105,10,90,21);
        txtSurname.setBounds(105,30,90, 21);
        txtAge.setBounds(105,60,90,21);
        txtMark.setBounds(105,90,90,21);

        button.setText("Process");
        button.setBounds(215,40,90,21);
        button.addActionListener(this);

        area.setBounds(100,150,290,120);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        panel.add(labelName);
        panel.add(labelSurname);
        panel.add(labelAge);
        panel.add(labelMark);
        panel.add(txtName);
        panel.add(txtSurname);
        panel.add(txtAge);
        panel.add(txtMark);
        panel.add(button);
        panel.add(area);
        panel.setLayout(null);

        frame.setSize(450,450);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        process();
    }
    public void process() {
        String name, surname;
        Integer age, mark;
        try{
            Registry regs = LocateRegistry.getRegistry("localhost", 1099);
            student =(StudentService) regs.lookup("SService");
            
            name = txtName.getText();
            surname = txtSurname.getText();
            age = Integer.parseInt(txtAge.getText());
            mark = Integer.parseInt(txtMark.getText());
            
            String result = student.getStudent(name, surname, age);
            area.setText(result);
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        MyClient client = new MyClient();
        client.GUI();
    }
}
