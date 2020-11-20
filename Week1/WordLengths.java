
/**
 * Write a description of WordLengths here.
 * 
 * @author (Jingjie M.) 
 * @version (V1@May 29)
 */
import java.lang.*;
import edu.duke.*;
public class WordLengths {
    // will return the most common word length in the file
    public void countWordLengths (FileResource fr, int [] counts) {
        int wordLen = 0;
        for (String word : fr.words()) {
            // the raw word length without excluding any chars
            wordLen = word.length();
            // if the start of the word is not a letter
            if (!Character.isLetter(word.charAt(0))){
                wordLen--;
            }
            // if the end of the word is not a letter
            if (!Character.isLetter(word.charAt(word.length() - 1))){
                wordLen--;
            }
            // increment the counts
            counts[wordLen]++;
        }
        
        // the value of the most common length
        int index = 0;
        index = indexOfMax(counts);
        System.out.println("The most common word length is " + index);
    }
    
    // test of the countWordLengths method
    public void testCountWordLengths() {
        int [] counts = new int[31];
        FileResource fr = new FileResource();
        countWordLengths(fr, counts);
        
        
    }
    
    public int indexOfMax (int [] values) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                index = i;
            }
            
        }
        return index;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
