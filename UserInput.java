import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = input.nextLine();

        System.out.print("Enter your age: ");
        byte age = input.nextByte();
        input.nextLine();

        System.out.print("Enter your address: ");
        String address = input.nextLine();

        System.out.println("******************************\n");

        System.out.printf("Hello %s, you are welcome to NIIT%n", fullName);
        System.out.printf("%s you are %d years old%n", fullName, age);
        System.out.printf("You are living in %s%n", address);
    }
}