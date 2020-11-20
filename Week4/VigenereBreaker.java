import java.util.*;
import edu.duke.*;
import java.io.File;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String sliced = "";
        for (int i = whichSlice; i < message.length(); i+= totalSlices) {
            sliced += message.charAt(i);
        }
        return sliced;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++) {
            String s = sliceString(encrypted, i, klength);
            int j = cc.getKey(s);
            key[i] = j;
        }
        return key;
    }

    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString().toLowerCase();

        DirectoryResource dr = new DirectoryResource();

        HashMap<String, HashSet<String>> map = new HashMap<>();

        for (File f : dr.selectedFiles()) {
            FileResource frd = new FileResource(f);
            HashSet<String> dictionary = readDictionary(frd);
            map.put(f.getName(), dictionary);
        }

        breakForAllLangs(message, map);
    }
    
    
    
    
    public HashSet<String> readDictionary(FileResource fr) { 
        HashSet<String> strings = new HashSet<String>();
        for (String s:fr.lines()) {
            s = s.toLowerCase();
            strings.add(s);
        }
        return strings;
    }
    
    
    public int countWords(String message, HashSet<String> dictionary) {
        String[] messages = message.split("\\W+");
        int count = 0;
        for (String word: messages) {
            if (dictionary.contains(word)) {
                count++;
            }
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int max = 0;
        String s = "";
        char mostCommonChar = mostCommonCharIn(dictionary);
        for (int i = 0; i < 100; i++) {
            int[] key;
            key = tryKeyLength(encrypted, i, mostCommonChar);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            if (countWords(decrypted, dictionary) > max) {
                max = countWords(decrypted, dictionary);
                s = decrypted;
                
            }
        }
        System.out.println("The number of valid words is " + max);
        return s;
    }
        
    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        char mostCommonChar = 'a';
        int max = 0;
        for (String chars: dictionary) {
            for (int i = 0; i < chars.length(); i++) {
                if (counts.containsKey(chars.charAt(i))) {
                    counts.put(chars.charAt(i), counts.get(chars.charAt(i)) + 1);
                }
                else{
                    counts.put(chars.charAt(i), 1);
                }
            }
        }
        for (Character chars: counts.keySet()) {
            if (counts.get(chars) > max) {
                mostCommonChar = chars;
            }
        }
        System.out.println("The most common char is " + mostCommonChar);
        return mostCommonChar;
    }
    
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages) {
        for (String languageName : languages.keySet()) {
            System.out.println("This is " + languageName);
            String decrypted = breakForLanguage(encrypted, languages.get(languageName));
            System.out.println(decrypted);
        }
    }
    
    
    
    
    
    
}
