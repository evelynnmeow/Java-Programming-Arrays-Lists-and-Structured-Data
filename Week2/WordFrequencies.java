
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (Jingjie M.) 
 * @version (June 2)
 */
import edu.duke.*;
import java.util.*;
// determines unique words and their frequencies
public class WordFrequencies {
    // two private variables
    // store unique words in a file
    private ArrayList<String> myWords;
    // store the number of occurrence for each words
    private ArrayList<Integer> myFreqs;
    // constructor
    public WordFrequencies() {
        myWords = new ArrayList<String> ();
        myFreqs = new ArrayList<Integer> ();
        
    }
    
    // find unique words and their frequencies
    public void findUnique() {
        // clear myWords and myFreqs
        myWords.clear();
        myFreqs.clear();
        // select a file
        FileResource fr = new FileResource();
        // iterate over every word in the file
        for (String s : fr.words()) {
            // make all words to lowercase
            s = s.toLowerCase();
            // define index
            int index = myWords.indexOf(s);
            // check whether the word has occurred or not
            // if it has not occurred, add to the arraylist
            if (index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            }
            // if it is already in the arraylist
            else{
                // get the frequency of the word
                int value = myFreqs.get(index);
                // add one to it
                myFreqs.set(index, value + 1);
            }
        }
       
    }
    
    // test method
    public void tester() {
        // call the function
        findUnique();
        // print out result
        //System.out.println("words!!!!!");
        System.out.println("The unique number of words in the file is " + myWords.size());
        //for (int i = 0; i < myWords.size(); i++) {
            //System.out.println(myWords.get(i) + ": " + myFreqs.get(i));
        //}
        
        int maxIndex = findIndexOfMax();
        System.out.println("Max Frequency occurs at position " + maxIndex);
        System.out.println("It is " + myWords.get(maxIndex) +" which occurs " + myFreqs.get(maxIndex) + " times");
    }
    
    // returns the index location of the largest value in myFreqs
    public int findIndexOfMax() {
        // start the max with the first element in myFreqs
        int max = myFreqs.get(0);
        // the index of the max
        int maxIdx = 0;
        // iterate through the arraylist
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > max) {
                max = myFreqs.get(i);
                maxIdx = i;
            }
        }
        
        return maxIdx;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
