import java.util.Scanner;

public class Polling{
    public static void main(String[] args) {
        String[] topics = {
                "Climate Change",
                "Education Access",
                "Public Health",
                "Poverty Reduction",
                "Digital Privacy"
        };

        int[][] responses = new int[5][10]; // [topic][rating-1]
        Scanner input = new Scanner(System.in);

        System.out.print("How many respondents? ");
        int respondentCount = input.nextInt();

        for (int r = 1; r <= respondentCount; r++) {
            System.out.println("\nRespondent " + r + ":");
            for (int t = 0; t < topics.length; t++) {
                int rating;
                do {
                    System.out.printf("Rate \"%s\" (1-10): ", topics[t]);
                    rating = input.nextInt();
                } while (rating < 1 || rating > 10);
                responses[t][rating - 1]++;
            }
        }

        // a) Tabular report
        System.out.printf("%-20s", "Issue");
        for (int rating = 1; rating <= 10; rating++) {
            System.out.printf("%-4d", rating);
        }
        System.out.println("Average");

        int[] topicTotals = new int[topics.length];
        for (int t = 0; t < topics.length; t++) {
            System.out.printf("%-20s", topics[t]);
            int sum = 0;
            for (int rating = 1; rating <= 10; rating++) {
                int count = responses[t][rating - 1];
                System.out.printf("%-4d", count);
                sum += count * rating;
            }
            topicTotals[t] = sum;
            double average = respondentCount == 0 ? 0 : (double) sum / respondentCount;
            System.out.printf("%.2f%n", average);
        }

        // c) and d) Highest and lowest point totals
        int highestIndex = 0, lowestIndex = 0;
        for (int t = 1; t < topics.length; t++) {
            if (topicTotals[t] > topicTotals[highestIndex]) {
                highestIndex = t;
            }
            if (topicTotals[t] < topicTotals[lowestIndex]) {
                lowestIndex = t;
            }
        }

        System.out.println("\nHighest total: " + topics[highestIndex] + " (" + topicTotals[highestIndex] + " points)");
        System.out.println("Lowest total: " + topics[lowestIndex] + " (" + topicTotals[lowestIndex] + " points)");

        input.close();
    }
}