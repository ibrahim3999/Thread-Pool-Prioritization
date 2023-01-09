package src.Ex2_2;

import java.util.concurrent.*;

public class MyThreadPool extends ThreadPoolExecutor {

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
    @Override
    protected void beforeExecute(Thread t,Runnable r)
    {
        super.beforeExecute(t,r);
        Task res = (Task) r;
        FutureTaskAdapter<Task> adpter=new FutureTaskAdapter(r,res);

    }

    public static void main(String[] args) {
        MyThreadPool threadPool=new MyThreadPool(5,10,300,TimeUnit.MICROSECONDS,new PriorityBlockingQueue<>());
        Future<Integer> result1 = threadPool.submit(Task.createTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return 1;
            }
        },TaskType.IO));
        Future<Integer> result2 = threadPool.submit(Task.createTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return 2;
            }
        },TaskType.COMPUTATIONAL));

        //threadPool.beforeExecute(Thread.currentThread(),threadPool.getQueue().peek());

        threadPool.shutdown();
    }

}
