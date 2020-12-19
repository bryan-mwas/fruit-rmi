package server.compute;

import server.task.Task;
import server.task.TaskRemote;

public class FruitComputeEngine implements TaskRemote {

    public FruitComputeEngine() {}

    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
        TaskRemote engine = new FruitComputeEngine();
        FruitComputeTaskRegistry taskRegistry = new FruitComputeTaskRegistry(engine);
        taskRegistry.bindToRegistry();
    }
}
