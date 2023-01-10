package src.Ex2_2;


import java.util.concurrent.*;

public class CustomExecutor extends ThreadPoolExecutor{
    private final long keepAliveTime=300;
    private final int corePoolSize=Runtime.getRuntime().availableProcessors()/2;
    private final int maxPoolSize=Runtime.getRuntime().availableProcessors()-1;

    private final PriorityBlockingQueue<Runnable> queue=new PriorityBlockingQueue<Runnable>();
    private final TimeUnit unit=TimeUnit.MICROSECONDS;

  // private final ThreadPoolExecutor threadpool;

    public CustomExecutor() {
        super(Runtime.getRuntime().availableProcessors()/2
                ,Runtime.getRuntime().availableProcessors()-1
                ,300,
                TimeUnit.MICROSECONDS
                ,new PriorityBlockingQueue<>());
        /**
        keepAliveTime=300;
         corePoolSize=Runtime.getRuntime().availableProcessors()/2;
         maxPoolSize=Runtime.getRuntime().availableProcessors()-1;

        PriorityBlockingQueue<Runnable> queue=new PriorityBlockingQueue<Runnable>();
         TimeUnit unit=TimeUnit.MICROSECONDS;
         **/
    }




    public   <T> Future<T> submit(Callable<T> task, TaskType taskType ) {
        return submit(Task.createTask(task,taskType));

    }
/*
    public <T> Future<T> submit(Task task ) {
        return this.threadpool.submit(task);
    }
    */
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


    public    String getCurrentMax() {
        return "";
    }
    public void gracefullyTerminate() {
        super.shutdownNow();
    }
}



