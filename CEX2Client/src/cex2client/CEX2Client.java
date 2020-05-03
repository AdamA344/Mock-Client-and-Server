/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cex2client;

import server.Exception_Exception;
import server.Sample;

/**
 *
 * @author w1624446
 */
public class CEX2Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 CEX2Client client = new CEX2Client();
        client.executeTest();
    }

    /**
     * Executes the client test
     */
    private void executeTest() {
        System.out.println("[CEX2Client] Testing Server Connection...");
        if (isConnected().equals(0)) {
            System.out.println("[CEX2Client] The server is connected, the test can proceed...");

            System.out.println("[CEX2Client] Testing the server method getLengthOfLongestString...");
            if (getLengthOfLongestString("Short", "LongerString").equals(12)) {
                System.out.println("[CEX2Client] The server method getLengthOfLongestString has returned the correct value");
            } else {
                System.out.println("[CEX2Client][ERROR] The server method getLengthOfLongestString has returned the wrong value");
            }

            System.out.println("[CEX2Client] Testing the server method getLongestStringWithException...");
            try {
                if (getLengthOfLongestStringWithException("Short", "LongerString").equals(11)) {
                    System.out.println("[CEX2Client] The server method getLengthOfLongestStringWithException has returned the correct value");
                } else {
                    System.out.println("[CEX2Client] The server method getLengthOfLongestStringWithException has returned the wrong value");
                }
            } catch (Exception ex) {
                System.out.println("[CEX2Client][ERROR] The server method getLengthOfLongestStringWithException has thrown an Exception when it was NOT supposed to");
            }

            try {
                if (getLengthOfLongestStringWithException(null, "LongerString").equals(11)) {
                    System.out.println("[CEX2Client][ERROR] The server method getLengthOfLongestStringWithException has NOT thrown an Exception when it was supposed to");
                } else {
                    System.out.println("[CEX2Client][ERROR] The server method getLengthOfLongestStringWithException has NOT thrown an Exception when it was supposed to");
                }
            } catch (Exception ex) {
                System.out.println("[CEX2Client] The server method getLongestStringWithException has thrown an Exception when it was supposed to");
            }

            try {
                if (getLengthOfLongestStringWithException("Short", null).equals(11)) {
                    System.out.println("[CEX2Client][ERROR] The server method getLengthOfLongestStringWithException has NOT thrown an Exception when it was supposed to");
                } else {
                    System.out.println("[CEX2Client][ERROR] The server method getLengthOfLongestStringWithException has NOT thrown an Exception when it was supposed to");
                }
            } catch (Exception ex) {
                System.out.println("[CEX2Client] The server method getLengthOfLongestStringWithException has thrown an Exception when it was supposed to");
            }

            try {
                if (getLengthOfLongestStringWithException(null, null).equals(11)) {
                    System.out.println("[CEX2Client][ERROR] The server method getLengthOfLongestStringWithException has NOT thrown an Exception when it was supposed to");
                } else {
                    System.out.println("[CEX2Client][ERROR] The server method getLengthOfLongestStringWithException has NOT thrown an Exception when it was supposed to");
                }
            } catch (Exception ex) {
                System.out.println("[CEX2Client] The server method getLengthOfLongestStringWithException has thrown an Exception when it was supposed to");
            }

            System.out.println("[CEX2Client] Testing the server method addNumberToServer...");
            addNumberToServer(0.0);
            addNumberToServer(1.0);
            addNumberToServer(13.1);
            addNumberToServer(0.5);
            addNumberToServer(-10.0);

            System.out.println("[CEX2Client] Testing the server method findSumOfNumberInServer...");
            if (findSumOfNumberInServer().equals(4.6)) {
                System.out.println("[CEX2Client] The server method findSumOfNumberInServer has returned the correct value");
            } else {
                System.out.println("[CEX2Client][ERROR] The server method findSumOfNumberInServer has returned the wrong value");
            }

            System.out.println("[CEX2Client] Testing the server method addSampleToServer...");
            Sample s1 = new Sample();
            s1.setCity("London");
            s1.setTemperature(1.2);
            s1.setHumidity(85.2);
            addSampleToServer(s1);

            System.out.println("[CEX2Client] Testing the server method addSampleToServer...");
            Sample s2 = new Sample();
            s2.setCity("Rome");
            s2.setTemperature(21.2);
            s2.setHumidity(49.2);
            addSampleToServer(s2);

            System.out.println("[CEX2Client] Testing the server method addSampleToServer...");
            Sample s3 = new Sample();
            s3.setCity("Dublin");
            s3.setTemperature(0.1);
            s3.setHumidity(99.9);
            addSampleToServer(s3);

            System.out.println("[CEX2Client] Testing the server method addSampleToServer...");
            Sample s4 = new Sample();
            s4.setCity("Dubai");
            s4.setTemperature(30.1);
            s4.setHumidity(10.0);
            addSampleToServer(s4);

            System.out.println("[CEX2Client] Testing the server method findSampleWithHighestHumity...");
            if (findSampleWithHighestHumity().getCity().equals("Dublin")) {
                System.out.println("[CEX2Client] The server method findSampleWithHighestHumity has returned the correct value");
            } else {
                System.out.println("[CEX2Client][ERROR] The server method findSampleWithHighestHumity has returned the wrong value");
            }

            System.out.println("[CEX2Client] Testing the server method findAllSamplesWithHumidityAbove...");
            if (findAllSamplesWithHumidityAbove(20.0).size() == 3) {
                System.out.println("[CEX2Client] The server method findAllSamplesWithHumidityAbove has returned the correct value");
            } else {
                System.out.println("[CEX2Client][ERROR] The server method findAllSamplesWithHumidityAbove has returned the wrong value");
            }

        } else {
            System.out.println("[CEX2Client] The server is NOT connected, the test has failed !");
        }
    }

    private static String addNumberToServer(java.lang.Double arg0) {
        server.CEX2WebService_Service service = new server.CEX2WebService_Service();
        server.CEX2WebService port = service.getCEX2WebServicePort();
        return port.addNumberToServer(arg0);
    }

    private static String addSampleToServer(server.Sample arg0) {
        server.CEX2WebService_Service service = new server.CEX2WebService_Service();
        server.CEX2WebService port = service.getCEX2WebServicePort();
        return port.addSampleToServer(arg0);
    }

    private static java.util.List<server.Sample> findAllSamplesWithHumidityAbove(java.lang.Double arg0) {
        server.CEX2WebService_Service service = new server.CEX2WebService_Service();
        server.CEX2WebService port = service.getCEX2WebServicePort();
        return port.findAllSamplesWithHumidityAbove(arg0);
    }

    private static Sample findSampleWithHighestHumity() {
        server.CEX2WebService_Service service = new server.CEX2WebService_Service();
        server.CEX2WebService port = service.getCEX2WebServicePort();
        return port.findSampleWithHighestHumity();
    }

    private static Double findSumOfNumberInServer() {
        server.CEX2WebService_Service service = new server.CEX2WebService_Service();
        server.CEX2WebService port = service.getCEX2WebServicePort();
        return port.findSumOfNumberInServer();
    }

    private static Integer getLengthOfLongestString(java.lang.String arg0, java.lang.String arg1) {
        server.CEX2WebService_Service service = new server.CEX2WebService_Service();
        server.CEX2WebService port = service.getCEX2WebServicePort();
        return port.getLengthOfLongestString(arg0, arg1);
    }

    private static Integer getLengthOfLongestStringWithException(java.lang.String arg0, java.lang.String arg1) throws Exception_Exception {
        server.CEX2WebService_Service service = new server.CEX2WebService_Service();
        server.CEX2WebService port = service.getCEX2WebServicePort();
        return port.getLengthOfLongestStringWithException(arg0, arg1);
    }

    private static Integer isConnected() {
        server.CEX2WebService_Service service = new server.CEX2WebService_Service();
        server.CEX2WebService port = service.getCEX2WebServicePort();
        return port.isConnected();
    }

    
    
    
    
}

