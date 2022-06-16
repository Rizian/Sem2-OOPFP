package shoppingcartsystem;

public final class CartItem extends Item {
    private int amountOrdered;
    private double sumPrice;

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
        if (amountOrdered < 0) {
            this.amountOrdered = 0;
        }
    }

    public void setSumPrice() {
        this.sumPrice = this.price * this.amountOrdered;
    }
    
    public void addOrder(int amount) {
        this.amountOrdered += amount;
    }
    
    public void subtOrder(int amount) {
        this.amountOrdered -= amount;
        if (this.amountOrdered < 0) {
            this.amountOrdered = 0;
        }
    }
    
    @Override
    public String toString() {
        String formatStr = String.format("%s\t%.2f\tx %d = %.2f", this.getName(),
            this.getPrice(),this.getAmountOrdered(), this.getSumPrice());
        return formatStr;
    }
    
    CartItem(String name, int stock, double price, int amount) {
        super(name, stock, price);
        this.setAmountOrdered(amount);
        this.setSumPrice();
    }
}
