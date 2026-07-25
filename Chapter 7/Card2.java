public class Card2 {
	
    private final String face;
    private final String suit;

    public Card2(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
} 