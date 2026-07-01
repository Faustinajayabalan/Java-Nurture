class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println(productId + " | " + productName + " | " + category);
    }
}

public class Exercise2_EcommerceSearch {

    // Linear Search
    static void linearSearch(Product[] products, String name) {
        boolean found = false;

        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                System.out.println("Product Found (Linear Search):");
                p.display();
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Product Not Found");
    }

    // Binary Search
    static void binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = name.compareToIgnoreCase(products[mid].productName);

            if (result == 0) {
                System.out.println("Product Found (Binary Search):");
                products[mid].display();
                return;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Product Not Found");
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Camera", "Electronics"),
                new Product(102, "Keyboard", "Accessories"),
                new Product(103, "Laptop", "Electronics"),
                new Product(104, "Mouse", "Accessories"),
                new Product(105, "Phone", "Electronics")
        };

        System.out.println("Linear Search");
        linearSearch(products, "Laptop");

        System.out.println();

        System.out.println("Binary Search");
        binarySearch(products, "Mouse");
    }
}