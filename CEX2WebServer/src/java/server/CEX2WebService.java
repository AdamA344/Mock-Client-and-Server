/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author w1624446
 */
@WebService(serviceName = "CEX2WebService")
public class CEX2WebService {

    ArrayList<Double> addNumberToServer = new ArrayList<Double>();
    ArrayList<Sample> addSampleToServer = new ArrayList<Sample>();

    /**
     * Returns the Integer value 0 if the server is correctly running.
     *
     * @return the Integer value 0 if the server is correctly running.
     */
    public Integer isConnected() {
        System.out.println("[SERVER] - Testing Server Connection...");
        return 0;
    }

    /**
     * Returns the length of the shortest of the two String passed as a
     * parameter
     *
     * @param s1 the first string which length has to be compared
     * @param s2 the second string which length has to be compared
     * @return the length of the shortest String between s1 and s2
     */
    public Integer getLengthOfLongestString(String s1, String s2) {
        System.out.println("[SERVER] - Finding length is the longest string between " + s1 + " and " + s2);
        if (s1.length() > s2.length()) {
            return s1.length();
        } else {
            return s2.length();
        }
    }

    /**
     * Returns the length of the longest of the String passed as a parameter
     *
     * @param s1 the first string which length has to be compared
     * @param s2 the second string which length has to be compared
     * @return the length of the longest of the String passed as a parameter
     * @throws Exception is one or both of the passed strings are null
     */
    public Integer getLengthOfLongestStringWithException(String s1, String s2) throws Exception {
        System.out.println("[SERVER] - Finding length is the longest string between " + s1 + " and " + s2);
        if (s1 == null) {
            throw new Exception();
        }
        if (s2 == null) {
            throw new Exception();
        }
        if (s1.length() > s2.length()) {
            return s1.length();
        } else {
            return s2.length();
        }
    }

    /**
     * Adds the Double number passed as a parameter to the ArrayList of numbers
     * on the Server
     *
     * @param n the number which has to be added to the server
     * @return the String "Done"
     */
    public String addNumberToServer(Double n) {
        System.out.println("[SERVER] - Adding " + n + " to " + addNumberToServer);
        addNumberToServer.add(n);
        return "[SERVER] - Number added to Server";
    }

    /**
     * Returns the sum of all numbers present in the Server
     *
     * @return the sum of all numbers present in the Server
     */
    public Double findSumOfNumberInServer() {
        System.out.println("[SERVER] - Finding sum of " + addNumberToServer);
        double sum = 0;
        for (int i = 0; i < addNumberToServer.size(); i++) {
            sum = sum + addNumberToServer.get(i);
        }
        return sum;
    }

    /**
     * Adds the Sample passed as a parameter to the ArrayList of samples on the
     * Server
     *
     * @param s the Sample which has to be added to the server
     * @return the String "Done"
     */
    public String addSampleToServer(Sample s) {
        System.out.println("[SERVER] - Adding " + s + " to " + addSampleToServer);
        addSampleToServer.add(s);
        return "[SERVER] - Sample added to Server";
    }

    /**
     * Returns the sample with the highest humidity
     *
     * @return the sample with the highest humidity
     */
    public Sample findSampleWithHighestHumity() {
        
        System.out.println("[SERVER] - Finding Sample With the highest Humity");
        Iterator i = addSampleToServer.iterator();
        Sample longest = addSampleToServer.get(0);

        while (i.hasNext()) {
            Sample curr = (Sample) i.next();
            if (curr.humidity > longest.humidity) {
                longest = curr;
            }
        }
        return longest;
    }

    /**
     * Returns all the samples with the humidity above the parameter h passed
     *
     * @return all the samples with the humidity above the parameter h passed
     * @param h the threshold humidity
     */
    public ArrayList<Sample> findAllSamplesWithHumidityAbove(Double h) {
        System.out.println("[SERVER] - Finding Sample With the humidity above threshold ");
        
        ArrayList<Sample> Threshold = new ArrayList<>();
        for (int i = 0; i < addSampleToServer.size(); i++) {
            if (addSampleToServer.get(i).humidity < h) {
                Threshold.add(addSampleToServer.get(i));
            }
        }
        return Threshold;
    }
}
