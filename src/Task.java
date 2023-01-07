package src;
import java.util.concurrent.Callable;

public class Task<V> implements Callable<V> ,Comparable<Task<V>> {
    private  Callable<V> task ;
    private TaskType type;
/**
 * constructor with default precedence
 * */
    public Task(Callable<V> task) {
        this.task = task;
        this.type=TaskType.COMPUTATIONAL;
    }
    public Task(Callable<V> task, TaskType taskType)
    {
        this.type=taskType;
        this.task=task;
    }
    /**
     * @param task
     * Factory Method (Design Pattern)
     * */
    public static Task createTask(Callable task,TaskType taskType)
    {
        return new Task(task,taskType);
    }
    /**
     * A constructor with a priority task
     * */
    public Callable<V> getTask() {
        return task;
    }
    @Override
    public V call()  {
        try {
            return this.task.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int compareTo(Task<V> o) {
        if(this.type.getPriorityValue()<o.type.getPriorityValue())
        {
            return 1;
        }
        else if(this.type.getPriorityValue()>o.type.getPriorityValue())
        {
            return -1;
        }
        return 0;
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
