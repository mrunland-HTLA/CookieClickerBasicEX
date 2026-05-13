public class Building {
    String name;
    int baseCost;
    double price;
    int count;





    public Building(String name, int baseCost) {
        this.name = name;
        this.baseCost = baseCost;
        this.price = baseCost;
        this.count = 0;

    }

    public double getPrice() {
        price = baseCost * Math.pow(1.05,count);
        return price;
    }
}
