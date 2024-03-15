/*Write a java program of voting machine according to following criteria:
at starting the program should show options :
    1. Vote casting
    2. Show candidates vote
    3. Show comprehensive result
    4. Exit

When we choose choice 1 for vote casting, then each vote which is divisible by 5 or 7 is 
given to candidate no. 2 but message should be displayed that vote is given to selected candidate

When we choose choice 2 for showing candidate's result then it will ask for which candidate, 
then display the number of votes the candidate has got 

on selecting the third option it should data of each candidate*/ 

import java.util.Scanner;
public class voting_machine {
    static int A, B, C; //Candidates
    static int totalVotes;

    public void voteCasting(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===  CANDIDATES ===");
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");
        System.out.print("Select candidate: ");
        String vote = sc.next();
        totalVotes++;
        if(totalVotes%5==0 || totalVotes%7==0){
            B++;
            if (vote.equals("1")){
                System.out.println("You voted candidate A");
            }else if(vote.equals("2")){
                System.out.println("You voted candidate B");
            } else if(vote.equals("3")){
            System.out.println("You voted candidate C");
            }
            return;
        } else if(vote.equals("1")){
            A++;
            System.out.println("You voted candidate A");
        } else if(vote.equals("2")){
            B++;
            System.out.println("You voted candidate B");
        } else if(vote.equals("3")){
            C++;
            System.out.println("You voted candidate C");
        } else{
            System.out.println("Invalid Vote!!!\n");
        }
        System.out.println("Thanks for Voting!!!\n");
    }

    public void CandidateVotes(){
        System.out.println("===  CANDIDATES ===");
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");
        System.out.print("Select candidate: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        if(name.equals("1")){
            System.out.println("\nVotes of Candidate A: \n Votes: " + A + ", Total Votes: " + totalVotes + "\n");
        } else if(name.equals("2")){
            System.out.println("Votes of Candidate B: \n Votes: " + B + ", Total Votes: " + totalVotes + "\n");
        } else if(name.equals("3")){
            System.out.println("Votes of Candidate C: \n Votes: " + C + ", Total Votes: " + totalVotes + "\n");
        } else{
            System.out.println("Invalid Candidate!!!\n");
        }
    }

    public void comprehensiveResult(){
        System.out.println("\nComprehensive Result:");
        System.out.println("Party A: \nVotes: " + A + ", Total Votes: " + totalVotes);
        System.out.println("Party B: \nVotes: " + B + ", Total Votes: " + totalVotes);
        System.out.println("Party C: \nVotes: " + C + ", Total Votes: " + totalVotes);
        System.out.println("--------------------------------");
        int max = Math.max(Math.max(A, B), C);
        if (A == B && A == C && B == C){System.out.print("Its a draw between : A & B & C");}
        else if (A == B){System.out.print("Its a draw between : A & B");}
        else if (A == C){System.out.print("Its a draw between : A & B");}
        else if (C == B){System.out.print("Its a draw between : A & B");}
        else if (max == A){System.out.println("Winner candidate : A");
        }else if (max == B){System.out.println("Winner candidate : B");
        }else if (max == C){System.out.println("Winner candidate : C");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        voting_machine el = new voting_machine();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Vote Casting");
            System.out.println("2. Show Candidate's Vote");
            System.out.println("3. Show Comprehensive Result");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            String choice = sc.next();

            switch (choice) {
                case "1":
                    el.voteCasting();
                    break;
                case "2":
                    el.CandidateVotes();
                    break;
                case "3":
                    el.comprehensiveResult();
                    break;
                case "4":
                    System.out.println("Terminating program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!!!\n");
            }
        }
    }
}