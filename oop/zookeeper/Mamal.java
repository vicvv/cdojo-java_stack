
public class Mammal{

    // variable
    private Integer energyLevel;
    // constructor
    public Mammal(){
        this.energyLevel = 200;
    }
    
    // method
    public int displayEnegry() {
        System.out.println("My energy level is"  + this.energyLevel);
        return this.energyLevel;
    }    
}


