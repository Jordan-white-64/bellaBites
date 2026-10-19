/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes;

import bellabites.classes.repos.UserRepository;

/**
 *
 * @author 500143322
 */
public class User {
      private UserRepository users;
private BellaBitesSystem campusSystem;
    
   private String fullName;
    private String email;
    private String password;

    public String getFullName() {
        return fullName;
    }

 

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    
    public String getType(){
       return this.getClass().getSimpleName();
    }
    
    
    public User(String fullName, String email,String password){
        this.fullName=fullName;
        this.email=email;
        this.password=password;
    }
    
    
    
    

    @Override
    public String toString() {
        return "User{" + "FullName=" + fullName +  ", email=" + email + ", password=" + password + getType()+'}';
    }
    
    
    
}




