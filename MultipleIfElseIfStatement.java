import java.util.Scanner;

public class MultipleIfElseIfStatement{  
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter your fullName: ");
		String fullName = scan.nextLine();
		
		System.out.print("Enter your mark: ");
		int mark = scan.nextInt();
		
		if(mark >= 70){
			System.out.println("=======================\n");
			System.out.printf("Student Name : %s%n",fullName);
			System.out.printf("Student Mark : %s%n",mark);
			System.out.println("Student Grade : A");
			System.out.println("=======================\n\n");
		}
		else if(mark >= 60){
			System.out.println("=======================\n");
			System.out.printf("Student Name : %s%n",fullName);
			System.out.printf("Student Mark : %s%n",mark);
			System.out.println("Student Grade : B");
			System.out.println("=======================\n\n");
		}
		else if(mark >= 50){
			System.out.println("=======================\n");
			System.out.printf("Student Name : %s%n",fullName);
			System.out.printf("Student Mark : %s%n",mark);
			System.out.println("Student Grade : C");
			System.out.println("=======================\n\n");
		}
		else if(mark >= 40){
			System.out.println("=======================\n");
			System.out.printf("Student Name : %s%n",fullName);
			System.out.printf("Student Mark : %s%n",mark);
			System.out.println("Student Grade : D");
			System.out.println("=======================\n\n");
		}
		else{
			System.out.println("=======================\n");
			System.out.printf("Student Name : %s%n",fullName);
			System.out.printf("Student Mark : %s%n",mark);
			System.out.println("Student Grade : F");
			System.out.println("=======================\n\n");
		}
	}
}