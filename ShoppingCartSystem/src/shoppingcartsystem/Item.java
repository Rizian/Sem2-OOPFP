package shoppingcartsystem;

public class Item {
    // Attributes
    protected String name;
    protected int stock;
    protected double price;
    
    // Constructors
    Item(String name) {
        this.name = name;
    }
    
    Item(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
    
    // Methods
    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void restock(int num) {
        if (num < 0) {
            num = 0;
        }
        this.stock += num;
        System.out.printf("%s Stock = %d (+%d)", this.name, this.stock, num);
    }
}

