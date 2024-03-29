#include <iostream>
#include <pthread.h>
using namespace std;
void *fibo(void *arg)
{
    cout << "Thread started" << endl;
    int *count = static_cast<int*>(arg);
    for (int i=2; i< *count; i++){
        int flag = 1;
        for (int j=2; j <= i/2; j++){
            if (i%j==0){
                flag = 0;
            }
        }
        if (flag==1){
            cout << i << endl;
        }
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