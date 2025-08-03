import java.util.Scanner;

public class Welcome{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your First Name: ");

        String fname = input.nextLine();

        System.out.print("Enter your Last Name: ");

        String lname = input.nextLine();

        System.out.print("Username is: " + fname + " " + lname);
    }
}
