import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class Deck {
    private Stack<Card> cards;
    String newLine = System.getProperty("line.separator");
    
    // Constructs an empty deck
    public Deck() {
        this(new ArrayList<Card>());
        this.initDeck();
    }
    
    // Constructs a deck with the given list of cards.
    // The order of the deck is determined by the order of the list, the first
    // card in the list is the top of the deck and the last card is the bottom.
    public Deck(List<Card> cards) {
        this.cards = new Stack<Card>();
        for (int i = cards.size() - 1; i >= 0; i--) {
            this.cards.push(cards.get(i));
        }
    }
 
    // Returns true if there is a card remaining in the deck, false otherwise.
    public boolean hasNextCard() {
        return !this.cards.isEmpty();
    }
    
    // pre: The deck has another card, throws IllegalStateException otherwise
    // Returns the card at the top of the deck
    public Card deal() {
        if (!this.hasNextCard()) {
            throw new IllegalStateException("No more cards in deck");
        }
        return this.cards.pop();
    }
    
    // Puts the given card at the top of the deck
    public void putCard(Card card) {
        this.cards.push(card);
    }

    public int deckSize(){
        return this.cards.size();
    }

    public void resetDeck(){
        // gonna do something one day
    }

    public void showDeck(){
        for (int i = 0; i < this.cards.size(); i++){
            System.out.println(this.cards.get(i).suit + " of " + this.cards.get(i).value);
        }
    }

    public  void initDeck(){
        
        String[] values = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        for(String value : values){
            cards.add(new Card(value, "Spades"));
            cards.add(new Card(value, "Clubs"));
            cards.add(new Card(value, "Diamonds"));
            cards.add(new Card(value, "Hearts"));
        }
        Collections.shuffle(cards);
    }
}




// public class Deck{

//     // Data Members
//     ArrayList<Card> cards = new ArrayList<>();
// 	private int cardsInDeck; // the current number of cards in the deck
// 	public static final int DECK_SIZE = 52; 


//     public Deck(){

//         String[] values = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
//         for(String value : values){
//             cards.add(new Card(value, "Spades"));
//             cards.add(new Card(value, "Clubs"));
//             cards.add(new Card(value, "Diamonds"));
//             cards.add(new Card(value, "Hearts"));
//         }

//     }
//     public void showDeck(){
//         for (Card card: this.cards){
//             card.showCard();
//         }
//     }

//     public void shaffleDeck(){
//         Collections.shuffle(this.cards);
//     }

//     public void resetDeck(){
//         cardsInDeck = DECK_SIZE;
        
//     }


//     public Card deal() {

// 		return this.cards.
// 	}

// }