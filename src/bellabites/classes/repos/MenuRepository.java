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
import bellabites.classes.MenuItem;
import bellabites.classes.FoodItem;
import bellabites.classes.DrinkItem;
import java.util.LinkedHashMap;

/**
 *
 * @author 500143322
 */
public class MenuRepository {

    private HashMap<Integer,MenuItem> menuItems;
    

    private String filename;
    private Gson gson;

    public MenuRepository() {
        filename = "menu.json";
        gson = new GsonBuilder().setPrettyPrinting().create();
        menuItems=new LinkedHashMap<>();

    }

 public HashMap<Integer, MenuItem> loadMenu() {
        File file = new File(filename);

        if (!file.exists()) {
            return new LinkedHashMap<>();
        }

        try (Reader reader = new FileReader(filename)) {
            Type type = new TypeToken<Map<Integer, JsonObject>>() {}.getType();
            Map<Integer, JsonObject> menuJson = gson.fromJson(reader, type);

            if (menuJson == null) return new LinkedHashMap<>();

            for (int itemId : menuJson.keySet()) {
                JsonObject userData = menuJson.get(itemId);
                if (userData == null) continue;

                // Safely read each property
                String itemType = userData.has("itemType") ? userData.get("itemType").getAsString() : null;
                String name = userData.has("name") ? userData.get("name").getAsString() : "";
                String description = userData.has("description") ? userData.get("description").getAsString() : "";
                double price = userData.has("price") ? userData.get("price").getAsDouble() : 0.0;

                MenuItem menuItem = null;

                if ("food".equalsIgnoreCase(itemType)) {
                    String servingSize = userData.has("servingSize") ? userData.get("servingSize").getAsString() : "";
                    menuItem = new FoodItem(itemId, name, description, price, servingSize);
                } else if ("drink".equalsIgnoreCase(itemType)) {
                    String volume = userData.has("volume") ? userData.get("volume").getAsString() : "";
                    menuItem = new DrinkItem(itemId, name, description, price, volume);
                }

                if (menuItem != null) {
                    menuItems.put(itemId, menuItem);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return menuItems;
    }

   
    public void saveMenu() {
        Map<Integer, JsonObject> menuJson = new LinkedHashMap<>();

        for (int itemId : menuItems.keySet()) {
            MenuItem menuItem = menuItems.get(itemId);
            JsonObject userData = new JsonObject();

            userData.addProperty("itemType", menuItem instanceof FoodItem ? "food" : "drink");
            userData.addProperty("name", menuItem.getName());
            userData.addProperty("description", menuItem.getDescription());
            userData.addProperty("price", menuItem.getPrice());

            if (menuItem instanceof FoodItem) {
                userData.addProperty("servingSize", ((FoodItem) menuItem).getServingSize());
            } else if (menuItem instanceof DrinkItem) {
                userData.addProperty("volume", ((DrinkItem) menuItem).getVolume());
            }

            menuJson.put(itemId, userData);
        }

        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(menuJson, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean itemIdExists(int itemId) {
        System.out.println("  in itemId found");
        
       return menuItems.containsKey(itemId);
       
        
    }

    public MenuItem findById(int Id) {
            if (itemIdExists(Id)){
                MenuItem menuItem=menuItems.get(Id);
                return menuItem;
            }
            return null;
    }
    
    
    public void addItem(MenuItem menuItem){
        menuItems.put(menuItem.getItemId(),menuItem);
        
}
    public int countUsers(){
        return menuItems.size();
        
    }
    
    public void printAllItems(){
    
    
    for(int key: menuItems.keySet()){
       MenuItem menuitem = menuItems.get(key);
        System.out.println(menuitem.toString());    
        
        
      }
}

    @Override
    public String toString() {
        return "UserRepository{" + "menuItems=" + menuItems + ", gson=" + gson + '}';
    }
    
     public Map<Integer, MenuItem> getAll() {
        return menuItems;
    }

}
