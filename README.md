# Concurrency Assignemnt  

The objective of this assignment was to create a program that generated 100 random genome sequences.
Each sequence should be 10 characters long.
We should also test the program using concurrency and report the differences between
single thread and multithread.

Classes:

1. Main: This class is used for testing purposes
   Input:
   - desired Genome length (in this case 10)
   - genome sequence letters (in this case A, T, G, C)
   - sample size for one thread (in this case 100)
   - sample size for multithread (ex 20 for 5 threads to match the 100 final requirement)
   Ouput:
   - Single Thread test description
   - Multi thread test description

2. RandomStringGenerator: This class is used to create an random gene sequence
   Input:
   - array of characters to use
   - length of the output String
   - name of thread
   - sample size
   Ouput:
   - Array of desired length with a random mix of the characters provided
   - size of sample
   Methods:
   - 2 constructors: the first one is for the single thread application, the second for the multi thread as it need more details
   - create random string: creates a random string based on input of String and number size desired
   - run override from the thread class