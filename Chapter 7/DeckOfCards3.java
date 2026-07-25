import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class DeckOfCards3{
    private final Card[] deck = new Card[52];
    private int currentCard = 0;
    private static final SecureRandom randomNumbers = new SecureRandom();

    // Arrays initialized with the constants of the Face and Suit enums
    private static final Face[] FACES = Face.values();
    private static final Suit[] SUITS = Suit.values();

    // Constructor fills deck with Card objects
    public DeckOfCards3() {
        int count = 0;
        for (Suit suit : SUITS) {
            for (Face face : FACES) {
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

    // Returns a map of Face -> count of occurrences in the hand
    private Map<Face, Integer> faceCounts(Card[] hand) {
        Map<Face, Integer> counts = new HashMap<>();
        for (Card card : hand) {
            counts.merge(card.getFace(), 1, Integer::sum);
        }
        return counts;
    }

    public boolean isPair(Card[] hand) {
        int pairs = 0;
        for (int count : faceCounts(hand).values()) {
            if (count == 2) {
                pairs++;
            }
        }
        return pairs == 1;
    }

    public boolean isTwoPairs(Card[] hand) {
        int pairs = 0;
        for (int count : faceCounts(hand).values()) {
            if (count == 2) {
                pairs++;
            }
        }
        return pairs == 2;
    }

    public boolean isThreeOfAKind(Card[] hand) {
        for (int count : faceCounts(hand).values()) {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isFourOfAKind(Card[] hand) {
        for (int count : faceCounts(hand).values()) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlush(Card[] hand) {
        Suit suit = hand[0].getSuit();
        for (Card card : hand) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    // Uses each Face's ordinal() value (its position in the enum,
    // Ace = 0 .. King = 12) to check for five consecutive values.
    public boolean isStraight(Card[] hand) {
        int[] values = new int[hand.length];
        for (int i = 0; i < hand.length; i++) {
            values[i] = hand[i].getFace().ordinal();
        }
        java.util.Arrays.sort(values);

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i + 1] - values[i] != 1) {
                return false;
            }
        }
        return true;
    }

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