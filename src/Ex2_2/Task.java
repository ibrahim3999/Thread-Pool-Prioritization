package src.Ex2_2;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
/**
 Task is a class that implements the Callable interface, and wraps around another Callable task.
 Additionally, it associates a TaskType and a CompletableFuture with the task.
 @param <V> the type of the result returned by this task
 @author ibrahim,Tair
 @implements Callable, Comparable<Task<V>>
 @constructor private (Factory Design Pattern)
 @paramtask the callable task being wrapped
 @paramtaskType the type of the task
 @static methods
 @method createTask(Callable task,TaskType taskType) : return a new Task with specific taskType
 @method createTask(Callable task) : return a new Task with other taskType
 */
public class Task<V> implements Comparable<Task<V>>, Callable<V> {
    private  Callable<V> task ;
    private CompletableFuture<V> future;
    private TaskType type;

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

    public static Task createTask(Callable task,TaskType taskType)
    {
        return new Task(task,taskType);
    }
    public static Task createTask(Callable task)
    {
        return new Task(task,TaskType.OTHER);
    }
    /**
     * getTask method returns the task associated with this Task.
     *
     * @return Callable<V>
     */
    public Callable<V> getTask() {
        return task;
    }
    /**
     * getFuture method returns the CompletableFuture associated with this Task.
     *
     * @return CompletableFuture<V>
     */
    public CompletableFuture<V> getFuture() {
        System.out.println(future);
        return future;
    }
    /**
     * call method execute the wrapped task, and set the future complete with the result
     *
     * @return V
     * @throws Exception if the wrapped task execution throws an exception, it will be propagated through call method
     */
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

    public TaskType getType() {
        return type;
    }
    public void setType(TaskType type) {
        this.type = type;
    }
    /**
     * compareTo method compares two Tasks by their taskType priority
     *
     * @param o the task to be compared with
     * @return int, the result is negative if this task has lower priority than o, positive if this task has higher priority than o, and 0 if they have the same priority.
     */
    @Override
    public int compareTo(Task<V> o) {
        return Integer.compare(getType().getPriorityValue(), o.getType().getPriorityValue());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task<?> task1 = (Task<?>) o;
        return Objects.equals(task, task1.task) &&
                type == task1.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, type);
    }

    @Override
    public String toString() {
        return "Task{" +
                "task=" + task.toString() +
                ", type=" + type +
                '}';
    }
}
