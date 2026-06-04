public class Datatype{
	public static void main(String[] args) {
		byte age = 25;
		System.out.printf("You are %d years old%n",age );
		
		short quantity = 30000;
		System.out.printf("I bought %,d quantity of phones%n",quantity);
		
		int population = 2025278260;
		System.out.printf("The population in Nigeria is %,d%n",population);
		
		long worldPopulation = 729737380000000L;
		System.out.printf("The world's population is %,d%n",worldPopulation);
		 
		 //Float-Point
		 float myBalance = 67060742.8672f;
		 System.out.printf("The CBN balance is %,.2f%n",myBalance);
		 
		 double cbnBalance = 848930939893893893.744463;
		 System.out.printf("The CBN balance is %,.2f%n",cbnBalance);
		 
		 char symbol = '@';
		 System.out.printf("Your email address is reginaldekeokparanata%cgmail.com%n",symbol);
		 
		 boolean isJava = true;
		 System.out.printf("Do you love learning java ? %b%n",isJava);
	}
}
	