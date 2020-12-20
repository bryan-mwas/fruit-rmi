package client;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

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
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt User to Choose a task
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printWriter.println("CHOOSE TASK");
            printWriter.println("(1) ADD");
            printWriter.println("(2) UPDATE");
            printWriter.println("(3) DELETE");
            printWriter.println("(4) TOTAL COST");
            printWriter.println("(5) RECEIPT");
            printWriter.print("Enter task number: ");
            System.out.print(stringWriter.toString());
            int userInput = scanner.nextInt();
            // Implements the task interface.
            switch (userInput) {
                case 1 -> ClientService.addFruit(task);
                case 2 -> ClientService.updateFruit(task);
                case 3 -> ClientService.deleteFruit(task);
                case 4 -> ClientService.calculateTotalCost(task);
                default -> ClientService.printReceipt(task);
            }
        } catch (RemoteException e) {
            System.err.println("The server appears to be down");
            System.err.println(e.getMessage());
        }
    }
}
