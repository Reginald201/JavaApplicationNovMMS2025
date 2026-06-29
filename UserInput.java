import java.util.Scanner;

public class UserInput{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = input.nextLine();

        System.out.print("Enter your age: ");
        byte age = input.nextByte();
        input.nextLine();

        System.out.print("Enter your address: ");
        String address = input.nextLine();

        System.out.print("Enter number of students in your class: ");
        short numberOfStudent = input.nextShort();
        input.nextLine();                    // good practice

        System.out.print("Enter number of students in your school: ");
        int studentsInSchool = input.nextInt();   // fixed: removed space
        input.nextLine();

        System.out.print("Enter your gender (M/F): ");
        char gender = input.next().charAt(0);

        System.out.println("*******************************");

        System.out.printf("Hello %s, you are welcome to NIIT%n", fullName);
        System.out.printf("%s you are %d years old%n", fullName, age);
        System.out.printf("%s your gender is %c%n", fullName, gender);
        System.out.printf("You are living in %s%n", address);
        System.out.printf("There are %d students in your class%n", numberOfStudent);
    }
}