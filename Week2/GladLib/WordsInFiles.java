
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.lang.*;
import java.io.*;
public class WordsInFiles {
    private HashMap<String, ArrayList> fileNames;
    // constructor
    public WordsInFiles() {
        fileNames = new HashMap<String, ArrayList>();
    }
    
    /*
     * a private void method that add all words from the file to the map
     */
    private void addWordsFromFile (File f) {
        FileResource fr = new FileResource(f);
        // name of the file
        String fileName = f.getName();
        // loop through each word in the file
        for (String word : fr.words()) {
            // change to lower case
            word = word.toLowerCase();
            if (!fileNames.containsKey(word)) {
                // add the filename to an arraylist
                ArrayList<String> fileList = new ArrayList<String>();
                fileList.add(fileName);
                fileNames.put(word, fileList);
            }
            else{
                ArrayList<String> fileList = fileNames.get(word);
                if (!fileList.contains(fileName)) {
                    fileList.add(fileName);
                    
                }
            }
        }
    }
    
    public void buildWordFileMap() {
        DirectoryResource dr = new DirectoryResource();
        fileNames.clear();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }
    
    // returns the maximum number of files any word appears in
    public int maxNumber () {
        int max = 0;
        for (String word : fileNames.keySet()) {
            int current = fileNames.get(word).size();
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
   
    // returns the arraylist of words that occurs the number times in files
    private ArrayList wordsInNumFiles (int number) {
        ArrayList<String> words = new ArrayList<String>();
        for (String word : fileNames.keySet()) {
            int current = fileNames.get(word).size();
            if (current == number) {
                words.add(word);
            }
        }
        return words;
    }
    
    // prints the name of files that the word occurs
    private void printFilesIn(String word) {
        ArrayList<String> filenames = fileNames.get(word);
        System.out.println(word + " appears in the following files: ");
        for (String filename : filenames) {
            System.out.println(filename);
        }
        
        
    }
    
    public void tester() {
        buildWordFileMap();
        int max = maxNumber();
        int number = 4;
        ArrayList<String> words = wordsInNumFiles(number);
        
        for (String word : words) {
            printFilesIn(word);
        }
        System.out.println(words.size());
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    

}
