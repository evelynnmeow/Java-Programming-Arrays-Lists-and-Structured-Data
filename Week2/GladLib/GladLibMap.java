
/**
 * Write a description of GladLibMap here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class GladLibMap {
    // replace arraylists by hashmap
    private HashMap<String, ArrayList> myMap;
    private Random myRandom;
    private String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private String dataSourceDirectory = "data";
    private ArrayList<String> wordsUsed;
    private ArrayList<String> usedCategories;
    // constructor
    public GladLibMap() {
        myMap = new HashMap<String, ArrayList>();
        myRandom = new Random();
        initializeFromSource(dataSourceDirectory);
        usedCategories = new ArrayList<String>();
    }
    
    private void initializeFromSource (String source) {
        myMap.put("adjective", readIt(source + "/adjective.txt"));
        myMap.put("noun", readIt(source + "/noun.txt"));
        myMap.put("color", readIt(source + "/color.txt"));
        myMap.put("country", readIt(source + "/country.txt"));
        myMap.put("name", readIt(source + "/name.txt"));
        myMap.put("animal", readIt(source + "/animal.txt"));
        myMap.put("timeframe", readIt(source + "/timeframe.txt"));
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number") ){
            return ""+myRandom.nextInt(50)+5;
        }
        else if (myMap.containsKey(label)) {
            addUsedCategory(label);
            return randomFrom(myMap.get(label));
        }
        else{
            return "**UNKNOWN**";
        }
    }
    
    private String processWord(String w) {
            int first = w.indexOf("<");
            int last = w.indexOf(">", first);
            if (first == -1 || last == -1) {
                return w;
            }
            String prefix = w.substring(0, first);
            String suffix = w.substring(last + 1);
            String sub = getSubstitute(w.substring(first + 1, last));
            return prefix + sub + suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    private int totalWordInMap() {
        int total = 0;
        for (String key : myMap.keySet()) {
            ArrayList<String> words = myMap.get(key);
            int current = words.size();
            total += current;
            //System.out.println(key + " appears " + current + " times.");
        }
        
        return total;
    }
    
    // keep track of used category
    private void addUsedCategory(String label) {
        if (usedCategories.indexOf(label) == -1) {
            usedCategories.add(label);
        }
    }
    private int totalWordsConsidered() {
        ArrayList<String> current = new ArrayList<String>();
        int total = 0;
        for (int i = 0; i < usedCategories.size(); i++) {
            String cat = usedCategories.get(i);
            current = myMap.get(cat);
            int size = current.size();
            total += size;
            
        }
        return total;
    }
    
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate.txt");
        printOut(story, 60);
        System.out.println("\n");
        int totalNum = totalWordInMap();
        System.out.println("Total number in the map: " + totalNum);
        int totalUsed = totalWordsConsidered();
        System.out.println("Total words considered " + totalUsed);
    }
    
    
    
    
}

    
    
    
    
    
    
    
    


