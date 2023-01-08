package src.Ex2_2;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.*;

public class CustomExecutor {
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
        this.queue=new PriorityBlockingQueue<>();
        this.corePoolSize = Runtime.getRuntime().availableProcessors()/2;
        this. maxPoolSize =Runtime.getRuntime().availableProcessors()-1;
        this.keepAliveTime=300;
        this.unit=TimeUnit.MICROSECONDS;
        this.threadpool=new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,queue);

    }

    public   <T> Future<T> submit(Callable<T> task, TaskType taskType ) {
        return submit(Task.createTask(task,taskType));

    }

    public <T> Future<T> submit(Task task ) {
        return this.threadpool.submit(task);
    }
    /**
     * @param task
     * add task
    * */
    public void  enqueueTask(Task task)
    {
        this.submit(task);
    }
    /**
     * @param task
     * @@param type
     * create a new Task -->then added
     * */
    public void enqueueTask(Callable task,TaskType type)
    {
        enqueueTask(Task.createTask(task,type));
    }
    /**
     * @param task
     * create a new Task -->then added
     * */
    public void enqueueTask(Callable task)
    {

        enqueueTask(Task.createTask(task,TaskType.IO));
    }
    public ThreadPoolExecutor getThreadPool() {
        return threadpool;
    }

    public PriorityBlockingQueue getQueue() {
        return queue;
    }


    public    String getCurrentMax() {

          Task  topTask = (Task) threadpool.getQueue().peek();
          if (topTask==null)
          {
              return "Empty Queue";
          }
        return "" + topTask.getType().getPriorityValue();
    }

    public void gracefullyTerminate() {
        threadpool.shutdownNow();
    }
}



