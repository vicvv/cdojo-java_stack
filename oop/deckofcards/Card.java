public class Card {
    public String suit;
    public String value;

    public Card(){}

    public Card(String suit, String value){
        this.suit = suit;
        this.value = value;

    }
    public void showCard(){
        String newLine = System.getProperty("line.separator");
        System.out.print(this.suit + " " + this.value + newLine);
    }
}