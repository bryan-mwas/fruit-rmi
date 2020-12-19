package client;

import java.io.Serializable;
import java.util.ArrayList;

import server.task.Task;

public class PrintReceipt implements Task<ArrayList<Fruit>>, Serializable {
   /**
   *
   */
   private static final long serialVersionUID = 1L;

   public PrintReceipt() {
   }

   public ArrayList<Fruit> execute() {
      return Fruit.getFruits();
   }

}
