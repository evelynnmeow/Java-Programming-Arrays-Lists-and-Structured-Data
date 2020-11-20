
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherTwo {
    // fields
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    // constructor
    public CaesarCipherTwo (int key1, int key2) {
        mainKey1 = key1;
        mainKey2 = key2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(mainKey1) + alphabet.substring(0, mainKey1);
        shiftedAlphabet2 = alphabet.substring(mainKey2) + alphabet.substring(0, mainKey2);
    }

    
    // encrypt
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i <encrypted.length();i+=2){
        char currChar = encrypted.charAt(i);
        if ((i %2 == 0) && (Character.isLowerCase(currChar)))
        {
        
            int idx = alphabet.indexOf(currChar);
        
        if (idx!= 0)
            {
            char newChar = shiftedAlphabet1.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
        }
        
        else if ((i %2 == 0) && (Character.isUpperCase(currChar)))
        {
            int idx = alphabet.indexOf(currChar);
        if (idx != 0)
            {
            char newChar = shiftedAlphabet1.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
        }
        
    }
    
       for (int i = 1; i <encrypted.length();i+=2) {
            char currChar = encrypted.charAt(i);
            if ((i %2 != 0) && (Character.isLowerCase(currChar)))
            {
                int idx = alphabet.indexOf(currChar);
            if (idx != 0)
                {
                char newChar = shiftedAlphabet2.charAt(idx);
                encrypted.setCharAt(i,newChar);
                }
        }
        
            else if ((i %2 != 0) && (Character.isUpperCase(currChar)))
            {
                int idx = alphabet.indexOf(currChar);
            if (idx != 0)
            {
                char newChar = shiftedAlphabet2.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
                
    } 
    
    return encrypted.toString();   
    }
    
    
    public String decrypt(String encrypted)
    {
        
       CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1,26 - mainKey2);
       String decrypted = cc.encrypt(encrypted);
       return decrypted;
       
    }
    
    
    
    
    
    
    
    
}   
    