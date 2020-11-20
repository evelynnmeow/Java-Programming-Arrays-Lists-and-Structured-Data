
/**
 * Write a description of CaesarCipherOO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherOne {
    // fields
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    // constructor
    public CaesarCipherOne (int key) {
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(mainKey) + alphabet.substring(0, mainKey);
    }
    
    // encrypt method
    public String encrypt (String input) {
        StringBuilder s = new StringBuilder(input);
        // loop through the input string
        for (int i = 0; i < s.length(); i++) {
            // for the i-th char in s
            char currCh = s.charAt(i);
            // get the index of char of the orginal alphabet
            int index;
            // check whether currCh is upper case
            if (Character.isUpperCase(currCh)) {
                index = alphabet.indexOf(currCh);
            }
            else{
                index = alphabet.toLowerCase().indexOf(currCh);
            }
            // if the char is in the alphabet
            if (index != -1) {
                char newCh;
                // if the currCh is upper case
                if (Character.isUpperCase(currCh)) {
                    newCh = shiftedAlphabet.charAt(index);
                }
                else{
                    newCh = shiftedAlphabet.toLowerCase().charAt(index);
                }
                
                s.setCharAt(i, newCh);
            }
        }
        return s.toString();
    }
    
    public String decrypt (String input) {
        CaesarCipher cc = new CaesarCipher();
        
        String message = cc.encrypt(input, 26 - mainKey);
        return message;
    }
    
}
