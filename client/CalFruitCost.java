package client;

import server.task.Task;

import java.io.Serializable;

public class CalFruitCost implements Task<Double>, Serializable {

   public CalFruitCost() {
   }

   private static final long serialVersionUID = 1L;

   public Double execute() {
      return Fruit.calFruitCost();
   }

}
