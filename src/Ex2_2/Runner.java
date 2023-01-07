package src.Ex2_2;

import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        CustomExecutor CE = new CustomExecutor();
        var task3 = Task.createTask(() -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.OTHER);
        var task1 = Task.createTask(() -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.COMPUTATIONAL);
        var task2 = Task.createTask(() -> {
            int sum = 0;
            for (int i = 1; i <= 2; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.IO);

        /**
        ArrayList<Future>f =new ArrayList<>();
        f.add( CE.submit(task1));
        f.add( CE.submit(task2));
        f.add(CE.submit(task3));
        f.add(CE.submit(task1));
        for (Future i:f)
        {
            Thread.sleep(3000);
            System.out.println(CE.getThreadPool().getQueue().size());
            System.out.println(i.isDone());
            System.out.println(i.resultNow());
        }
        CE.gracefullyTerminate();
        System.out.println(CE.getThreadPool());


         **/
        PriorityBlockingQueue <Task>queue=new PriorityBlockingQueue();
        queue.add(task1);
        queue.add(task2);
        queue.add(task3);
        System.out.println(queue.poll().getType().getPriorityValue());
        System.out.println(queue.poll().getType().getPriorityValue());
        System.out.println(queue.poll().getType().getPriorityValue());
    }
}

