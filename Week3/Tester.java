
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
        
    }
    
    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int uniq = la.countUniqueIPs();
        System.out.println("Number of Unique IPs: " + uniq);
        
    }
    
    public void testPrintAllHigherThanNum() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int n = 400;
        la.printAllHigherThanNum(n);
    }
    
    public void testUniqueIPVisitsOnDay () {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        String day = "Mar 24";
        int uniq = la.uniqueIPVisitsOnDay(day);
        System.out.print("Uniq ip on " + day + " " + uniq);
    }
    
    public void testCountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        int low = 200;
        int high = 299;
        int uniq = la.countUniqueIPsInRange(low, high);
        System.out.println("Number of IPs ranging between " + low + " " + high +" is " + uniq);
    }
    
    public void tester () {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        System.out.println("Max number of visits by ip");
        System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
        System.out.println("ip that visits the most");
        System.out.println(la.iPsMostVisits(la.countVisitsPerIP()));
        System.out.println("ips for each day");
        System.out.println(la.iPsForDays());
        System.out.println("Days with most IP visits");
        System.out.println(la.dayWithMostIPVisits(la.iPsForDays()));
        System.out.println("IP with most visit on day");
        System.out.println(la.iPsWithMostVisitOnDay(la.iPsForDays(),"Sep 29"));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
