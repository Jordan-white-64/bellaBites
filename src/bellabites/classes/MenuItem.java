/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes;

/**
 *
 * @author 500143322
 */
public class MenuItem {
    private static int nextItemId =1;
    private int itemId;
    private String name;
    private String description;
    private double price;
    
    
    
    
    //creataed manually
    public MenuItem(String name, String description, double price){
        this.name=name;
        this.description=description;
       this.price=price;
       this.itemId=nextItemId++;
       
       
        
    }
//cretaed from json
    public MenuItem(int itemId, String name, String description, double price) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        
        if(itemId>=nextItemId){
            nextItemId=itemId+1;
            
        }
    }

    public static int getNextItemId() {
        return nextItemId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    
    
}
