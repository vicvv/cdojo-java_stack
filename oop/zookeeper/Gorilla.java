class Gorilla extends Mammal{
    private boolean throwSomething(){
        Mammal.super.energyLevel -= 5;
        return true;
    }
}