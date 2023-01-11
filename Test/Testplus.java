package Test;

import src.Ex2_2.CustomExecutor;
import src.Ex2_2.Task;
import src.Ex2_2.TaskType;

public class Testplus {
    public static void main(String[] args) {

        CustomExecutor customExecutor = new CustomExecutor();
        customExecutor.setMaxPoolSize(1);
        customExecutor.setCorePoolSize(1);
        var task = Task.createTask(() -> {
            System.out.println(customExecutor + "\tCOMPUTATIONAL=1");
            return null;
        }, TaskType.COMPUTATIONAL);
        customExecutor.submit(task);


        var task2 = Task.createTask(() -> {
            System.out.println(customExecutor + "\tIO=2");
            return null;
        }, TaskType.IO);
        customExecutor.submit(task2);


        var task3 = Task.createTask(() -> {
            System.out.println(customExecutor + "\tOTHER=3");
            return null;
        }, TaskType.OTHER);

        customExecutor.submit(task3);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);

        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);

        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);
        customExecutor.submit(task3);
        customExecutor.submit(task);
        customExecutor.submit(task2);

        customExecutor.gracefullyTerminate();

    }


}
