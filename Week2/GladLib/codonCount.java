
/**
 * Write a description of condonCount here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
// find out how many times each codon occurs in a strand of DNA
public class codonCount {
    private HashMap<String, Integer> codonMap;
    // initialize
    public codonCount() {
        codonMap = new HashMap<String, Integer>();
    }
    
    // build a codon map
    public void buildCodonMap(int start, String dna) {
        codonMap.clear();
        for (int i=start; i<dna.length()-3; i+=3) {
            String codon = dna.substring(i, i+3);
            if (!codonMap.containsKey(codon)){
                codonMap.put(codon,1);
            }
            else {
            codonMap.put(codon, codonMap.get(codon)+1);
        }
        }
        }
            
        
    
    
    // get the most common codon
    public String getMostCommonCodon() {
        // largest count
        int largest = 0;
        // current count
        int current = 0;
        // most common codon
        String mostCommonCodon = "";
        // loop through the map
        for (String index : codonMap.keySet()) {
            // current count
            current = codonMap.get(index);
            if (current > largest) {
                largest = current;
                mostCommonCodon = index;
            }
        }
        
        return mostCommonCodon;
       
    }
    
    public void printCodonCounts(int start, int end) {
        int count = 0;
        for (String index : codonMap.keySet()) {
            count = codonMap.get(index);
            if (count >= start && count <= end) {
                System.out.println(index + " " + count);
            }
              
        }
        
    }
    
    public void test() {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        
        int start = 1;
        int end = 5;
        
        buildCodonMap(0, dna);
        System.out.println("Starting from 0");
        printCodonCounts(1, 5);
        String mostCommon = getMostCommonCodon();
        System.out.println("The most common codon is " + mostCommon);
        
        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in ");
        printCodonCounts(1, 5);
        mostCommon = getMostCommonCodon();
        System.out.println("The most common codon is " + mostCommon);
        
        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in ");
        printCodonCounts(1, 5);
        mostCommon = getMostCommonCodon();
        System.out.println("The most common codon is " + mostCommon);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
