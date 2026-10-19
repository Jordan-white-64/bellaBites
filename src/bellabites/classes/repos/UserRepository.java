/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes.repos;

import bellabites.classes.User;
import bellabites.classes.Staff;
import bellabites.classes.Customer;
import bellabites.classes.Customer;
import bellabites.classes.Staff;
import bellabites.classes.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 500143322
 */
public class UserRepository {

    private HashMap<String, User> users;

    private String filename;
    private Gson gson;

    public UserRepository() {
        filename = "users.json";
        gson = new GsonBuilder().setPrettyPrinting().create();
        users=new HashMap<>();
        users=loadAllUsers();

    }

    public HashMap<String, User> loadAllUsers() {

        File file = new File(filename);

        if (!file.exists()) {
            return new HashMap<String, User>();
        } else {

            Reader reader;
            try {
                reader = new FileReader("users.json");
                Type type = new TypeToken<Map<String, JsonObject>>() {}.getType();

                Map<String, JsonObject> usersJson = gson.fromJson(reader, type);
                for (String email : usersJson.keySet()) {
                      User user;

                    JsonObject userData = usersJson.get(email);

                    String userType = userData.get("userType").getAsString();

                    //int id = userData.get("id").getAsInt(); 
                    String fullName = userData.get("fullName").getAsString();
                    
                    

                    String password = userData.get("password").getAsString();

                  

                    if (userType.equals("customer")) {

                        int custId = userData.get("custId").getAsInt();
                         String address=userData.get("address").getAsString();
                         String phoneNo=userData.get("phoneNo").getAsString();
                         
                        
                        

                        

                         user = new Customer(custId, fullName, email, password, address, phoneNo); 
                         
                    } else { // staff 

                        String staffId = userData.get("staffId").getAsString();

                       

                         user = new Staff( staffId,   fullName,  email,  password) ;
                    }

                     users.put(email, user); 
                     
                }
                return users;

            } catch (FileNotFoundException ex) {
                Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public void saveAllusers() {
        

        Map<String, JsonObject> usersJson = new HashMap<>();

        for (String email : users.keySet()) {

            User user = users.get(email);

            JsonObject userData = new JsonObject();            

            userData.addProperty("fullName", user.getFullName());
            
           

            userData.addProperty("password", user.getPassword());
            

            if (user instanceof Customer) {

                Customer customer = (Customer) user;
                

                userData.addProperty("userType", "customer");
                
                

                userData.addProperty("custId", customer.getCustId());

                userData.addProperty("phoneNo", customer.getPhoneNo());

                userData.addProperty("address", customer.getAddress());

            } else if (user instanceof Staff) {

                Staff staff = (Staff) user;
                
               

                userData.addProperty("userType", "staff");
                
               

                userData.addProperty("staffId", staff.getStaffId());

                

            }

            usersJson.put(email, userData);

        }

        Writer writer;
        try {
            writer = new FileWriter("users.json");
        

             gson.toJson(usersJson, writer);

        writer.close();
        } catch (IOException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean emailExists(String email) {
        System.out.println("  in email found");
        
       return users.containsKey(email);
       
        
    }

    public User findByEmail(String email) {
            if (emailExists(email)){
                User user=users.get(email);
                return user;
            }
            return null;
    }
    
    
    public void addUser(User user){
        users.put(user.getEmail(), user);
        
}
    public int countUsers(){
        return users.size();
        
    }
    
    public void printAllUsers(){
    
    String userList ="";
    for(String key: users.keySet()){
       User u = users.get(key);
        System.out.println(u.getFullName());    
        
        
      }
    
    

}

    @Override
    public String toString() {
        return "UserRepository{" + "users=" + users + ", gson=" + gson + '}';
    }

}
