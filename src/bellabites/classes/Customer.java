/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes;

import java.util.ArrayList;
import bellabites.classes.OrderLine;
import bellabites.classes.repos.UserRepository;

/**
 *
 * @author 500143322
 */
public class Customer extends User {
     private static int nextCustId =1;
     private int custId;
     private String address;
     private String phoneNo;  
     private ArrayList<OrderLine> basket;
     
     
     
     
     
     public Customer(String fullName,String email,String password,String address,String phoneNo){
         
         super(fullName,email,password);
         this.custId=Customer.nextCustId++;
         
         
         this.address=address;
         this.phoneNo=phoneNo;
          this.basket=new ArrayList<OrderLine>();
          
      
         
         
         
     }
     //from json
   
    
   // Constructor for LOADED users (explicit ID from JSON)
    public Customer(int custId, String fullName, String email, String password,String address,String phoneNo) {
        super(fullName,email,password);
        this.custId = custId;
       
        // IMPORTANT: keep nextId ahead of any loaded IDs
        if (custId >= nextCustId) {
            nextCustId = custId + 1;
        }
         this.address = address;
        this.phoneNo = phoneNo;
        this.basket=new ArrayList<OrderLine>();
    }
  
     

    public static int getNextCustId() {
        return nextCustId ;
    }

    public int getCustId() {
        return custId;
    }

    public String getAddress() {
        return address ;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public ArrayList<OrderLine> getBasket(){
        return basket;
    }
    
    public void updateBasket(OrderLine line){
        int id=line.getMenuitemId();
        int q=line.getQauntity();
        boolean found=false;
        for(OrderLine i :basket){
            if(id==i.getMenuitemId()){
                
                i.increaseQauntity(q);
                found=true;
                break;
                
            }
            
              
            
        }
       
                
        
        if(found!=true){  basket.add(line);}
        
    }
    
    public void removeFromBaket(int id){
        for (int i = 0; i < basket.size(); i++) {
            OrderLine l = basket.get(i);
            if (l.getMenuitemId() == id) {
                if (l.getQauntity() >= 2) {
                    l.decreaseQauntity();
                } else {
                    basket.remove(i);
                }
                return;
            }
        }
    }

    public void clearBasket(){
        basket.clear();
    }
   
}



