import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DealerSimulation{

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

    // Groups the hand's card indices by face, e.g. "King" -> [1, 4]
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

    // Decides which card indices (0-4) the dealer should discard,
    // based on the strength of the hand. Straight/flush/full house/
    // four of a kind hands are kept as-is (no discards).
    private static List<Integer> chooseDiscards(Card[] hand, int rank) {
        List<Integer> discards = new ArrayList<>();

        if (rank == FOUR_OF_A_KIND || rank == FULL_HOUSE
                || rank == FLUSH || rank == STRAIGHT) {
            return discards; // keep the whole hand
        }

        Map<String, List<Integer>> groups = groupByFace(hand);

        if (rank == THREE_OF_A_KIND || rank == TWO_PAIRS || rank == PAIR) {
            // Discard every card that is NOT part of a pair/triple
            for (List<Integer> indices : groups.values()) {
                if (indices.size() == 1) {
                    discards.add(indices.get(0));
                }
            }
        } else { // HIGH_CARD: discard the three lowest-value cards
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
        for (Card card : hand) {
            System.out.println("  " + card);
        }
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        // Dealer's hand is dealt "face down" -- evaluated internally,
        // not printed yet.
        Card[] dealerHand = deck.dealHand(5);
        int originalRank = evaluateHand(deck, dealerHand);

        System.out.println("Dealer's hand is dealt face down.");
        System.out.println("(Original hand and rank revealed below for demonstration purposes.)\n");
        printHand("Dealer's original hand", dealerHand);
        System.out.println("  --> " + RANK_NAMES[originalRank]);

        List<Integer> discardIndices = chooseDiscards(dealerHand, originalRank);

        if (discardIndices.isEmpty()) {
            System.out.println("\nDealer's hand is strong -- no cards drawn.");
        } else {
            System.out.println("\nDealer draws " + discardIndices.size()
                + " replacement card(s) for the unneeded card(s).");
            for (int index : discardIndices) {
                dealerHand[index] = deck.dealCard();
            }
        }

        int finalRank = evaluateHand(deck, dealerHand);

        System.out.println();
        printHand("Dealer's final hand", dealerHand);
        System.out.println("  --> " + RANK_NAMES[finalRank]);
    }
}