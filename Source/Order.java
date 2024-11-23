public class Order {
    private String orderId;
    private Customer customer;
    private float totalCost;
    private String status;
    private String deliveryLocation;

    // Constructor
    public Order(String orderId, Customer customer, float totalCost, String deliveryLocation) {
        this.orderId = orderId;
        this.customer = customer;
        this.totalCost = totalCost;
        this.deliveryLocation = deliveryLocation;
        this.status = "Pending";
    }

    // Các phương thức getter và setter
    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Tinh phi giao hang dua tren vi tri
    public float calculateDeliveryFee() {
        float deliveryFee;
        switch (deliveryLocation.toLowerCase()) {
            case "noi thanh":
                deliveryFee = 10;
                break;
            case "ngoai thanh":
                deliveryFee = 20;
                break;
            case "quoc te":
                deliveryFee = 50;
                break;
            default:
                deliveryFee = 0;
                System.out.println("Unknown location. Defaulting delivery fee to 0.");
        }
        return deliveryFee;
    }

    // hien thi thong tin don hang
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Delivery Location: " + deliveryLocation);
        System.out.println("Order Status: " + status);
    }
}
