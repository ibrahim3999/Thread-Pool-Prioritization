# Ex2_oop

## Part 1:
## Classes
#### `Ex2_1` The Ex2_1 class provides methods for counting the number of lines in a file or array of files. It has four main methods:

  1. `countLines(String filename)` - this method takes a file name as input and returns the number of lines in the file.

  2. `getNumOflines(String[] fileNames)` - this method takes an array of file names and returns the total number of lines in all of the files.

  3. `createTextFiles(int n, int seed, int bound)` - this method creates n text files with a specified number of lines. The number of lines in each file is determined by   a random number generator with a given seed and bound.

  4. `getNumOfLinesThreadPool(String[] fileNames)` and `getNumOfLinesThreads(String[] fileNames)` - these methods take an array of file names and return the total number   of lines in all of the files, using either a thread pool or individual threads, respectively.
#### `LinesCounterTask`
The `LinesCounterTask` class implements the `Callable` interface and is used to count the number of lines in a file as part of a thread pool. It has a single field, `Path`, which represents the file path of the file to be processed. The `call()` method of this class returns the number of lines in the file specified by the Path field. This method simply calls the countLines() method of the Ex2_1 class, passing in the Path field as an argument.

## UML Diagrams:
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/src/UML/Pic/UML.jpg)

## Test
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/1000_10000.jpg)
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/1000_100000.jpg)
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/100_10.jpg)
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/100_1000.jpg)
![](https://github.com/ibrahim3999/Ex2_oop/blob/master/Pic/RunTimeTest/10_100.jpg)
