import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ShoppingCart {
    private List<CartItem> cart=new ArrayList<>();
    private final int MAX_ITEMS=8;

public void addToCart(Product product,int quantity){
    if(cart.size()>=MAX_ITEMS){
          System.out.println("Cart limit reached! Max " + MAX_ITEMS + " items allowed.");
          return;
    }
    for(CartItem item:cart){
        if(item.getProduct().getId()==product.getId()){
            item.setQuantity(item.getQuantity()+quantity);
              System.out.println("Updated " + product.getName() + " quantity to " + item.getQuantity());
                return;
        }
    }
    cart.add(new CartItem(product, quantity));
     System.out.println(product.getName() + " added to cart.");
}

public void viewCart() {
    if (cart.isEmpty()) {
        System.out.println("\n===== Your Cart =====");
        System.out.println("Cart is empty.");
        return;
    }

    double total = 0;

    System.out.println("\n===== Your Cart =====");
    System.out.printf("%-15s %-10s %-10s %-10s%n", "Product", "Price", "Quantity", "Subtotal");
    System.out.println("--------------------------------------------------");

    for (CartItem item : cart) {
        System.out.printf("%-15s %-10.2f %-10d %-10.2f%n",
                item.getProduct().getName(),
                item.getProduct().getPrice(),
                item.getQuantity(),
                item.getSubTotal());
        total += item.getSubTotal();
    }

    System.out.println("--------------------------------------------------");
    System.out.printf("Total: Rs. %.2f%n", total);
}


public void updateCart(int productId,int newQuantity){
    for(CartItem item:cart){
        if (item.getProduct().getId()==productId) {
            item.setQuantity(newQuantity);
               System.out.println("Updated " + item.getProduct().getName() + " to " + newQuantity);
                return;
        }
    }
         System.out.println("Product not found in cart.");
}

public void removeFromCart(int productId){
    Iterator<CartItem> it=cart.iterator();
    while (it.hasNext()) {
        CartItem item=it.next();
        if(item.getProduct().getId()==productId){
            it.remove();
             System.out.println(item.getProduct().getName() + " removed from cart.");
                return;
        }
        
    }
    System.out.println("Product not found in cart.");
}

public void checkOut(){
    if(cart.isEmpty()){
          System.out.println("Cart is empty. Nothing to checkout.");
            return;
    }
    viewCart();
    cart.clear();
     System.out.println("Thank you for shopping with us! " +
    LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
}
}
