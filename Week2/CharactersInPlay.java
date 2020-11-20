
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (Jingjie M.) 
 * @version (June 2)
 */
import edu.duke.*;
import java.util.*;
public class CharactersInPlay {
    // name of characters
    private ArrayList<String> charNames;
    // number of occurrence for each character
    private ArrayList<Integer> count;
    
    // update two arraylists
    public void update(String person) {
        int index = charNames.indexOf(person);
        // check if the person exists
        if (index == -1) {
            charNames.add(person);
            count.add(1);
        }
        else{
            int value = count.get(index);
            count.set(index, value + 1);
        }
    
    }
    // constructor
    public CharactersInPlay() {
        charNames = new ArrayList<String> ();
        count = new ArrayList<Integer> ();
    }
    
    // find all characters
    public void findAllCharacters () {
        // clear instance variables
        charNames.clear();
        count.clear();
        // open a file
        FileResource fr = new FileResource();
        // loop through each line
        for (String line : fr.lines()) {
            // change all words to lower case
            line = line.toLowerCase();
            // find the index of period
            int indexPeriod = line.indexOf(".");
            String character = "";
            // if there is a period
            if (indexPeriod != -1) {
                character = line.substring(0, indexPeriod);
                // update the arraylists
                update(character);
                
                
            }
         
        }
        
      
    }
    
    // test method
    public void tester() {
        findAllCharacters();
        for (int i = 0; i < charNames.size(); i++ ) {
            if (count.get(i) >= 10 && count.get(i) < 15) {
                
                System.out.println(charNames.get(i) + ": " + count.get(i));
            }
        }
        
        int num1 = 2;
        int num2 = 3;
        //charactersWithNumParts(num1, num2);
        
    }
   
    // print out names of characters with specific number of speaking parts
    public void charactersWithNumParts (int num1, int num2) {
        for (int i = 0; i < charNames.size(); i++) {
            if (count.get(i) >= num1 && count.get(i) <= num2){
                System.out.println(charNames.get(i));
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    

}
