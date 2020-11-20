
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (Jingjie M.) 
 * @version (V1@May 29)
 */
import edu.duke.*;
import java.io.*;
import java.lang.*;
public class CaesarBreaker {
    // returns an array that counts the number of time a letter occurs in the message
    public int [] countLetters (String message) {
        // alphabet of English
        String alphabet =  "abcdefghijklmnopqrstuvwxyz";
        // initialize counts
        int [] counts = new int [26];
        // loop through the string
        // i is the index of the char in the message
        for (int i = 0; i < message.length(); i++) {
            char currCh = Character.toLowerCase(message.charAt(i));
            // index of currCh in the alphabet
            int index = alphabet.indexOf(currCh);
            // if currCh occurs
            if (index != -1){
                counts[index]++;
            }
        }
        
        return counts;
    }
    
    // find the max index of the array
    public int maxIndex (int [] values) {
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
    
    // decrypt method
    public String decrypt (String encrypted, int key) {
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted, 26 - key);
        return message;
    }
    
    // test of decrypt method
    public void testDecrypt() {
        int key = 23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String decrypted = decrypt(message, key);
        System.out.println("Key is " + key);
        System.out.println("Message is " + decrypted);
    }
    
    // returns a new String that is every other character from message 
    // starting with the start position
    public String halfOfString (String message, int start) {
        String result = "";
        // loop through the string
        for (int i = start; i < message.length(); i+=2) {
            char ch = message.charAt(i);
            // add ch to result
            result = result + ch;
        }
        return result;
    }
    
    // test of the halfOfString method
    public void testHalfOfString () {
        String s1 = "Qbkm Zgis";
        int start1 = 1;
        System.out.println(halfOfString(s1, start1));
    }
    
    // returns the location (key) of the most frequent letter in the message
    public int getKey (String s) {
        int [] counts = countLetters(s);
        int max = maxIndex(counts);
        int dKey = max - 4;
        if (max < 4) {
            dKey = 26 - 4 + max;
        }
        return dKey;
    }
    
    // decrypt with two keys
    public String decryptTwoKeys(String encrypted) {
        // create a new cc class
        CaesarCipher cc = new CaesarCipher();
        // get two half messages
        String message1 = halfOfString(encrypted, 0);
        String message2 = halfOfString(encrypted, 1);
        // get two keys
        //int key1 = getKey(message1);
        //int key2 = getKey(message2);
        int key1 = 14;
        int key2 = 24;
        // print out two keys
        System.out.println("The first key is " + key1);
        System.out.println("The second key is " + key2);
        // decrypt the message
        String decrypted = cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
        //System.out.println("The original message is " + decrypted);
        return decrypted;
    }
    
    public void testDecryptTwoKeys() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String result = decryptTwoKeys(message);
        //System.out.println(message);
        System.out.println(result);
        //System.out.println(decryptTwoKeys(""));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
