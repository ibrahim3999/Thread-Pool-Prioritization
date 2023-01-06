package src;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class CustomExecutor {
    private final static int NUM_THREADS=2;
    private final ExecutorService threadPool;
    private final PriorityBlockingQueue<Task> queue;

    public CustomExecutor() {
        this.threadPool = Executors.newFixedThreadPool(NUM_THREADS);
        this.queue = new PriorityBlockingQueue<>();
    }

    public <V> void submit(Callable task, TaskType taskType ) {
        Task<V> t = new Task<V>(task);
        t.setType(taskType);
        queue.put(t);
        threadPool.submit(t);
    }
    public  void submit(Task task ) {
        queue.put(task);
        threadPool.submit(task);
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public PriorityBlockingQueue<Task> getQueue() {
        return queue;
    }

}







