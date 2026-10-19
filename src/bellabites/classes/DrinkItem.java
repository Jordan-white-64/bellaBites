/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bellabites.classes;

/**
 *
 * @author 500143322
 */
public class DrinkItem extends MenuItem {
     
    private String volume;
    private String itemType;
    
    //created manually
    public DrinkItem(String name, String description, double price, String volume){
        super(name,description,price);
        this.volume=volume;
        this.itemType="drink";
        
        
    }
    
    
    
    //created from json
    public DrinkItem(int itemId,String name, String description,double price,String abv){
        
        super(itemId,name,description,price);
        this.volume=abv;
        this.itemType="drink";
        
        
    }    

    public String getVolume() {
        return volume;
    }

    public String getItemType() {
        return itemType;
    }
    
    
   
    
    
}
