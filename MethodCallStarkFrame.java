public class  {
	public static void main(String[] args){
		int x =50;
		add(20,100);
		System.out.println(x);
	}
	
	public static void add(int x, int y){
		int sum = x + y;
		System.out.println(sum);
		check(15);
		
		
	}
    public static void check(int age){
		
		if(age <= 18){
			System.out.println("Yes you are an adult");
		
		
	    }
		else{
			System.out.println("No yo are not an adult");
		}
	}
	
}
	