
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class DeckOfCards{
	public static void main(String[] args) {
        DeckOfCards myDeck = new DeckOfCards();
        myDeck.shuffle();
        System.out.println(myDeck);
    }
	
    private final Card[] deck = new Card[52];
    private int currentCard = 0;
    private static final SecureRandom randomNumbers = new SecureRandom();

    private static final String[] FACES = {
        "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"
    };
    private static final String[] SUITS = {
        "Hearts", "Diamonds", "Clubs", "Spades"
    };

    // Constructor fills deck with Card objects
    public DeckOfCards() {
        int count = 0;
        for (String suit : SUITS) {
            for (String face : FACES) {
                deck[count] = new Card(face, suit);
                count++;
            }
        }
    }

    // Shuffles deck using the Fisher-Yates-style swap approach
    public void shuffle() {
        currentCard = 0;
        for (int first = deck.length - 1; first > 0; first--) {
            int second = randomNumbers.nextInt(first + 1);
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    // Deals one Card
    public Card dealCard() {
        if (currentCard < deck.length) {
            return deck[currentCard++];
        } else {
            return null;
        }
    }

    // Deals a hand of the given size (e.g., 5 for poker)
    public Card[] dealHand(int handSize) {
        Card[] hand = new Card[handSize];
        for (int i = 0; i < handSize; i++) {
            hand[i] = dealCard();
        }
        return hand;
    }

    // Returns a map of face -> count of occurrences in the hand
    private Map<String, Integer> faceCounts(Card[] hand) {
        Map<String, Integer> counts = new HashMap<>();
        for (Card card : hand) {
            counts.merge(card.getFace(), 1, Integer::sum);
        }
        return counts;
    }

    // Returns the numeric rank of a face (Ace low = 1 .. King = 13)
    private int faceValue(String face) {
        for (int i = 0; i < FACES.length; i++) {
            if (FACES[i].equals(face)) {
                return i + 1;
            }
        }
        return -1;
    }

    // a) Returns true if hand contains exactly one pair
    public boolean isPair(Card[] hand) {
        int pairs = 0;
        for (int count : faceCounts(hand).values()) {
            if (count == 2) {
                pairs++;
            }
        }
        return pairs == 1;
    }

    // b) Returns true if hand contains two distinct pairs
    public boolean isTwoPairs(Card[] hand) {
        int pairs = 0;
        for (int count : faceCounts(hand).values()) {
            if (count == 2) {
                pairs++;
            }
        }
        return pairs == 2;
    }

    // c) Returns true if hand contains three of a kind
    public boolean isThreeOfAKind(Card[] hand) {
        for (int count : faceCounts(hand).values()) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    // d) Returns true if hand contains four of a kind
    public boolean isFourOfAKind(Card[] hand) {
        for (int count : faceCounts(hand).values()) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    // e) Returns true if all five cards share the same suit
    public boolean isFlush(Card[] hand) {
        String suit = hand[0].getSuit();
        for (Card card : hand) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    // f) Returns true if the five cards have consecutive face values
    public boolean isStraight(Card[] hand) {
        int[] values = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            values[i] = faceValue(hand[i].getFace());
        }
        java.util.Arrays.sort(values);

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i + 1] - values[i] != 1) {
                return false;
            }
        }
        // Reject duplicate faces sorted adjacently (e.g., a pair) from
        // being miscounted; a true straight has 5 distinct values already
        // guaranteed by the consecutive check above.
        return true;
    }

    // g) Returns true if hand is a full house (three of one face, two of another)
    public boolean isFullHouse(Card[] hand) {
        boolean hasThree = false;
        boolean hasTwo = false;
        for (int count : faceCounts(hand).values()) {
            if (count == 3) {
                hasThree = true;
            } else if (count == 2) {
                hasTwo = true;
            }
        }
        return hasThree && hasTwo;
    }

    // Returns String representation of deck
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++) {
            sb.append(String.format("%-19s", deck[i].toString()));
            if ((i + 1) % 4 == 0) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}