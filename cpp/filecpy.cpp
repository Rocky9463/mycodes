#include <iostream>
#include <fstream>
using namespace std;
int main(){
    ofstream source_file("abc.txt");
    ofstream dest_file("xyz.txt");
    string line;
    if (source_file.is_open()) {
        source_file << "This is a new file \ncreated by C++" << endl;
        cout << "File created" << endl;
    }
    source_file.close();
    ifstream source_file1;
    source_file1.open("abc.txt");
    if (source_file1.is_open() && dest_file.is_open()) {
        while (getline(source_file1, line)) {
            dest_file << line << endl;
        }
        cout << "Text copied successfully!" << endl;
    } else {
        cout << "Unable to open file" << endl;
    }

    source_file1.close();
    dest_file.close();
    return 0;
}