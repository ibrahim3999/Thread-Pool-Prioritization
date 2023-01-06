package src;
import java.util.concurrent.Callable;

public class Task<V> implements Callable<V> ,Comparable<Task<V>>{
    private final Callable<V> task;
    private TaskType type;
    public Task(Callable<V> task) {
        this.task = task;
    }

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
}
