#include <iostream>
#include <math.h> 
#include <stdio.h> 
#include <string>
using namespace std;

int main()
{
	cout << "Decibel Calculator\n";
	cout << "Enter 1 for operation from Decibel to standard units or 2 for operation from standard units to Decibel\n";
	int choice, last;
	double num;
	string power, val;
	cin >> choice;
	if (choice == 1)
	{
		cout << "Enter the transmit power of the device in Decibel with units dBW or dBm without any space\n";
		cin >> power;
		last = power.length();
		if (power[last-1] == 'm') 
		{
			cout << "Input identified as in milli Decibel units\n";
			val = power.substr(0,last-3);
			num = stod(val);
			num /= 10;
			num = pow(10.0,num-3);
			cout << num << "Watts\n";
		}
		else if(power[last-1] == 'W')
		{
			cout << "Input identified as in Decibel units\n";
			val = power.substr(0,last-3);
			num = stod(val) + 30;
			num /= 10;
			num = pow(10.0,num-3);
			cout << num << "Watts\n";
		} 
		else cout << "Invalid format\n";
	}
	else if (choice == 2)
	{
		cout << "Enter the transmit power of the device in Watts without units\n";
		cin >> num;
		num = 10 * log10(num/0.001);
		cout << num << "dBm or " << num - 30 << "dBW\n";
	}
	else cout << "Invalid choice entered\n";
	return 0;
}