/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes;

/**
 *
 * @author 500143322
 */
public class OrderLine {
    
    private int menuitemId; 
    private String name;
    private double price; 
    private int qauntity;
    private double lineTotal;

    
    //created manually and from json
    public OrderLine(int menuitemId, String name, double price, int qauntity) {
        this.menuitemId = menuitemId;
        this.name = name;
        this.price = price;
        this.qauntity = qauntity;
        this.lineTotal = price*qauntity;
    }

    public int getMenuitemId() {
        return menuitemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQauntity() {
        return qauntity;
    }

    public double getLineTotal() {
        return price*qauntity;
    }
    
    
    public void decreaseQauntity(){
        qauntity=qauntity-1;
        
    }
    
    public void increaseQauntity(int i){
        qauntity+=i;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}





 

