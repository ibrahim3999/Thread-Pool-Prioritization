# Thread Pool Project:

## PART 1:
It appears that the `Ex2_1` class provides methods for counting the number of lines in a file or array of files. The `countLines` method takes a single file name as input and returns the number of lines in that file. The `getNumOflines` method takes an array of file names and returns the total number of lines in all of the files. The createTextFiles method creates a specified number of text files with a specified number of lines in each file, determined by a random number generator with a given seed and bound. The `getNumOfLinesThreadPool` and `getNumOfLinesThreads` methods both take an array of file names and return the total number of lines in all of the files, but they do so using either a thread pool or individual threads, respectively.
## LinesCounterTask:
The `LinesCounterTask` class implements the `Callable` interface and is used to count the number of lines in a file as part of a thread pool. It has a single field, `Path`, which represents the file path of the file to be processed. The `call()` method of this class returns the number of lines in the file specified by the Path field. This method simply calls the countLines() method of the Ex2_1 class, passing in the Path field as an argument.
## LinesCounterThread :
The `LinesCounterThread` class extends the `Thread` class and is used to count the number of lines in a file using individual threads. It has two fields: `Path`, which represents the file path of the file to be processed, and countLines, which stores the number of lines in the file. The `LinesCounterThread` class does not have a `run()` method implemented, so it will not perform any actions when started as a thread. To count the number of lines in a file using this class, you would need to 
implement the `run()` method and call the appropriate method to count the lines in the file within it.
## Timer:
The `Timer` class is a utility class that can be used to measure the elapsed time of a process. It has four main methods: `start`, `stop`, `getElapsedTime`, `PrintElapsedTimeInMilliseconds`, and `PrintElapsedTimeInSeconds`. The start method records the current time as the start time. The stop method records the current time as the end time and calculates the elapsed time as the difference between the start time and end time. The getElapsedTime method returns the elapsed time in nanoseconds. The `PrintElapsedTimeInMilliseconds` and `PrintElapsedTimeInSeconds` methods print the elapsed time in milliseconds and seconds, respectively. The `reset` method can be called to reset the start time, end time, and elapsed time to their initial values.
## running times: 
```
Number of files : 1000
random bound    :10000
Normal      :16.4844861 seconds
Threads     :0.8438844  seconds
ThreadPool  :0.3196549  seconds
```
```
Number of files : 1000
random bound    :100000
Normal      :30.4173153 seconds
Threads     :7.4111654  seconds
ThreadPool  :1.7832334  seconds
```
 ### Research:
  ``` 
  The thread pool design pattern is generally faster than using individual threads because it reduces the overhead of thread creation and task scheduling.

When you create a new thread to execute a task, there is a certain amount of overhead involved in creating and starting the thread. This includes the time required to allocate memory for the thread's stack and to set up the thread's execution environment. In addition, when a new thread is created, the operating system must also perform task scheduling to determine which thread should be given access to the CPU. All of this overhead can add up and impact the performance of your application, especially if you are creating and starting a large number of threads.

On the other hand, when you use a thread pool, a fixed number of threads are created at the start of the application and are used to execute tasks concurrently. When a task is submitted to the pool, it is queued and executed by the next available thread. This reduces the overhead of thread creation because the threads have already been created and are ready to execute tasks. It also reduces the overhead of task scheduling because the tasks are queued and executed by the available threads rather than having to be scheduled by the operating system.

As a result, the thread pool design pattern can be more efficient than using individual threads because it reduces the overhead of thread creation and task scheduling. It's also worth noting that the performance of a thread pool will depend on a variety of factors, including the number of threads in the pool, the type of tasks being executed, and the available hardware resources.
  ```
## UML PART1:
<img src="https://github.com/ibrahim3999/Ex2_oop/blob/master/src/Ex2_1/UML/Pic/UML.jpg" width="500" height="400">

# PART 2:
This project is an implementation of a thread pool that uses a custom `ThreadPoolExecutor` class and a `PriorityBlockingQueue` to hold tasks before they are executed.

## Classes
- **CustomExecutor** is the main class of the project. It creates a thread pool using the `RunnableToCallableConverter` class and a `PriorityBlockingQueue` to hold the tasks before they are executed. It also has methods to submit and enqueue tasks, gracefully terminate the thread pool, and get the current task priority.

- **RunnableToCallableConverter**  is a class that extends `ThreadPoolExecutor` and overrides its methods to adapt `Runnable` to `Callable`, so it can be executed by the executor. 

- **Task** is a class that implements a `Callable` and `Comparable` interfaces.  It wraps a `Callable` object and keeps track of the task's priority and future.

- **FutureTaskAdapter** is a class that extends the `FutureTask` class and adds a reference to a `Task` object.

## Enums
- **TaskType** is an enumeration that represents the types of tasks that can be submitted to the thread pool.

## Usage

To use the thread pool, create an instance of the `CustomExecutor` class.
```CustomExecutor executor = new CustomExecutor();```

To submit a task, use the `submit()` method. Tasks can be submitted as a `Task` object, a `Callable` object with a task type, or just a `Callable` object.

``` Task<Integer> task = new Task<>(() -> 1```
``` TaskType.COMPUTATIONAL); ```
``` Future<Integer> future = executor.submit(task); ```
## UML PART2:
<img src="https://github.com/ibrahim3999/Ex2_oop/blob/master/src/Ex2_2/UML/Part2.jpg" width="500" height="400">
src/Ex2_2/UML/Part2.jpg