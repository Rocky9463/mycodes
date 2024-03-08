//WAP to create a class student having attribute rollno, enrollment, date of birth and total marks, now take input for five students and store accordingly, now display all student data in ascending order of rollno
import java.util.*;
public class Student {
    private int rollNo;
    private String enrollment;
    private String dateOfBirth;
    private int totalMarks;

    public Student(int rollNo, String enrollment, String dateOfBirth, int totalMarks) {
        this.rollNo = rollNo;
        this.enrollment = enrollment;
        this.dateOfBirth = dateOfBirth;
        this.totalMarks = totalMarks;
    }

    public int getRollNo() {
        return rollNo;
    }
    public static void main(String[] args) {
        Student[] students = new Student[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int rollNo = scanner.nextInt();
            System.out.print("Enrollment: ");
            String enrollment = scanner.next();
            System.out.print("Date of Birth (dd-mm-yyyy): ");
            String dateOfBirth = scanner.next();
            System.out.print("Total Marks: ");
            int totalMarks = scanner.nextInt();
            System.out.println("\n");
            students[i] = new Student(rollNo, enrollment, dateOfBirth, totalMarks);
        }

        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i+1; j < students.length; j++) {
                if (students[i].getRollNo() > students[j].getRollNo()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        System.out.println("\nStudents sorted by Roll No: \n");
        for (Student s : students) {
            System.out.println("Roll no. : "+s.rollNo+"  \nEnrollment : "+ s.enrollment);
            System.out.println("DOB : "+s.dateOfBirth+"  \nTotal marks : "+ s.totalMarks+"\n");
        }
    }



}
