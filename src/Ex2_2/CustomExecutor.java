package src.Ex2_2;

import java.util.concurrent.*;

public class CustomExecutor {
    private final long keepAliveTime;
    private final int corePoolSize;
    private final int maxPoolSize ;

    private final PriorityBlockingQueue queue;

    private final TimeUnit unit;
    private final ExecutorService executor;

    public CustomExecutor() {
        this.queue = new PriorityBlockingQueue<>();
        this.corePoolSize = Runtime.getRuntime().availableProcessors()/2;
        this. maxPoolSize =Runtime.getRuntime().availableProcessors()-1;
        this.keepAliveTime=300;
        this.unit=TimeUnit.MICROSECONDS;

        this.executor=new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,queue);

    }

    public   <T> Future<T> submit(Callable<T> task, TaskType taskType ) {
        return submit(Task.createTask(task,taskType));
    }

    public <T> Future<T> submit(Task<T> task ) {
        return this.executor.submit(task);
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
        return executor;
    }

    public PriorityBlockingQueue<Runnable> getQueue() {
        return queue;
    }


    public String getCurrentMax() {
        return "";
    }

    public void gracefullyTerminate() {
    executor.shutdown();
    }
}







