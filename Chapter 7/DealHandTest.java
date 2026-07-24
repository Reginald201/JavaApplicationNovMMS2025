
public class DealHandTest{
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Card[] hand = deck.dealHand(5);

        System.out.println("Hand dealt:");
        for (Card card : hand) {
            System.out.println("  " + card);
        }

        System.out.println("\nHand evaluation:");
        System.out.println("Pair:          " + deck.isPair(hand));
        System.out.println("Two pairs:     " + deck.isTwoPairs(hand));
        System.out.println("Three of kind: " + deck.isThreeOfAKind(hand));
        System.out.println("Four of kind:  " + deck.isFourOfAKind(hand));
        System.out.println("Flush:         " + deck.isFlush(hand));
        System.out.println("Straight:      " + deck.isStraight(hand));
        System.out.println("Full house:    " + deck.isFullHouse(hand));
    }
}