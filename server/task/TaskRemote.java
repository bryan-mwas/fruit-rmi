package server.task;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TaskRemote extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
