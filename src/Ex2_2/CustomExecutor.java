package src.Ex2_2;


import java.util.concurrent.*;

public class CustomExecutor {


    private final long keepAliveTime;
    private  int corePoolSize;
    private  int maxPoolSize;


    private final PriorityBlockingQueue<Runnable> queue;
    private final TimeUnit unit;

   private final ThreadPoolExecutor threadpool;
   //private  final RunnableToCallableConverter bridge ;
   private int CurrectMax;

    public CustomExecutor() {

        this.keepAliveTime = 300;
        this.corePoolSize = Runtime.getRuntime().availableProcessors() / 2;
        this.maxPoolSize = Runtime.getRuntime().availableProcessors() - 1;
        this. queue = new PriorityBlockingQueue<Runnable>();
        this.unit = TimeUnit.MILLISECONDS;
        this.threadpool=new RunnableToCallableConverter<>(corePoolSize,
                                                            maxPoolSize,
                                                            keepAliveTime,
                                                            unit,
                                                            queue
                                                            );

    }

    public <T> Future<T> submit(Task task ) {
        return this.threadpool.submit(task);
    }
    public   <T> Future<T> submit(Callable<T> task, TaskType taskType ) {
        return submit(Task.createTask(task,taskType));

    }
    public   <T> Future<T> submit(Callable task ) {
        return submit(Task.createTask(task));

    }

    /**
     * @param task
     * add task
    * */
    public  <T>Future<T>  enqueueTask(Task task)
    {
        return this.submit(task);
    }
    /**
     * @param task
     * @return
     * @@param type
     * create a new Task -->then added
     */
    public <T>Future<T> enqueueTask(Callable task, TaskType type)
    {

        return  enqueueTask(Task.createTask(task,type));
    }
    /**
     * @param task
     * create a new Task -->then added
     * */
    public  <T>Future<T>  enqueueTask(Callable task)
    {

       return enqueueTask(Task.createTask(task,TaskType.IO));
    }
    /**
    public ThreadPoolExecutor getThreadPool() {
        return threadpool;
    }
*/
    public PriorityBlockingQueue<Runnable> getQueue() {
        return queue;
    }


    public    int getCurrentMax() {
        return RunnableToCallableConverter.getType();
    }
    public void gracefullyTerminate() {
        threadpool.shutdownNow();
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


}



