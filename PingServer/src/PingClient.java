/*
Brett Parker
Comp 430 - Networking
Ping Server
 */
import java.io.*;
import java.net.*;
import java.util.Date;
public class PingClient {
    public static void main(String args[]) throws IOException {
        for(int pingNumber = 1; pingNumber <= 10; ++pingNumber ) {
            System.out.format("Packet #%d, sent at: %s\n", pingNumber, new Date().toString());
            //2) Print the response message from server, if any (the server will capitalize the message sent
            //by the client and send it back to the client). Print out the elapsed time in microseconds.
            //prompt response
            System.out.println("Message to send:");
            //answer from user
            BufferedReader uInput = new BufferedReader(new InputStreamReader(System.in));
            //make socket
            DatagramSocket clientSocket = new DatagramSocket();
            //get ip
            //Use variable from PingServer
            InetAddress IPAddress = InetAddress.getByName("LocalHost");
            //create arrays
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            //get input
            String sentence = uInput.readLine();
            //change to bytes
            sendData = sentence.getBytes();
            //create packets
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2014);
            //3) Calculate and print the round trip time (RTT), in microseconds, of each packet, if server
            //responses.
            //get time
            long startTime = System.nanoTime();
            //send packet
            clientSocket.send(sendPacket);
            //receivable from server
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            //4) Create timeout for RTT (1 second)
            clientSocket.setSoTimeout(1000);
            //Try catch for the timeout
            try {
                clientSocket.receive(receivePacket);
                //Make server packet uppercase
                String capitalizedSentence = new String(receivePacket.getData());
                capitalizedSentence = capitalizedSentence.toUpperCase();
                //RTT from nano to micro
                long endTime = System.nanoTime();
                long completionTime = (endTime - startTime) / 1000;
                //print RTT
                System.out.println("Data Received in: " + completionTime + " (nanoseconds)");
                //print Server Message
                System.out.println("SERVER RESPONSE: " + capitalizedSentence);
                //close the socket connection
                clientSocket.close();
                //If timeout, print Server Request Timeout
            } catch (SocketTimeoutException e) {
                System.out.println("Server Request Timeout");

            }
        }
    }
}
