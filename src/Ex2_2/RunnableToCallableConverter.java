package src.Ex2_2;

import java.util.concurrent.*;

public class RunnableToCallableConverter<T> extends ThreadPoolExecutor {
    private static TaskType type;

    public RunnableToCallableConverter(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        type = ((FutureTaskAdapter<?>) r).getTask().getType();

    }
    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        FutureTaskAdapter futureTaskAdapter=new FutureTaskAdapter<>(callable);
        return futureTaskAdapter;
    }
    public static int getType() {
        return type.getType().getPriorityValue();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Test for me

        RunnableToCallableConverter threadPool = new RunnableToCallableConverter(3, 10, 300, TimeUnit.MICROSECONDS, new PriorityBlockingQueue<>());
        Task <Integer>myTask = Task.createTask(new Callable() {
            @Override
            public Integer call() throws Exception {

                return 1;
            }
        }, TaskType.OTHER);
        Task <Integer>myTask2 = Task.createTask(new Callable() {
            @Override
            public Integer call() throws Exception {
                return 6;
            }
        }, TaskType.COMPUTATIONAL);
        Task <Integer>myTask3 = Task.createTask(new Callable() {
            @Override
            public Integer call() throws Exception {

                return 5;
            }
        }, TaskType.IO);
        Task <Integer>myTask4 = Task.createTask(new Callable() {
            @Override
            public Integer call() throws Exception {

                return 7;
            }
        }, TaskType.IO);
        Task <Integer>myTask5 = Task.createTask(new Callable() {
            @Override
            public Integer call() throws Exception {

                return 100;
            }
        }, TaskType.IO);
        Task <Integer>myTask6 = Task.createTask(new Callable() {
            @Override
            public Integer call() throws Exception {

                return 66;
            }
        }, TaskType.IO);



       // RunableTaskType runableTaskType=new RunableTaskType<>(myTask);
        Future f1= threadPool.submit(myTask);
        Future f2=threadPool.submit(myTask2);
        Future f3= threadPool.submit(myTask3);
         Future f4= threadPool.submit(myTask4);
       // System.out.println(adapterFuctreTask.getTask().getType().getPriorityValue());
        //threadPool.beforeExecute(Thread.currentThread(),threadPool.getQueue().peek());

        threadPool.shutdown();
    }

}