
/**
 * Write a description of wordPlay here.
 * 
 * @author (Jingjie Ma) 
 * @version (V1@May28)
 */
import edu.duke.*;
public class wordPlay {
    public void main() {
        System.out.println("It should be true: " + isVowel('O'));
        System.out.println("It should be true: " + isVowel('a'));
        System.out.println("It should be false: " + isVowel('F'));
        System.out.println("It should be true: " + isVowel('e'));
        System.out.println(replaceVowels("Hello World", '*'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
    }
    
    // check whether a char is a vowel
    public boolean isVowel (char ch) {
        char newCh = Character.toLowerCase(ch);
        if ("aeiou".indexOf(newCh) != -1) {
            return true;
        }
        else{
            return false;
        }
    }
    
    // replace all vowels in the phrase with a ch
    public String replaceVowels (String phrase, char ch) {
        StringBuilder s = new StringBuilder(phrase);
        int i;
        // loop through the string
        for (i = 0; i < s.length(); i++) {
            boolean checkVowel = isVowel(s.charAt(i));
            if (checkVowel) {
                s.setCharAt(i, ch);
            }
        }
        return s.toString();
    }
    
    // the method will return a string that is the string phrase but with the 
    // Char ch replaced by * for odd number location and + for even number location
    public String emphasize (String phrase, char ch) {
        StringBuilder s = new StringBuilder(phrase);
        char newCh = Character.toLowerCase(ch);
        // loop through the string
        for (int i = 0; i < s.length(); i++) {
            char currentCh = Character.toLowerCase(s.charAt(i));
            // check if ch exists
            if (currentCh == newCh) {
                // check location
                if (i % 2 == 0) {
                    s.setCharAt(i, '*');
                }
                if (i % 2 == 1) {
                    s.setCharAt(i, '+');
                }
            }
        }
        return s.toString();
    }
    
    
            
        
        
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
