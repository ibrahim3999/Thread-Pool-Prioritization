package src.Ex2_2;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/**
 FutureTaskAdapter is a class that extends the FutureTask class and adds a reference to a Task object.
 @param <V> the type of the result returned by this task
 @author ibrahim,Tair
 @extends FutureTask
 @constructor
 @paramcallable the callable task being wrapped
 */
public class FutureTaskAdapter<V> extends FutureTask<V> {
    private Task task;

    public FutureTaskAdapter(Callable<V> callable) {
        super(callable);
        this.task= (Task)callable;

    }

    public Task getTask() {
        return task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FutureTaskAdapter<?> that = (FutureTaskAdapter<?>) o;
        return Objects.equals(task, that.task);
    }
    @Override
    public int hashCode() {
        return Objects.hash(task);
    }

    @Override
    public String toString() {
        return "FutureTaskAdapter{" +
                "task=" + task +
                '}';
    }
}