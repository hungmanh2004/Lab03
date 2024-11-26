import java.util.*;

public class Cart {
    private ArrayList<DigitalVideoDisc> items = new ArrayList<>();
    private static final int MAX_NUMBERS_ORDERED = 20;

    // Them DVD vào gio hang
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (items.size() < MAX_NUMBERS_ORDERED) {
            items.add(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (items.size() < MAX_NUMBERS_ORDERED) {
                items.add(disc);
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (items.size() < MAX_NUMBERS_ORDERED - 2) {
            items.add(dvd1);
            items.add(dvd2);
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
    public void print() {
        System.out.println("Ordered Items: ");
        for (DigitalVideoDisc disc : items) {
            System.out.println(disc.toString());
        }
        System.out.println("Total cost: " + totalCost());
    }

    public void print(int id) {
        for (DigitalVideoDisc disc : items) {
            if(disc.isMatch(id)) {
                System.out.println(disc.toString());
            }
            else {
                System.out.println("No disc found");
            }
        }
    }

    public void print(String title) {
        for (DigitalVideoDisc disc : items) {
            if(disc.isMatch(title)) {
                System.out.println(disc.toString());
            }
            else {
                System.out.println("No disc found");
            }
        }
    }

    // Getter to access items in the cart
    public ArrayList<DigitalVideoDisc> getItems() {
        return items;
    }
}