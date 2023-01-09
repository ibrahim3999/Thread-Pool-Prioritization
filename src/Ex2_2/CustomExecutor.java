package src.Ex2_2;


import java.util.concurrent.*;

public class CustomExecutor{
    private final long keepAliveTime;
    private final int corePoolSize;
    private final int maxPoolSize ;

    private final PriorityBlockingQueue<Runnable> queue;
    private final TimeUnit unit;
   private final ThreadPoolExecutor threadpool;

    public CustomExecutor() {


        /**
        this.queue=new PriorityBlockingQueue(Collections.singleton(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return Integer.compare(o1.getType().getPriorityValue(), o2.getType().getPriorityValue());
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        }));
         **/
        this.queue= new PriorityBlockingQueue<Runnable>();
        this.corePoolSize = Runtime.getRuntime().availableProcessors()/2;
        this. maxPoolSize =Runtime.getRuntime().availableProcessors()-1;
        this.keepAliveTime=300;
        this.unit=TimeUnit.MICROSECONDS;
        this.threadpool=new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,queue);


    }


    public   <T> Future<T> submit(Callable<T> task, TaskType taskType ) {
        System.out.println(this.getCurrentMax());
        return submit(Task.createTask(task,taskType));

    }

    public <T> Future<T> submit(Task task ) {
        return this.threadpool.submit(task);
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
    public ThreadPoolExecutor getThreadPool() {
        return threadpool;
    }

    public PriorityBlockingQueue<Runnable> getQueue() {
        return queue;
    }


    public    String getCurrentMax() {
    //   super.beforeExecute(Thread.currentThread(),super.getQueue().peek());
        if(threadpool.getQueue().peek()==null)
        {
            return "Empty Queue";
        }
       return""+ threadpool.getQueue().peek();
    }
    public void gracefullyTerminate() {
        threadpool.shutdownNow();
    }
}



