/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Marco
 */
public class User {
    private String cpf;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    
//Getters and Setters ----------------------------------------
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getNumber(){
        return phoneNumber;
    }
    
    public void setNumber(String num){
        this.phoneNumber = num;
    }
    
    public void describeUser(){
        System.out.println(getCpf());
        System.out.println(getName());
        System.out.println(getEmail());
        System.out.println(getPassword());
        System.out.println(getNumber());
    }
    
// ------------------------------------------------------
    
    
}
