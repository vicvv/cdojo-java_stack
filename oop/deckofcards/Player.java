import java.util.ArrayList;
import java.util.List;

public class Player{
    public String name;
    public Deck deck;
    
    ArrayList<Card> hand = new ArrayList<>();

    public Player(String name, Deck deck){
        this.name = name;
        this.deck = deck;
    }

    public Player takeCard(){
        this.hand.add(this.deck.deal());
        return this;
    }

    public Player discardCard(){
        int rando = (int) ((Math.random() * hand.size()));
        hand.remove(rando);
        return this;
    }

    public Player showHand(){
        for (int i = 0; i < this.hand.size(); i++){
            System.out.println("Cards on hand: "+  this.hand.get(i).value + " " + this.hand.get(i).suit);
        }
        return this;
    }
}