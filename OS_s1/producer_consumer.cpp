#include <iostream>
#include <string>
using namespace std;

struct Student {
    string name;
    int age;
    string gender;
    int roll_no;
    float percentage;
};

int main() {
    const int NUM_STUDENTS = 5;
    Student students[NUM_STUDENTS];
    int choice;
    int i=1;
    int counter = 0;
    while(i==1){
        cout << "\n\n_____Menu______";
        cout << "\n1.Insert";
        cout << "\n2.Remove";
        cout << "\n3.Display";
        cout << "\nEnter choice : ";
        cin >> choice;
        switch (choice){
            case 1:
                if (counter >= NUM_STUDENTS){
                    cout << "\n!!!!!!!  overflow  !!!!!!";
                    continue;
                }
                cout << "\nDetails of student " << counter+1 << ":" << endl;
                cout << "Enter name of student : ";
                cin >> students[counter].name;
                cout << "Age : ";
                cin >> students[counter].age;
                cout << "Roll No. : "; 
                cin >> students[counter].roll_no;
                cout << "Percentage: "; 
                cin >> students[counter].percentage;
                counter++;
                continue;
            case 2:
                if (counter == 0){
                    cout << "\n!!!!!!!  Underflow  !!!!!!";
                    continue;
                }
                cout << "\nStudent removed";
                cout << "\nDetails of student " << counter << ":" << endl;
                cout << "Name: " << students[counter-1].name << endl;
                cout << "Age: " << students[counter-1].age << endl;            
                cout << "Roll No.: " << students[counter-1].roll_no << endl;
                cout << "Percentage: " << students[counter-1].percentage << endl;
                counter--;
                continue;
            case 3:
                if (counter == 0){
                    cout << "\n!!!!!!!  No data available  !!!!!!";
                    continue;
                }
                cout << "\n_______________________________";
                for (int i = 0; i < counter; i++) {
                    cout << "\nDetails of student " << i+1 << ":" << endl;
                    cout << "Name: " << students[i].name << endl;
                    cout << "Age: " << students[i].age << endl;
                    cout << "Gender: " << students[i].gender << endl;
                    cout << "Roll No.: " << students[i].roll_no << endl;
                    cout << "Percentage: " << students[i].percentage << endl;
                }
                continue;
        }
        if (choice < 1 || choice > 3){
            i=0;
            cout << "Stopping....\n";
            break;
        }
        
        i++;
    }
    return 0;
}