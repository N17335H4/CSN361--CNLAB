#include <iostream>
#include <stdio.h> 
#include <string>
using namespace std;

string subnetmask(int prefix)
{
	string a="0", b="0", c="0", d="0";
	if(prefix>7) a="255";
	if(prefix>15) b="255";
	if(prefix>23) c="255";
	switch(prefix)
	{
	case 1:
		a="128";
		break;
	case 2:
		a="192";
		break;
	case 3:
		a="224";
		break;
	case 4:
		a="240";
		break;
	case 5:
		a="248";
		break;
	case 6:
		a="252";
		break;
	case 7:
		a="254";
		break;
	case 9:
		b="128";
		break;
	case 10:
		b="192";
		break;
	case 11:
		b="224";
		break;
	case 12:
		b="240";
		break;
	case 13:
		b="248";
		break;
	case 14:
		b="252";
		break;
	case 15:
		b="254";
		break;
	case 17:
		c="128";
		break;
	case 18:
		c="192";
		break;
	case 19:
		c="224";
		break;
	case 20:
		c="240";
		break;
	case 21:
		c="248";
		break;
	case 22:
		c="252";
		break;
	case 23:
		c="254";
		break;
	case 25:
		d="128";
		break;
	case 26:
		d="192";
		break;
	case 27:
		d="224";
		break;
	case 28:
		d="240";
		break;
	case 29:
		d="248";
		break;
	case 30:
		d="252";
		break;
	case 31:
		d="254";
		break;
	case 32:
		d="255";
		break;
	}
	string sm = a + "." + b + "." + c + "." + d;
	return sm;
}

int main(int argc, char const *argv[])
{
	string ex, val, ip;
	cout << "Enter IP address and subnet mask in CIDR notation: ";
	cin >> ex;
	int len = ex.length();
	int pos, num;
	for (int i = 0; i < len; ++i)
	{
		if (ex[i]=='/')
		{
			pos = i;
		}
	}
	val = ex.substr(pos+1, len-pos-1);
	ip = ex.substr(0,pos);
	num = stoi(val);
	ex = subnetmask(num);
	cout << "Network address: " + ip + " Subnet mask: " + ex << endl;
	return 0;
}