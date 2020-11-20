
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherOne {
    // returns an array that counts the number of time a letter occurs in the message
    private int [] countLetters (String message) {
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
    
    private int maxIndex (int [] values) {
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
    
    public void simpleTests() {
        // read in a file as string
        FileResource fr = new FileResource();
        String message = fr.asString();
        // new caesarcipher object with key 18
        CaesarCipherOne cc = new CaesarCipherOne(18);
        // encrypt the message
        String encrypted = cc.encrypt(message);
        // decrypt the encrypted message
        String decrypted = cc.decrypt(encrypted);
        String decrypted1 = breakCaesarCipher(encrypted);
        // print out the results
        System.out.println("The original message is");
        System.out.println(message);
        System.out.println("The encrypted message is");
        System.out.println(encrypted);
        System.out.println("The decrypted message is");
        System.out.println(decrypted);
        //System.out.println("The decrypted message is");
        //System.out.println(decrypted1);
        
    }
    
    public String breakCaesarCipher (String input) {
        int [] counts = countLetters(input);
        int max = maxIndex(counts);
        // decrypt key
        int dKey = max - 4;
        if (dKey < 0){
              dKey = 26 - (4 - max);
        }
        // decrypt the message
        CaesarCipherOne cc = new CaesarCipherOne(dKey);
        String original = cc.decrypt(input);
        return original;
 
    }
    
    
    
    
    
    
    
    

}
