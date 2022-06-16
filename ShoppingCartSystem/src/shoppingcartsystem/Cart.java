package shoppingcartsystem;
import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> cartItems = new ArrayList<>();

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }
    
    
    public void addTo(Item item, int amount) {
        CartItem newOrder = new CartItem(item.getName(), item.getStock(), item.getPrice(), amount);
        cartItems.add(newOrder);
    }
    
    public void removeOrder(CartItem order) {
        if (cartItems.contains(order)) {
            cartItems.remove(order);
        }
    }
    public void increaseOrder(CartItem order, int amount) {
        order.addOrder(amount);
        order.setSumPrice();
    }
    
    public void reduceOrder(CartItem order, int amount) {
        order.subtOrder(amount);
        if (order.getAmountOrdered() <= 0) {
            this.removeOrder(order);
        }
        order.setSumPrice();
    }
    
    public void clear() {
        cartItems.clear();
    }
    
    public double sumCost() {
        double total = 0.00f;
        for (CartItem item : cartItems) {
            total += item.getSumPrice();
        }
        return total;
    }
    
    public void printCart() {
        for (CartItem item : cartItems) {
            item.toString();
            System.out.println();
        }
        System.out.println();
        System.out.println(String.format("Total cost:\t\t\t%.2f", this.sumCost()));
    }
    
    Cart() {
    }
}
