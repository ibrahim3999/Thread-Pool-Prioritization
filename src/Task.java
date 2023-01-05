package src;
import java.util.concurrent.Callable;

public class Task<V> implements Callable<V> {
    private final Callable<V> task;
    private TaskType type;
    public Task(Callable<V> task, TaskType type) {

        this.task = task;
        this.type=type;
    }

    public Callable<V> getTask() {
        return task;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    @Override
    public V call()  {
        try {
            return this.task.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
