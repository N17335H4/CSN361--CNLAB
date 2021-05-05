import java.util.*;

public class Main{
	public static void main(String args[]){
		System.out.print("IPv4 CHECKSUM CALCULATION\n");
		System.out.println("IPv4 header format: \n");
		System.out.print("0--Version--3--HeaderLength--7--TypeOfService--15---------TotalLength--------------31\n");
		System.out.print("0------------------Identifier------------------15--Flags--18----FragmentOffset-----31\n");
		System.out.print("0---------TImeToLive---------7-----Protocol----15-----------HeaderChecksum---------31\n");
		System.out.print("0--------------------------------SourceAddress-------------------------------------31\n");
		System.out.print("0-----------------------------DestinationAddress-----------------------------------31\n");


		//Explain the process
	

		System.out.println("Note: The values of the fields asked are required to be in hexadecimal format. The results are printed in hexadecimal format");
		System.out.println("Enter the IP Version, Header Length and Type of Service: ");
		Scanner scan = new Scanner(System.in);
		String input1 = scan.next();
		System.out.println("IP version : "+input1.charAt(0) + ", Header Length : "+input1.charAt(1)+ ", TOS : "+input1.charAt(2)+input1.charAt(3));
		

		System.out.println("Enter the Total length: ");
		String input2 = scan.next();
		int first_result = sum(input1, input2);
		System.out.println("Sum of above inputs until 32 bits: "+Integer.toHexString(first_result));
		

		System.out.println("Enter the Identifier: ");
		String input3 = scan.next();
		int second_result = sum(Integer.toHexString(first_result), input3);
		System.out.println("Sum of above inputs until 48 bits: "+Integer.toHexString(second_result));
		

		System.out.println("Enter the Flags and Fragment Offset : ");
		String input4 = scan.next();
		int third_result = sum(Integer.toHexString(second_result), input4);
		System.out.println("Sum of above inputs until 64 bits: "+Integer.toHexString(third_result));
		

		System.out.println("Enter the Time to live and Protocol: ");
		String input5 = scan.next();
		int fourth_result = sum(Integer.toHexString(third_result), input5);
		System.out.println("Sum of above inputs until 80 bits: "+Integer.toHexString(fourth_result));
		

		System.out.println("Enter the Header Checksum (as 0000): ");
		String input6 = scan.next();
		int fifth_result = sum(Integer.toHexString(fourth_result), input6);
		System.out.println("Sum of above inputs until 96 bits: "+Integer.toHexString(fifth_result));
		
		System.out.println("Enter the first 16 bits of Source Address: ");
		String input7 = scan.next();
		int sixth_result = sum(Integer.toHexString(fourth_result), input7);
		System.out.println("Sum of above inputs until 112 bits excluding Checksum field: "+Integer.toHexString(sixth_result));
		

		System.out.println("Enter the last 16 bits of Source Address: ");
		String input8 = scan.next();
		int seventh_result = sum(Integer.toHexString(sixth_result), input8);
		System.out.println("Sum of above inputs until 128 bits excluding Checksum field: "+Integer.toHexString(seventh_result));
		

		System.out.println("Enter the first 16 bits of Destination Address: ");
		String input9 = scan.next();
		int eight_result = sum(Integer.toHexString(seventh_result), input9);
		System.out.println("Sum of above inputs until 144 bits excluding Checksum field: "+Integer.toHexString(eight_result));
		

		System.out.println("Enter the last 16 bits of Destination Address: ");
		String input10 = scan.next();
		int final_result = sum(Integer.toHexString(eight_result), input10);
		System.out.println("Sum of above inputs until 160 bits excluding Checksum field: "+Integer.toHexString(final_result));
		

		
		int my_checksum = generate_complement(final_result);
		System.out.println("Checksum generated upon complementing the last sum is "+ Integer.toHexString(my_checksum));
	}

	static int sum(String s1, String s2){
		int x = Integer.parseInt(s1, 16);
		int y = Integer.parseInt(s2,16);
		int my_checksum = x+y;
		String my_hex_val = Integer.toHexString(my_checksum);

		if(my_hex_val.length() > 4){
			int carry = Integer.parseInt(("" + my_hex_val.charAt(0)), 16);
			my_hex_val = my_hex_val.substring(1,5);
			my_checksum = Integer.parseInt(my_hex_val, 16);
			my_checksum += carry;
		}
		return my_checksum;
	}

	static int generate_complement(int my_checksum){
		my_checksum = Integer.parseInt("FFFF", 16) - my_checksum;
      	return my_checksum;
	}
}