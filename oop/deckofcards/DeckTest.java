import java.util.Arrays;
import java.util.ArrayList;

public class DeckTest{
    public static void main(String[] args){
        Deck deck = new Deck();

        //deck.showDeck();

        // deck.shuffle();
        //Card card = deck.deal();
        //System.out.println("This is a card: "+ card.suit + " " + card.value);

        //System.out.println("Current Deck size is " + deck.deckSize());

        Player p1 = new Player("Vicky", deck);
        p1.takeCard();
        p1.takeCard();
        p1.showHand();
        System.out.println("Current Deck size is " + deck.deckSize());
        p1.discardCard();
        p1.showHand();


    }
}