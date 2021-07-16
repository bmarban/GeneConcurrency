
/**
 * Author: Barbara Marban
 * Assignment 4 CS622
 * Date: 08/06/2021
 * Objective: The main purpose of this class is to test to assignment.
 * The assignment was to create 100 random genome sequences of 10 characters.
 * We should use concurrency to make the program faster.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Variables
        String[] items = {"A","T","G","C"};
        int GENOMELENGTH = 10;
        int SAMPLESIZECONC = 100;
        int SAMPLESIZENONCONC = 20;
        String[] sampleNoConc = new String[SAMPLESIZECONC];


        // NO CONCURRENCY
        // Test without concurrency
        long timeNoConc = System.nanoTime();
        RandomStringGenerator testNoConc = new RandomStringGenerator(items, GENOMELENGTH);
        for (int i = 0; i < SAMPLESIZECONC; i++) {
            String genome = testNoConc.createRandomString(); // get random genome sequence
            sampleNoConc[i] = genome; // save sequence into Array
        }

        //Output
        timeNoConc = System.nanoTime() - timeNoConc;
        System.out.format("\nTime for single thread %,d nanoseconds", timeNoConc);
        System.out.println("\nSize of our sample = " + sampleNoConc.length);

        // print all sequences from array
        //for (int i = 0; i < sampleNoConc.length; i++){
            //System.out.println(sampleNoConc[i]);
        //}
        System.out.println("END OF SINGLE THREAD TEST");


        // CONCURRENCY
        long fullTimeConc = System.nanoTime();
        // Create Threads to add genome into our String Array
        Thread t1 = new Thread (new RandomStringGenerator(items, GENOMELENGTH, "T1", SAMPLESIZENONCONC));
        Thread t2 = new Thread (new RandomStringGenerator(items, GENOMELENGTH, "T2", SAMPLESIZENONCONC));
        Thread t3 = new Thread (new RandomStringGenerator(items, GENOMELENGTH, "T3", SAMPLESIZENONCONC));
        Thread t4 = new Thread (new RandomStringGenerator(items, GENOMELENGTH, "T4", SAMPLESIZENONCONC));
        Thread t5 = new Thread (new RandomStringGenerator(items, GENOMELENGTH, "T5", SAMPLESIZENONCONC));

        // start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // using join to print final time at the end and make sure calculation only runs after every thread is done
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        //output
        fullTimeConc = System.nanoTime() - fullTimeConc;
        System.out.format("\n\nTotal time for 5 threads = %,d nanoseconds", fullTimeConc);
        System.out.println("\nEND OF MULTI THREAD TEST");
    }
}
