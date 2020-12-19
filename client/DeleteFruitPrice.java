package client;

import java.io.Serializable;

import server.task.Task;

public class DeleteFruitPrice implements Task<String>, Serializable {
   /**
   *
   */
   private static final long serialVersionUID = 1L;

   private int index;

   public DeleteFruitPrice(int index) {
      this.index = index;
   }

   public String execute() {
      return Fruit.deleteFruitPrice(index);
   }

}
