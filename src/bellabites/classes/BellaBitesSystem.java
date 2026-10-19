/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes;


import bellabites.classes.repos.UserRepository;
import bellabites.classes.User;
import bellabites.classes.Staff;
import bellabites.classes.Customer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import bellabites.forms.StaffHome;

/**
 *
 * @author 500143322
 */
public class BellaBitesSystem {

    private UserRepository users;

    public BellaBitesSystem(UserRepository users) {
        this.users = users;

    }

    public BellaBitesSystem() {
        this.users = new UserRepository();

    }

    public void RegisterCustomer(Customer customer) {
        users.loadAllUsers();
        users.addUser(customer);
        users.saveAllusers();
        System.out.println("users saved");

    }

    public void RegisterStaff(Staff Staff) {
        users.loadAllUsers();
        users.addUser(Staff);
        users.saveAllusers();
        System.out.println("users saved");
    }

    public User Login(String email, String pass) {
        //ensure users loaded         

        users.loadAllUsers();
        System.out.println("users loaded" + users.countUsers());
        if(users.emailExists(email)){
            User user = users.findByEmail(email);
            if (user !=null){
                if(user.getPassword().equals(pass)){
                    return user;
                }
            }
        }
        
       
       return null;

    }

}