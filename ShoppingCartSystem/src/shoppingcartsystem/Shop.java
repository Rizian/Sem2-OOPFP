package shoppingcartsystem;
import java.util.ArrayList;

public class Shop {
    // Attributes
    private String name;
    private ArrayList<Item> items = new ArrayList<>(20); // Array to store shop items

    // Constructor
    Shop(String name) {
        this.name = name;
    }
    
    // Methods
    public String getName() {
        return name;
    }
    
    public boolean has(String itemname) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemname)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<String> getItemsList() {
        ArrayList<String> outStrList = new ArrayList<>(20);
        for (Item item : items) {
            outStrList.add('\n' + item.toString() + '\n');
        }
        return outStrList;
    }
    
    public Item getItem(String item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(item)) {
                return items.get(i);
            }
        }
        return null;
    }
    
    public String getItemString(String item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(item)) {
                return items.get(i).toString();
            }
        }
        return "Item not found";
    }
    
    public void addItem(String name, int stock, double price) {
        Item newItem = new Item(name, stock, price);
        items.add(newItem);
    }

    
    
    
}
