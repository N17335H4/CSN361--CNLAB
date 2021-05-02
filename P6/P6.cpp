#include <iostream>
#include <math.h> 
#include <stdio.h> 
#include <string>
using namespace std;
int numcheck(char n){
	int c=0;
	switch(n){
		case '0':
			c=1;
		case '1':
			c=1;
		case '2':
			c=1;
		case '3':
			c=1;
		case '4':
			c=1;
		case '5':
			c=1;
		case '6':
			c=1;
		case '7':
			c=1;
		case '8':
			c=1;
		case '9':
			c=1;
	}
	if (c==0)
		cout << "Invalid value entered" << endl;
	return c;
}

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
		for (int i = 0; i < last-3; ++i)
		{
			if(numcheck(power[i])==0)
				return 0;
		}
		val = power.substr(0,last-3);
		num = stod(val) + 30;
		num /= 10;
		num = pow(10.0,num-3);
		cout << num << "Watts\n";
	}
	else if (power[last-1]=='W')
	{
		for (int i = 0; i < last-1; ++i)
		{
			if(numcheck(power[i])==0)
				return 0;
		}
		val = power.substr(0,last-1);
		num = stod(val);
		num = 10 * log10(num/0.001);
		cout << num << "dBm or " << num - 30 << "dBW\n";
	}
	else if (power[last-1]=='m')
	{
		for (int i = 0; i < last-3; ++i)
		{
			if(numcheck(power[i])==0)
				return 0;
		}
		val = power.substr(0,last-3);
		num = stod(val);
		num /= 10;
		num = pow(10.0,num-3);
		cout << num << "Watts\n";
	}
	else cout << "Invalid format entered\n";
	return 0;
}