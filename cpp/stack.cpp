#include<iostream>
using namespace std;

class mystack{
    int top=-1;
    public: 
        mystack(){
            int size;
            cout<<"Enter size of stack : ";
            cin>>size;
            int arr[size];
            int i=1;
            do{
                cout<<"_____Menu_____\n";
                cout<<"1.push\n";           
                cout<<"2.pop\n";
                cout<<"3.peek\n";
                cout<<"4.change\n";
                cout<<"5.display\n";
                cout<<"6.stop\n";
                int choice;
                cout<<"Enter choice : ";
                cin>>choice;
                switch(choice){
                    case 1:
                        check_overflow(size);
                        break;
                    case 6:
                        cout<<"stopping\n";
                        i=0;
                        break;
                }
            }while(i);
        }
        void check_underflow(){
            if (top==-1){
                cout<<"!!!!!!!! Underflow !!!!!!!!\n";
                return ;
            }
        }
        void check_overflow(int size){
            if (top == size){
                cout<<"!!!!!!!! Over flow !!!!!!!\n";
                return ;
            }
        }
};


int main(){
    mystack obj;
    return 0;
}