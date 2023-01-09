package src.Ex2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Runner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // create a custom executor
        CustomExecutor executor = new CustomExecutor();
        while (true)
        {
            if(executor.getCurrentMax()=="Empty Queue")break;
            System.out.println("Current max priority task: " + executor.getCurrentMax());
        }

        // add some tasks to the queue
        Future<Integer> result1 = executor.submit(() -> {
            Thread.sleep(5000);
            // do some work
            return 1;
        }, TaskType.COMPUTATIONAL);
        Future<Integer> result2 = executor.submit(() -> {
            Thread.sleep(5000);
            // do some work
            return 2;
        }, TaskType.IO);
        Future<Integer> result3 = executor.submit(() -> {
            Thread.sleep(5000);
            // do some work
            return 3;
        }, TaskType.OTHER);
        Future<Integer> result4 = executor.submit(() -> {
            Thread.sleep(5000);
            // do some work
            return 4;
        }, TaskType.COMPUTATIONAL);
        Future<Integer> result5 = executor.submit(() -> {
            Thread.sleep(5000);
            // do some work
            return 5;
        }, TaskType.IO);
        Future<Integer> result6 = executor.submit(() -> {
            Thread.sleep(5000);
            // do some work
            return 6;
        }, TaskType.OTHER);

        // check the current max priority task
        System.out.println(executor.getThreadPool());
        System.out.println("Current max priority task: " + executor.getCurrentMax());
        System.out.println(executor.getThreadPool());
        // wait for the tasks to complete
        System.out.println("Result 1: " + result1.get());
        System.out.println("Result 2: " + result2.get());
        System.out.println("Result 3: " + result3.get());


        System.out.println(executor.getThreadPool());
        System.out.println("Result 4: " + result4.get());
        System.out.println("Result 5: " + result5.get());
     //   System.out.println("Result 6: " + result6.get());

        // gracefully terminate the executor
        executor.gracefullyTerminate();
    }
}