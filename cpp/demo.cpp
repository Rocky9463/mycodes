#include <iostream>
#include <fstream>
#include <string>
using namespace std;
int main(){
    ofstream src;
    ofstream des;
    string line; 
    src.open("tpoint.txt"); 
    des.open("abc.txt"); 
    if(src.is_open()){
        src<<"Tutorials point \n";
        src.close();
    }
    ifstream src1; scr1.open("tpoint.txt"); 
    if (src1.is_open() && des.is_open()) {
        while (getline(src1, line)) {
            des << line << endl;
        }
        cout << "Text copied successfully!" << endl;
    } else {
        cout << "Unable to open file" << endl;
    }


//    newfile.open("tpoint.txt",ios::in);
//    if (newfile.is_open()){ 
    //   string tp;
        // while(getline(newfile, tp)){
            // cout << tp << "\n";
            // newfile.close();  
        // }
//    }
   return 0;
}

