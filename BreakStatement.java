public class BreakStatement{
	public static void main(String[] args){
		
		for(int i = 2; i <= 20; i++){
			if(i == 15){
				break;
			}
			System.out.printf("%d%n",i);
		}
	}
}