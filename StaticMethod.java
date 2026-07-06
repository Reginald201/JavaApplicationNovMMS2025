public class StaticMethod{
	
	//method
	
	public static void main(String[] args){
		System.out.println(StaticMethod.addNumber(8,45,28));
		System.out.println(StaticMethod.addNumber(100,29));
		System.out.println(StaticMethod.addNumber(18338,2823));
		System.out.println(StaticMethod.addNumber(183,379));
		System.out.println(StaticMethod.addNumber(182,737));
		System.out.println(StaticMethod.addNumber(10374,4939,118));
		System.out.println(StaticMethod.addNumber(1029,9837));
		System.out.println(StaticMethod.addNumber(1818,7389));
		System.out.println(StaticMethod.addNumber(7000,229));
	}
	
	//method
	public static int addNumber(int num1,int num2,int num3){
		int addition = num1 + num2 + num3;
		
		return addition;
	}
	public static int addNumber(int num1,int num2){
		int addition = num1 + num2;
		
		return addition;
	}
}