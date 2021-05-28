import java.util.*;

public class Main{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("IPv4 CHECKSUM CALCULATION\n");
		System.out.println("IPv4 header format: \n");
		System.out.print("0--Version--3--HeaderLength--7--TypeOfService--15---------TotalLength--------------31\n");
		System.out.print("0------------------Identifier------------------15--Flags--18----FragmentOffset-----31\n");
		System.out.print("0---------TImeToLive---------7-----Protocol----15-----------HeaderChecksum---------31\n");
		System.out.print("0--------------------------------SourceAddress-------------------------------------31\n");
		System.out.print("0-----------------------------DestinationAddress-----------------------------------31\n");
		System.out.println("Process: The checksum field is the 16-bit ones' complement of the ones' complement sum of all 16-bit words in the header. For ones' complement sum, each time a carry occurs, we must add a 1 to the sum.")
		System.out.println("Note: The values of the fields asked are required to be in hexadecimal format. The results are printed in hexadecimal format");
		System.out.println("Enter the IP Version, Header Length and Type of Service: ");
		String half1 = scan.next();
		System.out.println("IP version : "+half1.charAt(0) + ", Header Length : "+half1.charAt(1)+ ", TOS : "+half1.charAt(2)+half1.charAt(3));
		System.out.println("Enter the Total length: ");
		String half2 = scan.next();
		int firstSum = sum(half1, half2);
		System.out.println("Sum of above inputs until 32 bits: "+Integer.toHexString(firstSum));
		System.out.println("Enter the Identifier: ");
		String half3 = scan.next();
		int secondSum = sum(Integer.toHexString(firstSum), half3);
		System.out.println("Sum of above inputs until 48 bits: "+Integer.toHexString(secondSum));
		System.out.println("Enter the Flags and Fragment Offset : ");
		String half4 = scan.next();
		int thirdSum = sum(Integer.toHexString(secondSum), half4);
		System.out.println("Sum of above inputs until 64 bits: "+Integer.toHexString(thirdSum));
		System.out.println("Enter the Time to live and Protocol: ");
		String half5 = scan.next();
		int fourthSum = sum(Integer.toHexString(thirdSum), half5);
		System.out.println("Sum of above inputs until 80 bits: "+Integer.toHexString(fourthSum));
		System.out.println("0000 is taken as Header Checksum.");
		String half6 = "0000";
		int fifthSum = sum(Integer.toHexString(fourthSum), half6);
		System.out.println("Sum of above inputs until 96 bits: "+Integer.toHexString(fifthSum));	
		System.out.println("Enter the first half of Source Address: ");
		String half7 = scan.next();
		int sixthSum = sum(Integer.toHexString(fourthSum), half7);
		System.out.println("Sum of above inputs until 112 bits excluding Checksum field: "+Integer.toHexString(sixthSum));
		System.out.println("Enter the last half of Source Address: ");
		String half8 = scan.next();
		int seventhSum = sum(Integer.toHexString(sixthSum), half8);
		System.out.println("Sum of above inputs until 128 bits excluding Checksum field: "+Integer.toHexString(seventhSum));
		System.out.println("Enter the first half of Destination Address: ");
		String half9 = scan.next();
		int eightSum = sum(Integer.toHexString(seventhSum), half9);
		System.out.println("Sum of above inputs until 144 bits excluding Checksum field: "+Integer.toHexString(eightSum));
		System.out.println("Enter the last half of Destination Address: ");
		String half10 = scan.next();
		int finalSum = sum(Integer.toHexString(eightSum), half10);
		System.out.println("Sum of above inputs until 160 bits excluding Checksum field: "+Integer.toHexString(finalSum));		
		int checksum = onesComplement(finalSum);
		System.out.println("Checksum generated upon complementing the last sum is "+ Integer.toHexString(checksum));
	}

	static int sum(String s1, String s2){
		int x = Integer.parseInt(s1, 16);
		int y = Integer.parseInt(s2,16);
		int checksum = x+y;
		String z = Integer.toHexString(checksum);

		if(z.length() > 4){
			int carry = Integer.parseInt(("" + z.charAt(0)), 16);
			z = z.substring(1,5);
			checksum = Integer.parseInt(z, 16);
			checksum += carry;
		}
		return checksum;
	}

	static int onesComplement(int checksum){
		checksum = Integer.parseInt("FFFF", 16) - checksum;
      	return checksum;
	}
}