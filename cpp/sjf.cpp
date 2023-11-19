#include <iostream>
#include <algorithm>
using namespace std;

struct Process {
    int pid;
    int arrival_time;
    int burst_time;
    int completion_time;
    int turnaround_time;
    int waiting_time;
    int start_time;
    // bool operator<(const Process& other) const {
    //     return burst_time < other.burst_time;
    // }
};

void calculate(Process [], int);
void display(Process [], int);

int main() {
    int n;
    cout << "Enter number of processes: ";
    cin >> n;

    Process p[n];

    for(int i=0; i<n; i++) {
        cout << "Enter arrival time and burst time for process " << i+1 << ": ";
        cin >> p[i].arrival_time >> p[i].burst_time;
        p[i].pid = i+1;
        p[i].completion_time = 0;
        p[i].turnaround_time = 0;
        p[i].waiting_time = 0;
        p[i].start_time = 0;
    }

    calculate(p, n);

    display(p, n);

    return 0;
}

void calculate(Process p[], int n) {
    int i, j;
    for(i=0; i<n-1; i++) {
      for(j=i+1; j<n; j++) {
        if(p[i].arrival_time > p[j].arrival_time) {
          swap(p[i], p[j]);
        }
      }
    }

    int current_time = 0;
    for(int i=0; i<n; i++) {
        p[i].start_time = max(current_time, p[i].arrival_time);
        p[i].completion_time = p[i].start_time + p[i].burst_time;
        p[i].turnaround_time = p[i].completion_time - p[i].arrival_time;
        p[i].waiting_time = p[i].turnaround_time - p[i].burst_time;
        current_time = p[i].completion_time;
    }
}

void display(Process p[], int n) {
    double average_turnaround_time = 0, average_waiting_time = 0;
    for(int i=0; i<n; i++) {
        cout << "Process " << p[i].pid << ":\n";
        cout << "Arrival time: " << p[i].arrival_time << endl;
        cout << "Burst time: " << p[i].burst_time << endl;
        cout << "Completion time: " << p[i].completion_time << endl;
        cout << "Turnaround time: " << p[i].turnaround_time << endl;
        cout << "Waiting time: " << p[i].waiting_time << endl;
        cout << "-------------------------------\n";
        average_turnaround_time += p[i].turnaround_time;
        average_waiting_time += p[i].waiting_time;
    }
    average_turnaround_time /= n;
    average_waiting_time /= n;
    cout << "Average turnaround time: " << average_turnaround_time << endl;
    cout << "Average waiting time: " << average_waiting_time << endl;
}
