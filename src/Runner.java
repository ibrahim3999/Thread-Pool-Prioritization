package src;

public class Runner {
    public static void main(String[] args) {


        CustomExecutor CE=new CustomExecutor();
        var task1 = Task.createTask(()->{
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.COMPUTATIONAL);
        var task2 = Task.createTask(()->{
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.OTHER);
        var task3 = Task.createTask(()->{
            int sum = 0;
            for (int i = 1; i <= 2; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.IO);
        CE.submit(task1);
        CE.submit(task2);
        CE.submit(task3);


      while (CE.getQueue().isEmpty()!=true)
      {
          System.out.println("priority number :"+CE.getQueue().peek().getType().getPriorityValue());
          System.out.println(CE.getQueue().poll().call());
      }

        System.out.println(CE.getThreadPool());
      CE.gracefullyTerminate();


    }

}


