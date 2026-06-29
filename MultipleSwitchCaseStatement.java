import java.util.Scanner;

public class MultipleSwitchCaseStatement{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your fullname: ");
		String fullname = input.nextLine();
		
		System.out.print("enter your mark: ");
		int mark = input.nextInt();
		
		switch(mark/10) {
			case 0:
			case 1:
			case 2:
			case 3:
					System.out.println("===========================\n");
					System.out.printf("Student name: %s%n",fullname);
					System.out.printf("Student Mark: %d%n",mark);
					System.out.println("Student grade: F");
					System.out.println("===========================\n\n");
			break;
			
			case 4:
					System.out.println("===========================\n");
					System.out.printf("Student name: %s%n",fullname);
					System.out.printf("Student Mark: %d%n",mark);
					System.out.println("Student grade: D");
					System.out.println("===========================\n\n");
			break;
			
			case 5:
					System.out.println("===========================\n");
					System.out.printf("Student name: %s%n",fullname);
					System.out.printf("Student Mark: %d%n",mark);
					System.out.println("Student grade: C");
					System.out.println("===========================\n\n");
			break;
			
			case 6:
					System.out.println("===========================\n");
					System.out.printf("Student name: %s%n",fullname);
					System.out.printf("Student Mark: %d%n",mark);
					System.out.println("Student grade: B");
					System.out.println("===========================\n\n");
			break;
			
			case 7:
			case 8:
			case 9:
			case 10:
					System.out.println("===========================\n");
					System.out.printf("Student name: %s%n",fullname);
					System.out.printf("Student Mark: %d%n",mark);
					System.out.println("Student grade: A");
					System.out.println("===========================\n\n");
			break;
			default:
			System.out.println("Invalid Input");
		}
	}
}