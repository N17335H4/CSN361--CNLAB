#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
	cout << "IPv4 CHECKSUM CALCULATION\n" <<endl;
	cout << "IPv4 header format: \n";
	cout << "0--Version--3--HeaderLength--7--TypeOfService--15---------TotalLength--------------31\n";
	cout << "0------------------Identifier------------------15--Flags--18----FragmentOffset-----31\n";
	cout << "0---------TImeToLive---------7-----Protocol----15-----------HeaderChecksum---------31\n";
	cout << "0--------------------------------SourceAddress-------------------------------------31\n";
	cout << "0-----------------------------DestinationAddress-----------------------------------31\n";
	cout << "0-----------------------------Options(if any)-----------------------23---Padding---31\n" << endl;
	
	return 0;
}