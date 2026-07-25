import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PokerGame{

    private static final int HIGH_CARD = 0;
    private static final int PAIR = 1;
    private static final int TWO_PAIRS = 2;
    private static final int THREE_OF_A_KIND = 3;
    private static final int STRAIGHT = 4;
    private static final int FLUSH = 5;
    private static final int FULL_HOUSE = 6;
    private static final int FOUR_OF_A_KIND = 7;

    private static final String[] RANK_NAMES = {
        "High card", "Pair", "Two pairs", "Three of a kind",
        "Straight", "Flush", "Full house", "Four of a kind"
    };

    private static final String[] FACE_ORDER = {
        "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"
    };

    private static int faceValue(String face) {
        for (int i = 0; i < FACE_ORDER.length; i++) {
            if (FACE_ORDER[i].equals(face)) {
                return i + 1;
            }
        }
        return -1;
    }

    private static Map<String, List<Integer>> groupByFace(Card[] hand) {
        Map<String, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            groups.computeIfAbsent(hand[i].getFace(), k -> new ArrayList<>()).add(i);
        }
        return groups;
    }

    private static int evaluateHand(DeckOfCards deck, Card[] hand) {
        if (deck.isFourOfAKind(hand)) {
            return FOUR_OF_A_KIND;
        } else if (deck.isFullHouse(hand)) {
            return FULL_HOUSE;
        } else if (deck.isFlush(hand)) {
            return FLUSH;
        } else if (deck.isStraight(hand)) {
            return STRAIGHT;
        } else if (deck.isThreeOfAKind(hand)) {
            return THREE_OF_A_KIND;
        } else if (deck.isTwoPairs(hand)) {
            return TWO_PAIRS;
        } else if (deck.isPair(hand)) {
            return PAIR;
        } else {
            return HIGH_CARD;
        }
    }

    // Automatic dealer discard strategy (same as Exercise 3)
    private static List<Integer> dealerChooseDiscards(Card[] hand, int rank) {
        List<Integer> discards = new ArrayList<>();

        if (rank == FOUR_OF_A_KIND || rank == FULL_HOUSE
                || rank == FLUSH || rank == STRAIGHT) {
            return discards;
        }

        Map<String, List<Integer>> groups = groupByFace(hand);

        if (rank == THREE_OF_A_KIND || rank == TWO_PAIRS || rank == PAIR) {
            for (List<Integer> indices : groups.values()) {
                if (indices.size() == 1) {
                    discards.add(indices.get(0));
                }
            }
        } else {
            List<Integer> order = new ArrayList<>();
            for (int i = 0; i < hand.length; i++) {
                order.add(i);
            }
            order.sort((a, b) ->
                faceValue(hand[a].getFace()) - faceValue(hand[b].getFace()));
            discards.add(order.get(0));
            discards.add(order.get(1));
            discards.add(order.get(2));
        }

        return discards;
    }

    private static void printHand(String label, Card[] hand) {
        System.out.println(label + ":");
        for (int i = 0; i < hand.length; i++) {
            System.out.println("  [" + i + "] " + hand[i]);
        }
    }

    // Lets the player pick which of their own cards to replace
    private static List<Integer> playerChooseDiscards(Scanner input, Card[] hand) {
        System.out.print("Enter the numbers of the cards you want to replace "
            + "(0-4, space-separated), or press Enter to keep all: ");
        String line = input.nextLine().trim();

        List<Integer> discards = new ArrayList<>();
        if (line.isEmpty()) {
            return discards;
        }

        for (String token : line.split("\\s+")) {
            try {
                int index = Integer.parseInt(token);
                if (index >= 0 && index < hand.length && !discards.contains(index)) {
                    discards.add(index);
                }
            } catch (NumberFormatException e) {
                System.out.println("Ignoring invalid entry: " + token);
            }
        }
        return discards;
    }

    private static void playOneGame(Scanner input, int[] score) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Card[] playerHand = deck.dealHand(5);
        Card[] dealerHand = deck.dealHand(5); // dealt face down

        System.out.println();
        printHand("Your hand", playerHand);

        List<Integer> playerDiscards = playerChooseDiscards(input, playerHand);
        for (int index : playerDiscards) {
            playerHand[index] = deck.dealCard();
        }

        int dealerOriginalRank = evaluateHand(deck, dealerHand);
        List<Integer> dealerDiscards = dealerChooseDiscards(dealerHand, dealerOriginalRank);
        for (int index : dealerDiscards) {
            dealerHand[index] = deck.dealCard();
        }

        int playerRank = evaluateHand(deck, playerHand);
        int dealerRank = evaluateHand(deck, dealerHand);

        System.out.println();
        printHand("Your final hand", playerHand);
        System.out.println("  --> " + RANK_NAMES[playerRank]);

        System.out.println();
        printHand("Dealer's final hand", dealerHand);
        System.out.println("  --> " + RANK_NAMES[dealerRank]);

        System.out.println();
        if (playerRank > dealerRank) {
            System.out.println("You win this round!");
            score[0]++;
        } else if (dealerRank > playerRank) {
            System.out.println("Dealer wins this round!");
            score[1]++;
        } else {
            System.out.println("This round is a tie!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] score = new int[2]; // [0] = player wins, [1] = dealer wins

        System.out.print("How many games would you like to play? (e.g., 20): ");
        int numGames;
        try {
            numGames = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            numGames = 20;
        }

        for (int game = 1; game <= numGames; game++) {
            System.out.println("\n================ Game " + game + " ================");
            playOneGame(input, score);
        }

        System.out.println("\n================ Final Results ================");
        System.out.println("You won:    " + score[0] + " game(s)");
        System.out.println("Dealer won: " + score[1] + " game(s)");
        System.out.println("Ties:       " + (numGames - score[0] - score[1]) + " game(s)");

        input.close();
    }
}