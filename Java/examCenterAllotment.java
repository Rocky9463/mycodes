/*Write a java program for exam center allotment for candidate according to number of 
choice given by the candidate the application should be operated with following choices:
    1. Profile registration
    2. Enter center choices
    3. Show candidate details
    4. Show center details
    5. Show all center
    6. exit*/

import java.util.*;
public class examCenterAllotment{
    static int total_registration = 0;
    static int center1 = 33;
    static int center2 = 33;
    static int center3 = 34;
    Scanner scanner = new Scanner(System.in);
    Candidate[] candidate = new Candidate[5];
    class Candidate {
        String name;
        String dob;
        String fatherName;
        int uid;
        String[] center = {"NULL", "NULL", "NULL"};
        public Candidate(String name, String dob, String fatherName, int uid) {
            this.name = name;
            this.dob = dob;
            this.fatherName = fatherName;
            this.uid = uid;
        }
    }        
    
    public void registerProfile(){
        System.out.println("Enter details for student :");
        System.out.print("Name : ");
        String name = scanner.next();
        System.out.print("Date of Birth (dd-mm-yyyy): ");
        String dateOfBirth = scanner.next();
        System.out.print("Father's name : ");
        String fname = scanner.next();
        int uid = total_registration+112310;
        candidate[total_registration] = new Candidate(name, dateOfBirth, fname, uid);
        System.out.println("Profile registered successfully!!!\nYour UID : "+uid+"\n");
        total_registration++;
    }

    public int showCandidateDetails() {
        System.out.print("Enter UID : ");
        int uid = scanner.nextInt();
        int num = uid - 112310;
        if (num < total_registration && num >= 0){
            System.out.print("Name : ");
            System.out.println(candidate[num].name);
            System.out.print("Date of Birth (dd-mm-yyyy): ");
            System.out.println(candidate[num].dob);
            System.out.print("Father's name : ");
            System.out.println(candidate[num].fatherName);
            System.out.println("Centers : "+"\n1. "+candidate[num].center[0]+"\n2. "+candidate[num].center[1]+"\n3. "+candidate[num].center[2]+"\n");
        }else{
            System.out.println("Candidate not found\n");
            return -1;
        }
        return num;
    }

    public void enterCenterChoices(int num){
        if (num != -1){
            examCenterAllotment obj1 = new examCenterAllotment();
            System.out.println("+++ Center choices ++++");
            System.out.println("1. Center1 : "+ obj1.center1 + " seats available");
            System.out.println("2. Center2 : "+ obj1.center2 + " seats available");
            System.out.println("3. Center3 : "+ obj1.center3 + " seats available");
            
            int flag = 0;
            while (flag >=0 && flag <=2){
                int cn = flag+1;
                System.out.println("Enter choice for "+ cn +"st center : ");
                String choice = scanner.next();
                switch (choice){
                    case "1":
                        if (center1 > 0){
                            candidate[num].center[flag]="center1";
                            obj1.center1--;
                            flag++;
                            continue;
                        }else{
                            System.out.println("Center not available!!!!\nPlease try again");
                            continue;
                        }
                    case "2":
                        if (center1 > 0){
                            candidate[num].center[flag]="center2";
                            obj1.center2--;
                            flag++;
                            continue;
                        }else{
                            System.out.println("Center not available!!!!\nPlease try again");
                            continue;
                        }
                    case "3":
                        if (center1 > 0){
                            candidate[num].center[flag]="center3";
                            obj1.center3--;
                            flag++;
                            continue;
                        }else{
                            System.out.println("Center not available!!!!\nPlease try again");
                            continue;
                        }
                    default:
                        System.out.println("Invalid input!!!\nPlease try again");
                }
            }
            System.out.println();
        }
    }

    public void showCenterDetails(){
        examCenterAllotment obj1 = new examCenterAllotment();
        System.out.println("+++ Center choices ++++");
        System.out.println("1. Center1");
        System.out.println("2. Center2");
        System.out.println("3. Center3");
        System.out.println("Enter choice : ");
        String choice = scanner.next();
        switch (choice){
            case "1":
                System.out.println("Center name : center1");
                System.out.println("Total seats : 33");
                System.out.println("Free seats : "+obj1.center1+"\n");
                break;
            case "2":
                System.out.println("Center name : center2");
                System.out.println("Total seats : 33");
                System.out.println("Free seats : "+obj1.center1+"\n");
                break;
            case "3":
                System.out.println("Center name : center3");
                System.out.println("Total seats : 34");
                System.out.println("Free seats : "+obj1.center1+"\n");
                break;
            default:
                System.out.println("Invalid input!!!\n");
                break;
        }
    }

    public void showAllCenters(){
        examCenterAllotment obj1 = new examCenterAllotment();
        int freec1 = 33-obj1.center1;
        int freec2 = 33-obj1.center2;
        int freec3 = 34-obj1.center3;
        System.out.println("+++ Center choices ++++");
        System.out.println("1. Center1 \nTotal : 33   Alloted : "+freec1+"   Free : "+obj1.center1);
        System.out.println("2. Center2 \nTotal : 33   Alloted : "+freec2+"   Free : "+obj1.center2);
        System.out.println("3. Center3 \nTotal : 34   Alloted : "+freec3+"   Free : "+obj1.center3+"\n");
    }


    public static void main(String s[]){
        Scanner scanner = new Scanner(System.in);
        examCenterAllotment obj = new examCenterAllotment();
        String choice;

        do {
            System.out.println("Exam Center Allotment System");
            System.out.println("1. Profile registration");
            System.out.println("2. Enter center choices");
            System.out.println("3. Show candidate details");
            System.out.println("4. Show center details");
            System.out.println("5. Show all centers");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    obj.registerProfile();
                    break;
                case "2":
                    int num = obj.showCandidateDetails(); 
                    obj.enterCenterChoices(num);
                    break;
                case "3":
                    obj.showCandidateDetails();                    
                    break;
                case "4":
                    obj.showCenterDetails();
                    break;
                case "5":
                    obj.showAllCenters();
                    break;
                case "6":
                    System.out.println("Exiting the system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}