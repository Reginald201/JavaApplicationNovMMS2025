import java.util.Scanner;

public class AirlineReservations{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[11]; // index 0 unused, seats 1-10
        boolean moreCustomers = true;

        while (moreCustomers) {
            System.out.println("Please type 1 for First Class");
            System.out.println("Please type 2 for Economy");
            int choice = input.nextInt();

            if (choice == 1) {
                assignSeat(input, seats, 1, 5, 6, 10);
            } else if (choice == 2) {
                assignSeat(input, seats, 6, 10, 1, 5);
            } else {
                System.out.println("Invalid choice.");
            }

            System.out.print("Assign another seat? (yes/no): ");
            moreCustomers = input.next().equalsIgnoreCase("yes");
        }

        input.close();
    }

    private static void assignSeat(Scanner input, boolean[] seats,
            int start, int end, int altStart, int altEnd) {
        for (int seat = start; seat <= end; seat++) {
            if (!seats[seat]) {
                seats[seat] = true;
                System.out.println("Boarding pass: Seat " + seat +
                        (start == 1 ? " (First Class)" : " (Economy)"));
                return;
            }
        }

        // Preferred section full; offer the alternate section.
        System.out.print("That section is full. Accept a seat in the other section? (yes/no): ");
        if (input.next().equalsIgnoreCase("yes")) {
            for (int seat = altStart; seat <= altEnd; seat++) {
                if (!seats[seat]) {
                    seats[seat] = true;
                    System.out.println("Boarding pass: Seat " + seat +
                            (altStart == 1 ? " (First Class)" : " (Economy)"));
                    return;
                }
            }
            System.out.println("Next flight leaves in 3 hours.");
        } else {
            System.out.println("Next flight leaves in 3 hours.");
        }
    }
}