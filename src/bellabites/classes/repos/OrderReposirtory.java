
 
package bellabites.classes.repos;
 
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;

import java.io.File;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.io.Reader;

import java.io.Writer;

import java.lang.reflect.Type;

import java.util.LinkedHashMap;

import bellabites.classes.Order;
 
public class OrderReposirtory {
 
    private LinkedHashMap<Integer, Order> orders;

    private String filename;

    private Gson gson;
 
    public OrderReposirtory() {

        filename = "orders.json";

        gson = new GsonBuilder().setPrettyPrinting().create();

        orders = new LinkedHashMap<>();

        loadOrders();

    }
 
    public LinkedHashMap<Integer, Order> loadOrders() {

        File file = new File(filename);
 
        if (!file.exists()) {

            orders = new LinkedHashMap<>();

            Order.setNextOrderId(0);

            return orders;

        }
 
        try (Reader reader = new FileReader(file)) {

            Type type = new TypeToken<LinkedHashMap<Integer, Order>>() {}.getType();

            orders = gson.fromJson(reader, type);
 
            if (orders == null) {

                orders = new LinkedHashMap<>();

            }
 
            // find highest existing order ID (no streams)

            int maxId = 0;
 
            for (Integer id : orders.keySet()) {

                if (id > maxId) {

                    maxId = id;

                }

            }
 
            Order.setNextOrderId(maxId);
 
            return orders;
 
        } catch (IOException e) {

            e.printStackTrace();

            orders = new LinkedHashMap<>();

            Order.setNextOrderId(0);

            return orders;

        }

    }
 
    public void saveOrders() {

        try (Writer writer = new FileWriter(filename)) {

            gson.toJson(orders, writer);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
 
    public LinkedHashMap<Integer, Order> getOrders() {

        return orders;

    }
 
    public boolean itemIdExists(int itemId) {

        System.out.println("  in itemId found");

        return orders.containsKey(itemId);

    }
 
    public Order findById(int Id) {

        if (itemIdExists(Id)) {

            Order order = orders.get(Id);

            return order;

        }

        return null;

    }
 
    public void addOrder(Order order) {

        orders.put(order.getOrderId(), order);

    }
 
    public int countOrders() {

        return orders.size();

    }
 
    public void printAllorders() {

        for (int key : orders.keySet()) {

            Order order = orders.get(key);

            System.out.println(order.toString());

        }

    }
 
    @Override

    public String toString() {

        return "orderRepository{" + "Orders=" + orders + ", gson=" + gson + '}';

    }

}
 