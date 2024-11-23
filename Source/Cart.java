import java.util.ArrayList;
import java.util.Comparator;

public class Cart {
    private ArrayList<DigitalVideoDisc> items = new ArrayList<>();
    private static final int MAX_NUMBERS_ORDERED = 20;

    // Them DVD vào gio hang
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (items.size() < MAX_NUMBERS_ORDERED) {
            items.add(disc);
        }
    }

    // Xoa DVD khoi gio hang
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        items.remove(disc);
    }

    // Tinh tong chi phi cua gio hang
    public float totalCost() {
        float total = 0;
        for (DigitalVideoDisc disc : items) {
            total += disc.getCost();
        }
        return total;
    }

    // Sap xep gio hang theo ten
    public void sortByTitle() {
        items.sort(Comparator.comparing(DigitalVideoDisc::getTitle).thenComparing(Comparator.comparing(DigitalVideoDisc::getCost).reversed()));
    }

    // Sap xep gio hang theo chi phi
    public void sortByCost() {
        items.sort(Comparator.comparing(DigitalVideoDisc::getCost).reversed().thenComparing(DigitalVideoDisc::getTitle));
    }

    // Hien thi tat ca thong tin cua DVD trong gio hang
    public void displayCart() {
        System.out.println("Current cart:");
        for (DigitalVideoDisc disc : items) {
            System.out.println("Title: " + disc.getTitle() + ", Category: " + disc.getCategory() +
                               ", Director: " + disc.getDirector() + ", Length: " + disc.getLength() +
                               ", Cost: " + disc.getCost());
        }
        System.out.println("Total cost: " + totalCost());
    }

    // Getter to access items in the cart
    public ArrayList<DigitalVideoDisc> getItems() {
        return items;
    }
}