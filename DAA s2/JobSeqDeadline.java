import java.util.*;
class Container implements Comparable<Container> {
    private String jobName;
    private int profit;
    private int deadline;

    Container(String jobName, int profit, int deadline) {
        this.jobName = jobName;
        this.profit = profit;
        this.deadline = deadline;
    }

    public String getJobName() {
        return this.jobName;
    }

    public int getProfit() {
        return this.profit;
    }

    public int getDeadline() {
        return this.deadline;
    }

    @Override
    public int compareTo(Container other) { 
        return Integer.compare(other.getProfit(), this.getProfit());
    }
}

class JobSeqDeadline {
    public static void main(String s[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many jobs are there? : ");
        int numOfJobs = sc.nextInt();
        Container[] job = new Container[numOfJobs];
        int maxDeadline = 0;

        for (int i = 0; i < numOfJobs; i++) {
            System.out.print("Enter name, profit, weight of job " + (i + 1) + " (respectively) : ");
            String jobName = sc.next();
            int profit = sc.nextInt();
            int deadline = sc.nextInt();
            job[i] = new Container(jobName, profit, deadline);
            if (deadline > maxDeadline){
                maxDeadline = deadline;
            }
        }

        Arrays.sort(job);
        int[] sequence = new int[maxDeadline];
        int i=0;
        int inserted = 0;
        int totalProfit = 0;
        System.out.println("Job sequence : ");
        while (inserted < maxDeadline || i<numOfJobs){
            int index = job[i].getDeadline() - 1;
            if (sequence[index]==0){
                sequence[index] = job[i].getProfit();
                System.out.println(job[i].getJobName()+" : slot = "+index+" - "+ (index+1));
                totalProfit += job[i].getProfit();
                inserted++;
            }else{
                for(int j=index-1; j>=0; j--){
                    if(sequence[j]==0){
                        sequence[j] = job[i].getProfit();
                        System.out.println(job[i].getJobName()+" : slot = "+index+" - "+ (index+1));
                        totalProfit += job[i].getProfit();
                        inserted++;
                        break;
                    }
                }
            }
            i++;
        }
        System.out.println("\nTotal profit = "+totalProfit);
    }
}