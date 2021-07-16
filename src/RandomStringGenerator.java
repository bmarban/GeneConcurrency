import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Author: Barbara Marban
 * Assignment 4 CS622
 * Date: 08/06/2021
 * Objective: This class is used to generate a random string of a certain length with an input of 4 strings
 */

public class RandomStringGenerator implements Runnable{
    private String[] items;
    private int length;
    private String[] genome;
    private int sampleSize;
    private String name;


    // Constructor
    public RandomStringGenerator (String[] items, int length) {
        this.items = items;
        this.length = length;

        //length of the genome we require
        String[] genome = new String[length];
        this.genome = genome;
    }

    // Constructor 2
    public RandomStringGenerator (String[] items, int length, String name, int sampleSize) {
        this.items = items;
        this.length = length;
        this.name = name;
        this.sampleSize = sampleSize;

        //length of the genome we require
        String[] genome = new String[length];
        this.genome = genome;
    }

    //Create random string
    public String createRandomString() {
        /**
         * This method creates a random sequence given the inputs from the constructor.
         */
        // create a random number between 0 and length for indexing
        // use the index to pick one of the characters provided and add to empty Array
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            int randInt = rand.nextInt(items.length);
            genome[i] = items[randInt];
        }
        return Arrays.toString(genome);
    }

    @Override
    public void run() {
        String[] sampleConc = new String[sampleSize];

        for (int i = 0; i < sampleSize; i++) {
            String genome = createRandomString(); // get random genome sequence
            sampleConc[i] = genome; // save sequence into Array
        }

        System.out.format("\nSize of sample %s = %d", name, sampleConc.length);
    }
}
