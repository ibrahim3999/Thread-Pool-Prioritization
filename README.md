# Ex2_oop

## Part 1:

#### Ex2_1 The Ex2_1 class provides methods for counting the number of lines in a file or array of files. It has four main methods:

  1. `countLines(String filename)` - this method takes a file name as input and returns the number of lines in the file.

  2. `getNumOflines(String[] fileNames)` - this method takes an array of file names and returns the total number of lines in all of the files.

  3. `createTextFiles(int n, int seed, int bound)` - this method creates n text files with a specified number of lines. The number of lines in each file is determined    by   a random number generator with a given seed and bound.

  4. `getNumOfLinesThreadPool(String[] fileNames)` and `getNumOfLinesThreads(String[] fileNames)` - these methods take an array of file names and return the total           number   of lines in all of the files, using either a thread pool or individual threads, respectively.
### LinesCounterTask
The `LinesCounterTask` class implements the `Callable` interface and is used to count the number of lines in a file as part of a thread pool. It has a single field, `Path`, which represents the file path of the file to be processed. The `call()` method of this class returns the number of lines in the file specified by the Path field. This method simply calls the countLines() method of the Ex2_1 class, passing in the Path field as an argument.
### LinesCounterThread 
The `LinesCounterThread` class extends the `Thread` class and is used to count the number of lines in a file using individual threads. It has two fields: `Path`, which represents the file path of the file to be processed, and countLines, which stores the number of lines in the file. The `LinesCounterThread` class does not have a `run()` method implemented, so it will not perform any actions when started as a thread. To count the number of lines in a file using this class, you would need to 
implement the `run()` method and call the appropriate method to count the lines in the file within it.
### Timer
The Timer class is a simple utility class for measuring the elapsed time of a process. It has four main methods:

  1.`start()` - this method records the current time as the start time.
  2.`stop()` - this method records the current time as the end time and calculates the elapsed time as the difference between the start time and end time.
  3.`getElapsedTime()` - this method returns the elapsed time in nanoseconds.
  4.`PrintElapsedTimeInMilliseconds()` and `PrintElapsedTimeInseconds()` - these methods print the elapsed time in milliseconds and seconds, respectively.

The` Timer` class also has a `reset()` method that can be called to reset the start time, end time, and elapsed time to their initial values.

## UML Diagrams:
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/src/UML/Pic/UML.jpg)

## Test
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/1000_10000.jpg)
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/1000_100000.jpg)
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/100_10.jpg)
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/100_1000.jpg)
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/10_100.jpg)
