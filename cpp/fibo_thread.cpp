#include <iostream>
#include <pthread.h>
//#include <unistd.h>
using namespace std;
void *fibo(void *arg)
{
    cout << "Thread started" << endl;
    int *count = static_cast<int*>(arg);
    int a = 0;
    int b = 1;
    int c = 0;
    for(int itr = 0; itr < *count; itr++){
        cout << a << endl;
        c=a+b;
        a=b;
        b=c;
    }
    pthread_exit(NULL);
}

int main()
{
    pthread_t thread;
    int count;
    cout << "Enter number : ";
    cin >> count;
    int result = pthread_create(&thread, NULL, fibo, &count);
    pthread_join(thread, NULL);
    return 0;
}   