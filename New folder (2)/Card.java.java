// Card.java
// Represents a single playing card with a face and a suit.
public class Card{
    private final String face;
    private final String suit;

    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    // Returns this card's face (e.g., "Jack")
    public String getFace() {
        return face;
    }

    // Returns this card's suit (e.g., "Hearts")
    public String getSuit() {
        return suit;
    }

    // Returns String representation of Card object
    @Override
    public String toString() {
        return face + " of " + suit;
    }
}

