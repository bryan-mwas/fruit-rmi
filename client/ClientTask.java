package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.task.TaskRemote;

public class ClientTask {
    public static void main(String[] args) {
        String url = null;
        TaskRemote task = null;
        try {
            url = "rmi://localhost:1099/Compute";
            task = (TaskRemote) Naming.lookup(url);
        } catch (MalformedURLException e) {
            System.err.println("The URL " + url + "is incorrect");
            System.exit(1);
        } catch (RemoteException e) {
            System.err.println("Have you launched the RMI registry?");
            System.exit(2);
        } catch (NotBoundException e) {
            System.err.println("Have you launched the server?");
            System.exit(2);
        }

        try {
            // Implements the task interface.
            switch (args[0]) {
                case "ADD" -> ClientService.addFruit(task);
                case "UPDATE" -> ClientService.updateFruit(task);
                case "DELETE" -> ClientService.deleteFruit(task);
                case "TOTAL COST" -> ClientService.calculateTotalCost(task);
                default -> ClientService.printReceipt(task);
            }
        } catch (RemoteException e) {
            System.err.println("The server appears to be down");
            System.err.println(e.getMessage());
        }
    }
}
