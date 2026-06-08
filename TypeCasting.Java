public class TypeCasting{
	public static void main(String[] args){
		double price = 567;
		System.out.printf("The price of the commodity is %f%n",price);
		
		
		double number = 67.459;
		
		int convertedNumber = (int)number;
		System.out.printf("The quantity is %d%n",convertedNumber);
		
		char symbol = '?';
		int convertedSymbol = (int)symbol;
		System.out.printf("ASCII code for ? is %d%n",convertedSymbol);
	}
}


