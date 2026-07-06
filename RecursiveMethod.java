public class RecursiveMethod{
	
	public static void main(String[] args){
		displayName("John Williams");
		
	}
	public static void displayName(String name){
		System.out.println(name);
		
		displayName("John Williams");
	}
}