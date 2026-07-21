import java.util.Scanner;

public class MethodOverloading{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		MethodOverloading mol = new MethodOverloading();
			System.out.println("Calculating the perimeter of different shapes");
			System.out.println("Enter 1 for Square");
			System.out.println("Enter 2 for Rectangle");
			System.out.println("Enter 3 for Circle");
			System.out.println("Enter 4 for Trapezium");
			System.out.println("Enter 5 to exit");
			
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			
			switch(choice){
				case 1:
						System.out.println("You want to calculate the perimeter of a square");
						
						System.out.printf("Please enter the length of the square: ");
						int lengthofsquare = scan.nextInt();
						
						System.out.printf("The perimeter of the square is %d%n", mol.perimeter(lengthofsquare));
				break;
			
				case 2:
						System.out.println("You want to calculate the perimeter of a rectangle");
						
						System.out.printf("Please enter the length of the rectangle: ");
						int lengthofrectangle = scan.nextInt();
						
						System.out.printf("Please enter the breadth of the rectangle: ");
						int breadthofrectangle = scan.nextInt();
						
						System.out.printf("The perimeter of the rectangle is %d%n", mol.perimeter(lengthofrectangle),(breadthofrectangle));
				break;

				case 3:
						System.out.println("You want to calculate the perimeter of a circle");
						
						System.out.printf("Please enter the radius of the circle: ");
						double radiusofcircle = scan.nextDouble();
						
						System.out.printf("The perimeter of the circle is %f%n", mol.perimeter(radiusofcircle));
				break;
				
				case 4:
						System.out.println("You want to calculate the perimeter of a trapezium");
						
						System.out.printf("Please enter the side1 of the trapezium: ");
						int side1oftrapezium = scan.nextInt();
						
						System.out.printf("Please enter the side2 of the trapezium: ");
						int side2oftrapezium = scan.nextInt();
						
						System.out.printf("Please enter the side3 of the trapezium: ");
						int side3oftrapezium = scan.nextInt();
						
						System.out.printf("Please enter the side4 of the trapezium: ");
						int side4oftrapezium = scan.nextInt();
						
			System.out.printf("The perimeter of the trapezium is %d%n", mol.perimeter(side1oftrapezium),(side2oftrapezium),(side3oftrapezium),(side4oftrapezium));
				break;
				default:
				System.out.println("Program exited, bye for now..............");
		}
	}
	public int perimeter(int length){
		int per = 4*length;
		return per;
	}
	public int perimeter(int length, int breadth){
		int per = 2*(length + breadth);
		return per;
	}
	public int perimeter(int side1, int side2, int side3, int side4){
		int per = side1 + side2 + side3 + side4;
		return per;
	}
	public double perimeter(double radius){
		double per = 2 * Math.PI * radius;
		return per;
	}
}