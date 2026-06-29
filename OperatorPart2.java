public class OperatorPart2{
	public static void main(String[] args){
		int num1 = 15;
		int num2 = 30;
		int num3 = 50;
		
		boolean isAndLogical = (num1 > num2) && (num1 > num2);
		
		boolean isOrLogical = (num1 > num2)  || (num1 > num2);
		
		boolean isNotLogical = ! (num1 > num2) ||  (num1 > num2);
		
		
		System.out.printf("(%d > %d) && (%d > %d) = %b%n",num1,num2,num1,num3,isAndLogical);
		
		System.out.printf("(%d > %d) || (%d > %d) = %b%n",num1,num2,num1,num3,isOrLogical);
		
		System.out.printf("!(%d > %d) || (%d > %d) = %b%n",num1,num2,num1,num3,isNotLogical);
	}
} 