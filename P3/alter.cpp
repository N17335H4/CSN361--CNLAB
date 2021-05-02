#include <iostream>
#include <stdio.h>
#include <fstream>
#include <string.h>
using namespace std;
void print_char(char *to_print, int &i_len)
{
    for (int i = 0; i < i_len; i++)
        cout << to_print[i]; //<<" ,";

    return;
}
int main(int arg, char *argv[])
{
    ifstream myfile;
    myfile.open("Output.txt");
    int bitNo;
    for (int i = 0; i < arg; i++)
    {
        bitNo = atoi(argv[i]);
    }
    string line;
    getline(myfile, line);
    int i_len;
    i_len = line.length();
    char output_message[i_len];
    strcpy(output_message, line.c_str());
    getline(myfile, line);
    int k=line.length();
    // alter the bitNo in the passed message
    if(bitNo<k+i_len){
        if (output_message[bitNo - 1] == '1')
            output_message[bitNo - 1] = '0';
        else
            output_message[bitNo - 1] = '1';
    }
    cout << "Output Message: ";
    print_char(output_message, i_len);
    cout<<endl<< "Polynomial: " <<line<<endl;
    myfile.close();

    ofstream file;
    file.open("Output.txt", ios::trunc);
        if (file.is_open())
        {
            file << output_message << endl;
            file << line << endl;
        }

    return 0;
}