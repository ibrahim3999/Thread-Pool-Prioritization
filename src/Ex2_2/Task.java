package src.Ex2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Task<V> implements Comparable<Task<V>>, Callable<V> {
    private  Callable<V> task ;
    private CompletableFuture<V> future;
    private TaskType type;
/**
 * constructor with default precedence
 * */
    private Task(Callable<V> task) {
        this.task = task;
        this.type=TaskType.COMPUTATIONAL;
        this.future=new CompletableFuture<>();
    }
    private  Task(Callable<V> task, TaskType taskType)
    {
        this.type=taskType;
        this.task=task;
        this.future=new CompletableFuture<>();
    }
    /**
     * @param task
     * Factory Method (Design Pattern)
     * */
    public static Task createTask(Callable task,TaskType taskType)
    {
        return new Task(task,taskType);
    }
    public static Task createTask(Callable task)
    {
        return new Task(task,TaskType.OTHER);
    }
    /**
     * A constructor with a priority task
     * */
    public Callable<V> getTask() {
        return task;
    }
    public CompletableFuture<V> getFuture() {
        System.out.println(future);
        return future;
    }

    public V call()  {
        try {
            V res= this.task.call();
            future.complete(res);
           // System.out.println(getType().getPriorityValue());
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int compareTo(Task<V> o) {
      return Integer.compare(getType().getPriorityValue(), o.getType().getPriorityValue());
    }
    public TaskType getType() {
        return type;
    }
    public void setType(TaskType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task=" + task.toString() +
                ", type=" + type +
                '}';
    }
}
