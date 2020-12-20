package client;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import server.task.TaskRemote;

public class ClientService {
    public static void addFruit(TaskRemote task) throws RemoteException {
        System.out.print("Enter fruit name: ");
        Scanner sc = new Scanner(System.in);
        String fruitName = sc.nextLine();
        System.out.print("Enter fruit price: ");
        Double fruitPrice = sc.nextDouble();
        AddFruitPrice addFruitPrice = new AddFruitPrice(new Fruit(fruitName, fruitPrice));
        ArrayList<Fruit> fruits = task.executeTask(addFruitPrice);
        System.out.println(fruits);
    }

    public static void updateFruit(TaskRemote task) throws RemoteException {
        UpdateFruitPrice updateFruitPrice = new UpdateFruitPrice(0, new Fruit("Pineapple", 7.99));
        ArrayList<Fruit> fruits = task.executeTask(updateFruitPrice);
        System.out.println(fruits);
    }
    
    public static void deleteFruit(TaskRemote task) throws RemoteException {
        DeleteFruitPrice deleteFruitTask = new DeleteFruitPrice(0);
        String response = task.executeTask(deleteFruitTask);
        System.out.println(response);
    }

    public static void calculateTotalCost(TaskRemote task) throws RemoteException {
        CalFruitCost deleteFruitTask = new CalFruitCost();
        Double response = task.executeTask(deleteFruitTask);
        System.out.println(response);
    }

    public static void printReceipt(TaskRemote task) throws RemoteException {
        PrintReceipt deleteFruitTask = new PrintReceipt();
        ArrayList<Fruit> response = task.executeTask(deleteFruitTask);
        System.out.println(response);
    }
}
