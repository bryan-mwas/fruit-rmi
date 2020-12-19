package client;

import java.io.Serializable;
import java.util.ArrayList;

import server.task.Task;

public class UpdateFruitPrice implements Task<ArrayList<Fruit>>, Serializable {
     /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Fruit fruit;

    public UpdateFruitPrice (Fruit fruit) {
       this.fruit = fruit;
     }

    public ArrayList<Fruit> execute() {
       return this.fruit.addFruitPrice(fruit);
    }
    
}
