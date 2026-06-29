import java.util.Scanner;

public class DoubleSelectionStatement{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		
		System.out.print("Enter password: ");
		String password = scan.nextLine();
		
		
		if (password.equals("Admin12345") && username.equals("johnwilliams")){
			System.out.printf("Access Granted; You are welcome");
		}
		else{
			System.out.printf("incorrect password or username");
		}
	}
}