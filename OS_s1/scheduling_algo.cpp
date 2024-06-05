#include<iostream>
using namespace std;
int main() {
    int n;  // number of processes
    int tq; // time quantum
    cout << "Enter the number of processes: ";
    cin >> n;
    cout << "Enter the time quantum: ";
    cin >> tq;

    int burst_time[n], remaining_time[n]; // arrays to store burst and remaining time of each process
    cout << "Enter the burst time of each process: ";
    for(int i=0; i<n; i++) {
        cin >> burst_time[i];
        remaining_time[i] = burst_time[i]; // initialize remaining time with burst time
    }

    int time = 0; // current time
    int waiting_time[n] = {0}, turnaround_time[n] = {0}; // arrays to store waiting and turnaround time of each process
    int completed = 0; // number of processes completed
    while(completed < n) {
        for(int i=0; i<n; i++) {
            if(remaining_time[i] > 0) { // check if process still has remaining time
                int exec_time = min(tq, remaining_time[i]); // execute process for time quantum or remaining time, whichever is smaller
                remaining_time[i] -= exec_time; // update remaining time
                time += exec_time; // update current time

                if(remaining_time[i] == 0) { // process has completed
                    completed++;
                    turnaround_time[i] = time; // calculate turnaround time
                    waiting_time[i] = turnaround_time[i] - burst_time[i]; // calculate waiting time
                }
            }
        }
    }

    double avg_waiting_time = 0, avg_turnaround_time = 0;
    for(int i=0; i<n; i++) {
        avg_waiting_time += waiting_time[i];
        avg_turnaround_time += turnaround_time[i];
    }
    avg_waiting_time /= n;
    avg_turnaround_time /= n;

    cout << "Process | Burst time | Waiting time | Turnaround time\n";
    for(int i=0; i<n; i++) {
        cout << "P" << i+1 << "\t | " << burst_time[i] << "\t\t | " << waiting_time[i] << "\t\t | " << turnaround_time[i] << endl;
    }
    cout << "Average waiting time: " << avg_waiting_time << endl;
    cout << "Average turnaround time: " << avg_turnaround_time << endl;

    return 0;
}