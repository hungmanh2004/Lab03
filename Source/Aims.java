import java.util.ArrayList;

public class Aims {
    public static void main(String[] args) {
        StoreManager storeManager = new StoreManager();  // Renamed to avoid conflict with class name
        Customer customer = new Customer(storeManager);  // Passing storeManager instance to the customer
        Cart cart = new Cart();  // Properly initializing the Cart object for customer use

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Doraemon", "Animation", "Fujiko F.Fujio", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tay Du Ky", "Journey", "Ngo Thua An", 180, 18.99f);

        storeManager.addDigitalVideoDisc(dvd1);
        storeManager.addDigitalVideoDisc(dvd2);
        storeManager.addDigitalVideoDisc(dvd3);

        // Customer searches DVDs by interacting with the store manager inventory
        String partialTitle = "raem";
        ArrayList<DigitalVideoDisc> foundDiscs = customer.searchByTitle(partialTitle);

        // Display search results
        System.out.println("Search results for title containing \"" + partialTitle + "\":");
        for (DigitalVideoDisc disc : foundDiscs) {
            System.out.println("Title: " + disc.getTitle() + ", Category: " + disc.getCategory() + ", Director: " + disc.getDirector() + ", Length: " + disc.getLength() + ", Cost: $" + disc.getCost());
        }

        // Add DVDs to cart
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        cart.displayCart();

        // Sort Cart by Title
        cart.sortByTitle();
        System.out.println("\\nCart sorted by title:");
        cart.displayCart();

        // Sort Cart by Cost
        cart.sortByCost();
        System.out.println("\\nCart sorted by cost:");
        cart.displayCart();

        // Remove an item from cart
        cart.removeDigitalVideoDisc(dvd2);
        System.out.println("\\nCart after removing a disc:");
        cart.displayCart();

        // Customer makes a payment
        Payment payment = new Payment("Tran Manh Hung", 50.00f, 100.00f);
        if (payment.processPayment()) {
            payment.displayTransactionDetails();
        } else {
            System.out.println("Payment failed.");
        }

        // Manager processes orders
        storeManager.viewPendingOrders();
    }
}