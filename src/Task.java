package src;
import java.util.concurrent.Callable;

public class Task <T,V> implements Callable<V> {
    private final T type;

    private final int priority;

    public Task(T type, int priority) {
        this.type = type;
        this.priority = priority;

    }
    @Override
    public V call() throws Exception {
        return null;
    }

    public int getPriority() {
        return priority;
    }
    public T getType() {
        return type;
    }

    public static void main(String[] args) {

    Task<Integer,Integer> task=new Task<Integer,Integer>(1,3);
        System.out.println(task.getPriority());

    }
}
