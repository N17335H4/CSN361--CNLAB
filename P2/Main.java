// Java Program to Ping an IP address
import java.io.*;
import java.net.*;
import java.util.*;

/*
import java.io.*;
import java.net.*;

public class ReachableTest {
 public static void main(String args[]) {
     try {
       InetAddress address = InetAddress.getByName("web.mit.edu");
       System.out.println("Name: " + address.getHostName());
       System.out.println("Addr: " + address.getHostAddress());
       System.out.println("Reach: " + address.isReachable(3000));
     }
     catch (UnknownHostException e) {
       System.err.println("Unable to lookup web.mit.edu");
     }
     catch (IOException e) {
       System.err.println("Unable to reach web.mit.edu");
     }
   }
}
*/

class Main
{
// Sends ping request to a provided IP address
public static void sendPingRequest(String ipAddress)
			throws UnknownHostException, IOException
{
	InetAddress geek = InetAddress.getByName(ipAddress);
	System.out.println("Sending Ping Request to " + ipAddress);
	if (geek.isReachable(5000))
	System.out.println("Host is reachable");
	else
	System.out.println("Sorry! We can't reach to this host");
}

/*
	String ipAddress = "127.0.0.1";
	sendPingRequest(ipAddress);

	ipAddress = "133.192.31.42";
	sendPingRequest(ipAddress);

	ipAddress = "145.154.42.58";
	sendPingRequest(ipAddress);
*/
public static void main(String[] args)
		throws UnknownHostException, IOException
{
	Scanner sc = new Scanner(System.in);
	String ipAddress;
	System.out.println("Enter the IP Address to be pinged: ");
	ipAddress = sc.nextLine();
	sendPingRequest(ipAddress);
}
}
