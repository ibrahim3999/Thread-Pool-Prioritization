package src.Ex2_2;

import java.util.Objects;
import java.util.concurrent.*;
/**
 RunnableToCallableConverter is a class that extends ThreadPoolExecutor and overrides its methods
 to adapt Runnable to Callable, so it can be executed by the executor.
 @param <T> the type of the value that the task returns
 @author ibrahim,Tair
 @extends ThreadPoolExecutor
 @constructor
 @paramcorePoolSize the number of threads to keep in the pool, even if they are idle.
 @parammaximumPoolSize the maximum number of threads to allow in the pool.
 @paramkeepAliveTime when the number of threads is greater than the core, this is the maximum time that excess idle threads will wait for new tasks before terminating.
 @paramunit the time unit for the keepAliveTime argument
 @paramworkQueue the queue to use for holding tasks before they are executed.
 */

public class RunnableToCallableConverter<T> extends ThreadPoolExecutor {
    private static TaskType type;

    public RunnableToCallableConverter(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);

    }
/**
    beforeExecute is a method in ThreadPoolExecutor that is called before the execution of a task.
    This method is overridden to set the task type.
    @param t the thread that will run task r.
    @param r the task that will be executed
 */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        type = ((FutureTaskAdapter<?>) r).getTask().getType();
    }
      /**

    newTaskFor is a method in ThreadPoolExecutor that creates a RunnableFuture for the given callable.
    This method is overridden to create and return a FutureTaskAdapter.
    @param callable the callable task being wrapped
    @return FutureTaskAdapter<T>
    */
    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        FutureTaskAdapter futureTaskAdapter=new FutureTaskAdapter<>(callable);
        return futureTaskAdapter;
    }
    /**
        getType is a static method that returns the priority of the task type.
        @return int
    */
    public static int getType() {
        if(type==null)
        {
            return 0;
        }
        return type.getType().getPriorityValue();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunnableToCallableConverter<?> that = (RunnableToCallableConverter<?>) o;
        return getCorePoolSize() == that.getCorePoolSize() &&
                getMaximumPoolSize() == that.getMaximumPoolSize() &&
                getKeepAliveTime(TimeUnit.NANOSECONDS) == that.getKeepAliveTime(TimeUnit.NANOSECONDS) &&
                getQueue().equals(that.getQueue());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCorePoolSize(), getMaximumPoolSize(), getKeepAliveTime(TimeUnit.NANOSECONDS), getQueue());
    }
    @Override
    public String toString() {
        return "RunnableToCallableConverter{}";
    }
}