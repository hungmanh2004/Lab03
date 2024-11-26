import java.util.*;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore;

    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (itemsInStore.remove(dvd)) {
        } else {
            System.out.println("DVD not found in inventory.");
        }
    }

    public ArrayList<DigitalVideoDisc> getAvailableDVDs() {
        return itemsInStore;
    }
}
