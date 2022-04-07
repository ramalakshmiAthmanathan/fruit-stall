package Models;

public class Fruit {

    private String name;
    private Double price;

    public Fruit(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
