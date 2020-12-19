package server.task;

public interface Task<T> {
    T execute();
}