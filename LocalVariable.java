public class LocalVariable{

    public static void main(String[] args) {

        int age = 20;

        if (age >= 18) {
            int myAge = 30;
            System.out.printf("Miss mercy is %d years old%n", myAge);
        }
		
        System.out.printf("Your age is %d%n", age);
    }
}