
public class TwoHandTest{

    // Hand rank constants (higher number = stronger hand)
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

    // Uses the Exercise 1 boolean methods to determine a hand's rank
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

    private static void printHand(String label, Card[] hand, int rank) {
        System.out.println(label + ":");
        for (Card card : hand) {
            System.out.println("  " + card);
        }
        System.out.println("  --> " + RANK_NAMES[rank]);
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Card[] hand1 = deck.dealHand(5);
        Card[] hand2 = deck.dealHand(5);

        int rank1 = evaluateHand(deck, hand1);
        int rank2 = evaluateHand(deck, hand2);

        printHand("Player 1's hand", hand1, rank1);
        System.out.println();
        printHand("Player 2's hand", hand2, rank2);
        System.out.println();

        if (rank1 > rank2) {
            System.out.println("Player 1 wins!");
        } else if (rank2 > rank1) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie (same hand ranking)!");
        }
    }
}