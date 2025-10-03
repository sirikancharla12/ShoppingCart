import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        Product[] products = {
                new Product(1, "Laptop", 45000),
                new Product(2, "Smartphone", 15000),
                new Product(3, "Headphones", 2000),
                new Product(4, "Keyboard", 1200),
                new Product(5, "Mouse", 800),
                new Product(6, "Charger", 500),
                new Product(7, "USB Cable", 300),
                new Product(8, "Backpack", 2500),
                new Product(9, "Table", 2500)

        };

        ShoppingCart cart = new ShoppingCart();

        while (running) {
            System.out.println("\n====== Shopping Cart ======");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Update Cart");
            System.out.println("5. Remove from Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("====== Available Products ======");
                    for (Product p : products) {
                        System.out.println(p);

                    }
                    break;

                case 2:
                    System.out.println("Enter Product ID: ");
                    int prodid = sc.nextInt();
                    System.out.println("Enter Quantity: ");
                    int qty = sc.nextInt();
                    if (prodid >= 1 && prodid <= products.length) {
                        cart.addToCart(products[prodid - 1], qty);
                    } else {
                        System.out.println("Invalid Product ID.");
                    }
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    System.out.println("Enter Product ID to update: ");
                    int updateId = sc.nextInt();
                    System.out.println("Enter new quantity: ");
                    int newQty = sc.nextInt();
                    cart.updateCart(updateId, newQty);
                    break;
                case 5:
                    System.out.println("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    cart.removeFromCart(removeId);
                    break;
                case 6:
                    cart.checkOut();
                    break;
                case 7:
                    System.out.println("Exited...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
        sc.close();

    }
}