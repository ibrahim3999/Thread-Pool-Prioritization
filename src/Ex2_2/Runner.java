package src.Ex2_2;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // create a custom executor
        CustomExecutor executor = new CustomExecutor();

        // add some tasks to the queue
        Future<Integer> result1 = executor.submit(() -> {
            Thread.sleep(5000);
            // do some work
            return 1;
        }, TaskType.COMPUTATIONAL);System.out.println(executor.getCurrentMax());
        Future<Integer> result2 = executor.submit(() -> {
            Thread.sleep(1000);
            // do some work
            return 2;
        }, TaskType.IO);

        Future<Integer> result3 = executor.submit(() -> {
            Thread.sleep(10000);
            // do some work
            return 3;
        }, TaskType.COMPUTATIONAL);
        Future<Integer> result4 = executor.enqueueTask(() -> {
            Thread.sleep(10000);
            // do some work
            return 3;
        }, TaskType.COMPUTATIONAL);


        System.out.println(executor.getCurrentMax());

        // gracefully terminate the executor
        executor.gracefullyTerminate();
    }
}