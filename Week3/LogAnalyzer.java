
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (Jingjie M.) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource();
         for (String line : fr.lines()) {
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
         }
         
         
     }
     
     // count the number of unique ips
     public int countUniqueIPs () {
         ArrayList<String> uniqIPs = new ArrayList<String> ();
         for (LogEntry le: records) {
             String currentIP = le.getIpAddress();
             if (!uniqIPs.contains(currentIP)) {
                 uniqIPs.add(currentIP);
             }
         }
         
         int size = uniqIPs.size();
         return size;
     }
     
     public void printAllHigherThanNum (int num) {
         int count = 0;
         System.out.println("Higher code than " + num);
         for (LogEntry le : records) {
             int code = le.getStatusCode();
             if (code > num) {
                 System.out.println(le);
             }
             
         }
     }
     
     // returns the unique number of ip visit on a certain day
     public int uniqueIPVisitsOnDay (String someday) {
         ArrayList<String> uniqIPs = new ArrayList<String> ();
         for (LogEntry le: records) {
             String currentIP = le.getIpAddress();
             // get data then change to string then get substring
             Date date = le.getAccessTime();
             String currentDate = date.toString();
             if ((!uniqIPs.contains(currentIP)) && currentDate.contains(someday)) {
                 uniqIPs.add(currentIP);
             
             }
         }
         
         return uniqIPs.size();
     }
     
     public int countUniqueIPsInRange (int low, int high) {
         ArrayList<String> uniqIPs = new ArrayList<String> ();
         for (LogEntry le: records) {
             String currentIP = le.getIpAddress();
             int currentCode = le.getStatusCode();
             if (currentCode <= high && currentCode >= low) {
                 if (!uniqIPs.contains(currentIP)) {
                     uniqIPs.add(currentIP);
                 }
             }
         }
         return uniqIPs.size();
     }
     
     public HashMap<String, Integer> countVisitsPerIP () {
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         for (LogEntry le: records) {
             String ip = le.getIpAddress();
             if (!counts.containsKey(ip)) {
                 counts.put(ip, 1);
             }
             else{
                 counts.put(ip, counts.get(ip) + 1);
             }
         }
         return counts;
     }
     
     public int mostNumberVisitsByIP (HashMap<String, Integer> counts) {
         int max = 0;
         for (Integer numVisits: counts.values()) {
             if (numVisits > max) {
                 max = numVisits;
             }
         }
         return max;
     }
     
     public ArrayList<String> iPsMostVisits (HashMap<String, Integer> counts) {
         ArrayList<String> maxIps = new ArrayList();
         int max = mostNumberVisitsByIP(counts);
         for (String ip : counts.keySet()) {
             if (counts.get(ip) == max) {
                 maxIps.add(ip);
             }
         }
         return maxIps;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays () {
         HashMap<String, ArrayList<String>> ipDays = new HashMap<String, ArrayList<String>>();
         for (LogEntry le: records) {
             String date = le.getAccessTime().toString().substring(4, 10);
             ArrayList<String> ips = new ArrayList();
             String ip = le.getIpAddress();
             if (!ipDays.containsKey(date)) {
                 ips.add(ip);
                 ipDays.put(date, ips);
             }
             else{
                 ipDays.get(date).add(ip);
             }
         }
         return ipDays;
     }
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> ipDays) {
         int max = 0;
         String dayWithMostVisit = "";
         for (String date: ipDays.keySet()) {
             int visitPerDay = ipDays.get(date).size();
             if (max < visitPerDay) {
                 max = visitPerDay;
                 dayWithMostVisit = date;
             }
         }
         
         return dayWithMostVisit;
     
        
     }
     
     public ArrayList<String> iPsWithMostVisitOnDay(HashMap<String, ArrayList<String>> ipDays, String date) {
         ArrayList<String> ipOnDay = ipDays.get(date);
         HashMap<String, Integer> counts = new HashMap<>();
         for (String ip: ipOnDay) {
             if (!counts.containsKey(ip)) {
                 
                 counts.put(ip, 1);
             }
             else{
                 counts.put(ip, counts.get(ip) + 1);
             }
         }
         
         return iPsMostVisits(counts);
        
        
        
     }
     
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
