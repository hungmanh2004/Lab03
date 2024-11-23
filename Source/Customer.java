import java.util.ArrayList;

public class Customer {
    private String name;
    private String address;
    private String email;
    private Cart cart; // Each customer has their own cart
    public StoreManager storeManager; // Association with StoreManager for inventory access

    // Constructor
    public Customer(StoreManager storeManager) {
        this.storeManager = storeManager;
        this.cart = new Cart();
    }

    public Customer(String name, String address, String email, StoreManager storeManager) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.storeManager = storeManager;
        this.cart = new Cart();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    // Search DVD by title in available inventory (case insensitive)
    public ArrayList<DigitalVideoDisc> searchByTitle(String partialTitle) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<>();
        for (DigitalVideoDisc disc : storeManager.getAvailableDVDs()) {
            if (disc.getTitle().toLowerCase().contains(partialTitle.toLowerCase())) {
                result.add(disc);
            }
        }
        return result;
    }

    // Search DVD by category in available inventory (case insensitive)
    public ArrayList<DigitalVideoDisc> searchByCategory(String partialCategory) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<>();
        for (DigitalVideoDisc disc : storeManager.getAvailableDVDs()) {
            if (disc.getCategory().toLowerCase().contains(partialCategory.toLowerCase())) {
                result.add(disc);
            }
        }
        return result;
    }

    // Search DVD by cost in available inventory
    public ArrayList<DigitalVideoDisc> searchByCost(float cost) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<>();
        for (DigitalVideoDisc disc : storeManager.getAvailableDVDs()) {
            if (disc.getCost() <= cost) {
                result.add(disc);
            }
        }
        return result;
    }

    // Add DVD to cart
    public void addToCart(DigitalVideoDisc disc) {
        if (storeManager.getAvailableDVDs().contains(disc)) {
            cart.addDigitalVideoDisc(disc);
            System.out.println("The disc has been added to the cart.");
        } else {
            System.out.println("The disc is not available in the store.");
        }
    }

    // Remove DVD from cart
    public void removeFromCart(DigitalVideoDisc disc) {
        if (cart.getItems().contains(disc)) {
            cart.removeDigitalVideoDisc(disc);
            System.out.println("The disc has been removed from the cart.");
        } else {
            System.out.println("The disc is not in the cart.");
        }
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', address='" + address + "', email='" + email + "'}";
    }
}