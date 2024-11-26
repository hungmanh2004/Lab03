import java.util.*;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();  // Renamed to avoid conflict with class name
        //Customer customer = new Customer(store);
        Cart cart = new Cart();  // Properly initializing the Cart object for customer use

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Doraemon", "Animation", "Fujiko F.Fujio", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Tay Du Ky", "Journey", "Ngo Thua An", 180, 18.99f);

        store.addDigitalVideoDisc(dvd1);
        store.addDigitalVideoDisc(dvd2);
        store.addDigitalVideoDisc(dvd3);

        // Customer searches DVDs by interacting with the store manager inventory
        String partialTitle = "raem";
        //ArrayList<DigitalVideoDisc> foundDiscs = customer.searchByTitle(partialTitle);

        // Display search results
        System.out.println("Search results for title containing " + partialTitle + ":");
        for (DigitalVideoDisc disc : store.getAvailableDVDs()) {
            System.out.println(disc.toString());
        }

        // Add DVDs to cart
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();

        // Sort Cart by Title
        cart.sortByTitle();
        System.out.println("\nCart sorted by title:");
        cart.print();

        // Sort Cart by Cost
        cart.sortByCost();
        System.out.println("\nCart sorted by cost:");
        cart.print();

        // Remove an item from cart
        cart.removeDigitalVideoDisc(dvd2);
        System.out.println("\nCart after removing a disc:");
        cart.print();

        // Customer makes a payment
        System.out.println("\nCustomer makes a payment:");
        for(DigitalVideoDisc disc : cart.getItems()) {
            System.out.println(disc.toString());
        }
        System.out.println("Total cost: " + cart.totalCost());

    }
}