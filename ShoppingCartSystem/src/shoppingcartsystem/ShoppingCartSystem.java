package shoppingcartsystem;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {
    
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>(100);   // Array to store users
        User currentUser;           // Current user using program
        int IDinc = 0;      // Variable to increment ID when creating new user
                            // This is to prevent any collisions in the ID
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        
        // Example case
        Shop store = new Shop("Example Store");
        
        store.addItem("Banana", 230, 3.50);
        store.addItem("Apple", 140, 4.00);
        store.addItem("Coconut", 75, 7.50);
        
        newUser("Test", "McTester-Face", users, IDinc);
        currentUser = setCurrentUser(100000, users);
        
        currentUser.setBalance(250.00);
        
        while (true) {
            System.out.println("what item would you like to buy?\n");
            System.out.println(store.getItemsList()); 
            System.out.print(">> ");
            String itemIn = sc.next();
            if (store.has(itemIn)) {
                System.out.println(store.getItem(itemIn));
                System.out.println("How many would you like to buy?");
                int amountIn = sc.nextInt();
                cart.addTo(store.getItem(itemIn), amountIn);
            }
            System.out.println("Would you like to add anything else?\n> Yes\n> No\n>> ");
            String confirmIn = sc.next();
            if (confirmIn.equalsIgnoreCase("yes")) {
                continue;
            }
            cart.printCart();
            System.out.println("Confirm Purchase?\n> Yes\n> No\n>> ");
            String purchaseIn = sc.next();
            if (purchaseIn.equalsIgnoreCase("yes")) {
                confirmPurchase(currentUser, cart, store);
            }
            
            
            
            
        }
    }
    
    public static void newUser(String firstname, String lastname, ArrayList<User> users, int inc) {
        User newUser = new User(firstname, lastname);
        newUser.setID(100000 + inc);
        users.add(newUser);
        inc++;
    }
    
    public static User setCurrentUser(long ID, ArrayList<User> users) {
        if (!users.isEmpty()) {        // Prevents the code from running if
                                       // there are no users stored
            for (User user : users) {
                if (user.getID() == ID) {
                    return user;
                }
            }
        }
        return null;
    }
    
    public static void confirmPurchase(User user, Cart cart, Shop shop) {
        double totalCost = cart.sumCost();
        if (user.getBalance() < totalCost) {
            System.out.println("INSUFFICIENT FUNDS TO PURCHASE");
            return;
        }
        for (CartItem cartitem : cart.getCartItems()) {
            String name = cartitem.getName();
            shop.getItem(name).sell(cartitem.getAmountOrdered());
        }
        user.subtractBalance(totalCost);
    }
}
