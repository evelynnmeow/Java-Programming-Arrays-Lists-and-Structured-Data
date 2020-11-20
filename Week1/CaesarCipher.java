
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (Jingjie Ma) 
 * @version (v1@May28)
 */
import edu.duke.*;
public class CaesarCipher {
    public void main() {
        //System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        System.out.println(encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.",14, 24));
    }
    
    
    // this method will return the encrypted version of the string
    public String encrypt (String input, int key) {
        // a new StringBuilder object to manipulate the string
        StringBuilder s = new StringBuilder(input);
        // original alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // shifted alphabet by key
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
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
    
    public void testCaesar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 15;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        
    }
    
    public String encryptTwoKeys (String input, int key1, int key2) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            // starting for the first char and every other ones
            if (i % 2 == 0) {
                output = output + encrypt(Character.toString(input.charAt(i)), key1);
               
            }
            else{
                output = output + encrypt(Character.toString(input.charAt(i)), key2);
            }
        }
        return output;
        
                
    }
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
                
                

            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


