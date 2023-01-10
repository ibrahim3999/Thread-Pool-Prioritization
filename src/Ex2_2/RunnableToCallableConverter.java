package src.Ex2_2;

import java.util.concurrent.*;

public class RunnableToCallableConverter<T> extends ThreadPoolExecutor {

    private TaskType type;

    public RunnableToCallableConverter(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        type = ((FutureTaskAdapter<?>) r).getTask().getType();
        System.out.println(type);

    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        FutureTaskAdapter futureTaskAdapter=new FutureTaskAdapter<>(callable);
        return futureTaskAdapter;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunnableToCallableConverter threadPool = new RunnableToCallableConverter(3, 10, 300, TimeUnit.MICROSECONDS, new PriorityBlockingQueue<>());
        Task <Object>myTask = Task.createTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return 1;
            }
        }, TaskType.OTHER);
        Task <Object>myTask2 = Task.createTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return 6;
            }
        }, TaskType.COMPUTATIONAL);
        Task <Object>myTask3 = Task.createTask(new Callable() {
            @Override
            public Object call() throws Exception {

                return 5;
            }
        }, TaskType.IO);
       // RunableTaskType runableTaskType=new RunableTaskType<>(myTask);
       Future f1= threadPool.submit(myTask);
        Future f2=threadPool.submit(myTask2);
        Future f3= threadPool.submit(myTask3);
       // System.out.println(adapterFuctreTask.getTask().getType().getPriorityValue());
        //threadPool.beforeExecute(Thread.currentThread(),threadPool.getQueue().peek());

        threadPool.shutdown();
    }

}