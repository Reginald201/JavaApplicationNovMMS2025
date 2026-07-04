public class ReturnStatement{

    public static void main(String[] args) {

        System.out.println("The area of the rectangular is " + areaOfRectangular(7, 20));
		System.out.println("The area of the rectangular is " + areaOfRectangular(76, 20));
		System.out.println("The area of the rectangular is " + areaOfRectangular(20, 100));
		System.out.println("The area of the rectangular is " + areaOfRectangular(90, 20));
		System.out.println("The area of the rectangular is " + areaOfRectangular(30, 20));

    }

    public static int areaOfRectangular(int length, int height) {

        int area = length * height;

        return area;
    }
}