package src.Ex2_2;
import java.util.concurrent.*;
/**
 * CustomExecutor is a class that implements a custom thread pool by extending ThreadPoolExecutor
 * and using a PriorityBlockingQueue to hold tasks before they are executed.
 * @author ibrahim,Tair
 * @constructor
 * Creates a thread pool with default parameters, including a keepAliveTime of 300ms,
 * a corePoolSize and maxPoolSize based on the number of available processors,
 * and a PriorityBlockingQueue for holding tasks.
 */
public class CustomExecutor {

    private final long keepAliveTime;
    private int corePoolSize;
    private int maxPoolSize;
    private final PriorityBlockingQueue<Runnable> queue;
    private final TimeUnit unit;

    private final ThreadPoolExecutor threadpool;
    //private  final RunnableToCallableConverter bridge ;
    private int CurrectMax=1;

    public CustomExecutor() {

        this.keepAliveTime = 300;
        this.corePoolSize = Runtime.getRuntime().availableProcessors() / 2;
        this.maxPoolSize = Runtime.getRuntime().availableProcessors() - 1;
        this.queue = new PriorityBlockingQueue<Runnable>();
        this.unit = TimeUnit.MILLISECONDS;
        this.threadpool = new RunnableToCallableConverter<>(corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                queue
        );
    }
    /**
     * submit is a method that submits a task for execution to the thread pool.
     * @param task the task to be executed
     * @return Future representing the result of the task
     */
    public <T> Future<T> submit(Task task) {
        return this.threadpool.submit(task);
    }
    public <T> Future<T> submit(Callable<T> task, TaskType taskType) {
        Task res=Task.createTask(task, taskType);
        return submit(res);

    }
    public <T> Future<T> submit(Callable task) {
        return submit(Task.createTask(task));

    }
    /**
     * enqueueTask is a method that adds a task to the PriorityBlockingQueue.
     * @param task the task to be added
     * @return Future representing the result of the task
     */
    public <T> Future<T> enqueueTask(Task task) {
        return this.submit(task);
    }

    public <T> Future<T> enqueueTask(Callable task, TaskType type) {

        return enqueueTask(Task.createTask(task, type));
    }
    /**
     * @param task create a new Task -->then added
     */
    public <T> Future<T> enqueueTask(Callable task) {

        return enqueueTask(Task.createTask(task, TaskType.IO));
    }
    /**
     * public ThreadPoolExecutor getThreadPool() {
     * return threadpool;
     * }
     */
    public PriorityBlockingQueue<Runnable> getQueue() {
        return queue;
    }
    /**
     * getCurrentMax returns the priority of the currently executing task
     * @return int representing the priority of the currently executing task
     */
    public int getCurrentMax() {
        this.CurrectMax=RunnableToCallableConverter.getType();
        return CurrectMax;
    }
    /**
     * gracefullyTerminate is a method that gracefully shuts down the thread pool.
     * it will wait for all tasks to complete before shutting down
     */
    public void gracefullyTerminate() {
        while (threadpool.getActiveCount()!=0)
        {
            // break no when finish All tasks
        }
        threadpool.shutdown();
    }

    //getter and setter

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public ThreadPoolExecutor getThreadpool() {
        return threadpool;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomExecutor that = (CustomExecutor) o;
        return keepAliveTime == that.keepAliveTime &&
                corePoolSize == that.corePoolSize &&
                maxPoolSize == that.maxPoolSize &&
                queue.equals(that.queue) &&
                unit == that.unit &&
                threadpool.equals(that.threadpool);
    }

    }





