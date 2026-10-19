/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes;

/**
 *
 * @author 500143322
 */
public class FoodItem extends MenuItem {
    
    
    private String servingSize;
    private String itemType;
    
    //created manually
    public FoodItem(String name, String description, double price,String servingSize){
        super(name,description,price);
        this.servingSize=servingSize;
        this.itemType="food";
        
        
    }
    
    
    
    //created from json
    public FoodItem(int itemId,String name, String description,double price,String servingSize){
        
        super(itemId,name,description,price);
        this.servingSize=servingSize;
        this.itemType="food";
        
        
    }

    public String getServingSize() {
        return servingSize;
    }

    public String getItemType() {
        return itemType;
    }
    
    
    
    
    
}
