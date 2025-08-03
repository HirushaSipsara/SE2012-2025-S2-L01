import java.util.Scanner;

public class Marks{
    static Scanner scanner = new Scanner(System.in);
    static int[][] studentMarks;
    static int n;

    public static void main(String[] args) {
        System.out.print("Enter your number of Students: ");
        n = scanner.nextInt();
        studentMarks = new int[n+1][4];

        System.out.println("Options:\n1.Add (add)\n2.Update (update)\n3.Average of a Subject (average_s)\n4.Average for a Student (average)\n5.Total mark of a Student (total)\n6.Calculate Grades (grades)\n7.Exit (exit)");
        while(true){
            System.out.print("Enter ther Option: ");
            String com = scanner.next();

            switch(com){
                case "add":
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    addMarks(studentID);
                    break;
                case "update":
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter Subject ID: ");
                    int subjectID = scanner.nextInt();
                    updateMark(studentID, subjectID);
                    break;
                case "average_s":
                    System.out.print("Enter subject ID: ");
                    studentID = scanner.nextInt();
                    averageSubject(studentID);
                    break;
                case "average":
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    averageStudent(studentID);
                    break;
                case "total":
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    totalMarks(studentID);
                    break;
                case "grades":
                    displayGrades();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }


    public static void addMarks(int studentID){
        if(studentID < 1 || studentID > n){
            System.out.println("Invalid Student ID");
            return;
        }

        System.out.print("Enter Maths Marsks: ");
        studentMarks[studentID][1] = scanner.nextInt();

        System.out.print("Enter Chemistry Marsks: ");
        studentMarks[studentID][2] = scanner.nextInt();

        System.out.print	("Enter Physics Marsks: ");
        studentMarks[studentID][3] = scanner.nextInt();
    }

    public static void updateMark(int studentID, int subjectID) {
        if (studentID < 1 || studentID > n || subjectID < 1 || subjectID > 3) {;
            System.out.println("Invalid Student ID OR Subject ID");
            return;
        }

        System.out.print("Enter new mark: ");
        studentMarks[studentID][subjectID] = scanner.nextInt();

        System.out.println("Mark updated for student " + studentID + " in subject " + subjectID);
    }

    public static void averageStudent(int studentID) {
        if (studentID < 1 || studentID > n) {
            System.out.println("Invalid Student ID");
            return;
        }

        int total = studentMarks[studentID][1] + studentMarks[studentID][2] + studentMarks[studentID][3];
        double avg = total / 3.0;
        System.out.printf("Average for student %d: %.2f\n", studentID, avg);
    }

    public static void totalMarks(int studentID) {
        if (studentID < 1 || studentID > n) {
            System.out.println("Invalid Student ID");
            return;
        }

        int total = studentMarks[studentID][1] + studentMarks[studentID][2] + studentMarks[studentID][3];
        System.out.println("Total marks for student " + studentID + ": " + total);
    }

    public static void averageSubject(int subjectID) {
        if (subjectID < 1 || subjectID > 3) {
            System.out.println("Invalid subject ID.");
            return;
        }

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += studentMarks[i][subjectID];
        }

        double avg = (double) total / n;
        System.out.printf("Average for subject %d: %.2f\n", subjectID, avg);
    }

    public static void displayGrades() {
        System.out.println("\nGrades Summary:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "StudentID", "Math", "Chemistry", "Physics");
        System.out.println("--------------------------------------------------");

        for (int i = 1; i <= n; i++) {
            String mathGrade = getGrade(studentMarks[i][1]);
            String chemGrade = getGrade(studentMarks[i][2]);
            String physGrade = getGrade(studentMarks[i][3]);

            System.out.printf("%-10d %-10s %-10s %-10s\n", i, mathGrade, chemGrade, physGrade);
        }
        System.out.println("--------------------------------------------------");
    }

    public static String getGrade(int score) {
        if (score >= 90) return "Grade A";
        if (score >= 80) return "Grade B";
        if (score >= 70) return "Grade C";
        if (score >= 60) return "Grade D";
        return "Fail";
    }
}