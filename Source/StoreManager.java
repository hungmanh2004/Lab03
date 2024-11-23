import java.util.ArrayList;

public class StoreManager {
    private String username;
    private String password;
    private ArrayList<DigitalVideoDisc> storeInventory;
    private ArrayList<Order> pendingOrders;

    // Constructor
    public StoreManager() {
        this.storeInventory = new ArrayList<>();
        this.pendingOrders = new ArrayList<>();
    }

    public StoreManager(String username, String password) {
        this.username = username;
        this.password = password;
        this.storeInventory = new ArrayList<>();
        this.pendingOrders = new ArrayList<>();
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Add DVD to inventory
    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        storeInventory.add(dvd);
        System.out.println("DVD added to inventory: " + dvd.getTitle());
    }

    // Remove DVD from inventory
    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (storeInventory.remove(dvd)) {
            System.out.println("DVD removed from inventory: " + dvd.getTitle());
        } else {
            System.out.println("DVD not found in inventory.");
        }
    }

    // View pending orders
    public void viewPendingOrders() {
        System.out.println("Pending orders:");
        for (Order order : pendingOrders) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Total Cost: " + order.getTotalCost());
        }
    }

    // Process order
    public void processOrder(Order order, boolean approve) {
        if (approve) {
            order.setStatus("Approved");
            System.out.println("Order " + order.getOrderId() + " approved.");
        } else {
            order.setStatus("Rejected");
            System.out.println("Order " + order.getOrderId() + " rejected.");
        }
        pendingOrders.remove(order);
    }

    public ArrayList<DigitalVideoDisc> getAvailableDVDs() {
        return storeInventory;
    }
}