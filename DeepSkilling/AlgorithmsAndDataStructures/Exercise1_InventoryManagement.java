import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(productId + " | " + productName + " | Qty: " + quantity + " | Price: " + price);
    }
}

public class Exercise1_InventoryManagement {
    static HashMap<Integer, Product> inventory = new HashMap<>();

    static void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product added successfully");
    }

    static void updateProduct(int id, int quantity, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    static void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    static void displayProducts() {
        for (Product p : inventory.values()) {
            p.display();
        }
    }

    public static void main(String[] args) {
        addProduct(new Product(101, "Laptop", 10, 55000));
        addProduct(new Product(102, "Mouse", 50, 500));
        addProduct(new Product(103, "Keyboard", 30, 1200));

        System.out.println("\nInventory List:");
        displayProducts();

        updateProduct(102, 60, 550);

        deleteProduct(103);

        System.out.println("\nFinal Inventory List:");
        displayProducts();
    }
}