package client;

import java.io.Serializable;
import java.util.ArrayList;

public class Fruit implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String name;
    public Double price = 0.00;
    private static ArrayList<Fruit> FRUITS = new ArrayList<Fruit>();

    public Fruit(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "\nname: "+ this.name + ", price: "+ this.price.toString();
    }

    // OPERATIONS

    public ArrayList<Fruit> addFruitPrice(Fruit f) {
        FRUITS.add(f);
        return FRUITS;
    }
}
