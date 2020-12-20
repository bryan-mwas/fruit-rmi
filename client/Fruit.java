package client;

import java.io.Serializable;
import java.util.ArrayList;

public class Fruit implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String name;
    public Double price;
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
        return "\nname: " + this.name + ", price: " + this.price.toString();
    }

    // OPERATIONS

    public static ArrayList<Fruit> getFruits() {
        return FRUITS;
    }

    public static ArrayList<Fruit> addFruitPrice(Fruit f) {
        FRUITS.add(f);
        return FRUITS;
    }

    public static ArrayList<Fruit> updateFruitPrice(int index, Fruit f) {
        try {
            FRUITS.set(index, f);
            return FRUITS;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("UPDATE: Fruit does not exist.");
            return FRUITS;
        }
    }

    public static String deleteFruitPrice(int index) {
        try {
            Fruit deleted = FRUITS.get(index);
            FRUITS.remove(index);
            return "DELETED: " + deleted.toString();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("DELETE: Fruit does not exist.");
            return "Fruit does not exist.";
        }
    }

    public static Double calFruitCost() {
        Double cost = 0.00;
        for (int i = 0; i < FRUITS.size(); i++) {
            cost += FRUITS.get(i).price;
        }
        return cost;
    }
}
