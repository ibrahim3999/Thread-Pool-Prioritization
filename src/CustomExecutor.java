package src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CustomExecutor {
    private final long keepAliveTime;
    private final static int NUM_THREADS=2;
    private final int corePoolSize;
    private final int maxPoolSize ;
    private final ExecutorService threadPool;
    private final List<Thread> threads;
    private final PriorityBlockingQueue<Task> queue;
    private volatile boolean running;

    public CustomExecutor() {
        this.threadPool = Executors.newFixedThreadPool(NUM_THREADS);
        this.queue = new PriorityBlockingQueue<>();
        this.corePoolSize = Runtime.getRuntime().availableProcessors()/2;
        this. maxPoolSize =Runtime.getRuntime().availableProcessors()-1;
        this.keepAliveTime=300;
        this.threads=new ArrayList<>();
        this.running=true;

    }

    public   <T>Future<T> submit(Callable<T> task, TaskType taskType ) {
        Task<T> t = new Task(task,taskType);
        queue.put(t);
        Future future =threadPool.submit(t);
        return future;
    }
    public <T>Future<T> submit(Task task ) {
        queue.put(task);
        Future future=threadPool.submit(task);

        return future;
    }

    /**
     * @param task
     * add task
    * */
    public void  enqueueTask(Task task)
    {
        this.queue.add(task);
    }
    /**
     * @param task
     * @@param type
     * create a new Task -->then added
     * */
    public void enqueueTask(Callable task,TaskType type)
    {
        enqueueTask(new Task(task,type));
    }
    /**
     * @param task
     * create a new Task -->then added
     * */
    public void enqueueTask(Callable task)
    {
        enqueueTask(new Task(task));
    }
    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public PriorityBlockingQueue<Task> getQueue() {
        return queue;
    }

    public String getCurrentMax() {
        return ""+getQueue().peek().getType().getPriorityValue();
    }

    public void gracefullyTerminate() {
    threadPool.shutdown();
    }
}







