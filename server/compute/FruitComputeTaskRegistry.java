package server.compute;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import com.sun.jdi.InternalException;

import server.task.TaskRemote;

public class FruitComputeTaskRegistry {

    TaskRemote engine;

    public FruitComputeTaskRegistry(TaskRemote engine) {
        this.engine = engine;
    }

    public void bindToRegistry() {
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {
            System.err.println("RMI registry already launched on this port");
            System.exit(1);
        }

        try {
            TaskRemote stub = (TaskRemote) UnicastRemoteObject.exportObject(engine, 0);
            Naming.rebind("rmi://localhost:1099/Compute", stub);
            System.out.println("SERVER READY");
        } catch (RemoteException e) {
            System.err.println("Have you launched RMI registry already");
            System.exit(2);
        } catch (MalformedURLException e) {
            throw new InternalException("the URL is incorrect");
        }
    }
}
