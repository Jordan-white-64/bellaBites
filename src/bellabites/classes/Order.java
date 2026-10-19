
 
package bellabites.classes;
 
import java.util.ArrayList;
import java.util.Date;
 
public class Order {
    private static int nextOrderId = 0;
    private Date d = new Date();
    private int orderId;
 
    private int customerId;
    private String createdDateTime;
    private String status;
    private double total;
    private ArrayList<OrderLine> orderLines;
 
    // created manually
    public Order(int customerId, ArrayList<OrderLine> orderLines) {
        this.orderId = getNextOrderId();
        this.customerId = customerId;
        this.createdDateTime = getDateTime();
        this.status = "awaiting confirmation";
        this.orderLines = orderLines;
        this.total = calculateTotal();
    }
 
    // created from json
    public Order(int orderId, int customerId, String createdDateTime, String status, double total, ArrayList<OrderLine> orderLines) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.createdDateTime = createdDateTime;
        this.status = status;
        this.total = total;
        this.orderLines = orderLines;
 
        // keep the static counter in sync with the highest loaded ID
        if (orderId > nextOrderId) {
            nextOrderId = orderId;
        }
    }
 
    public static int getNextOrderId() {
        nextOrderId++;
        return nextOrderId;
    }
 
    public int getOrderId() {
        return orderId;
    }
 
    public String getCreatedDateTime() {
        return createdDateTime;
    }
 
    public String getStatus() {
        return status;
    }
 
    public double getTotal() {
        return total;
    }
 
    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }
 
    public double calculateTotal() {
        double total = 0;
 
        for (OrderLine i : orderLines) {
            total += i.getLineTotal();
        }
 
        return total;
    }
 
    private String getDateTime() {
        String date = d.toGMTString();
        return date;
    }
 
    public int getCustId() {
        return customerId;
    }
 
    public void setStatus(String newstatus) {
        status = newstatus;
    }
 
    public static void setNextOrderId(int nextId) {
        nextOrderId = nextId;
    }
}