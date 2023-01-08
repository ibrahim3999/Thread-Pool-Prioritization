package src.Ex2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // create a custom executor
        CustomExecutor executor = new CustomExecutor();

        // add some tasks to the queue
        Future<Integer> result1 = executor.submit(() -> {
            // do some work
            return 1;
        }, TaskType.COMPUTATIONAL);
        Future<Integer> result2 = executor.submit(() -> {
            // do some work
            return 2;
        }, TaskType.IO);
        Future<Integer> result3 = executor.submit(() -> {
            // do some work
            return 3;
        }, TaskType.OTHER);

        // check the current max priority task
        System.out.println("Current max priority task: " + executor.getCurrentMax());

        // wait for the tasks to complete
        System.out.println("Result 1: " + result1.get());
        System.out.println("Result 2: " + result2.get());
        System.out.println("Result 3: " + result3.get());

        // gracefully terminate the executor
        executor.gracefullyTerminate();
    }
}