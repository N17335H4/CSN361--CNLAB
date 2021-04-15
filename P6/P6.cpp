#include <iostream>
#include <math.h> 
#include <stdio.h> 
#include <string>
using namespace std;

int main()
{
	cout << "Decibel Calculator\n";
	string power, val;
	int last;
	double num;
	cout << "Enter the transmit power of the device with W or dBW or dBm as units without space: \n";
	cin >> power;
	last = power.length();
	if(power[last-1]=='W' && power[last-2]=='B')
	{
		val = power.substr(0,last-3);
		num = stod(val) + 30;
		num /= 10;
		num = pow(10.0,num-3);
		cout << num << "Watts\n";
	}
	else if (power[last-1]=='W')
	{
		val = power.substr(0,last-1);
		num = stod(val);
		num = 10 * log10(num/0.001);
		cout << num << "dBm or " << num - 30 << "dBW\n";
	}
	else if (power[last-1]=='m')
	{
		val = power.substr(0,last-3);
		num = stod(val);
		num /= 10;
		num = pow(10.0,num-3);
		cout << num << "Watts\n";
	}
	else cout << "Invalid format entered\n";
	return 0;
}