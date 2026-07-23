// IntegerSetTest.java
public class IntegerSetTest {
    public static void main(String[] args) {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();

        setA.insertElement(1);
        setA.insertElement(2);
        setA.insertElement(3);

        setB.insertElement(3);
        setB.insertElement(4);
        setB.insertElement(5);

        System.out.println("setA: " + setA);
        System.out.println("setB: " + setB);

        IntegerSet unionSet = IntegerSet.union(setA, setB);
        System.out.println("union: " + unionSet);

        IntegerSet intersectionSet = IntegerSet.intersection(setA, setB);
        System.out.println("intersection: " + intersectionSet);

        setA.deleteElement(2);
        System.out.println("\nsetA after deleting 2: " + setA);

        IntegerSet emptySet = new IntegerSet();
        System.out.println("emptySet: " + emptySet);

        IntegerSet setC = new IntegerSet();
        setC.insertElement(3);
        setC.insertElement(4);
        setC.insertElement(5);
        System.out.println("\nsetB equals setC? " + setB.isEqualTo(setC));
        System.out.println("setA equals setB? " + setA.isEqualTo(setB));
    }
}
