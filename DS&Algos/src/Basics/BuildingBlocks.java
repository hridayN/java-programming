package Basics;

public class BuildingBlocks {

}

class Eggs {
    public Eggs() {
        number = 5;
    }

    public static void main(String[] args) {
        Eggs eggs = new Eggs();
        System.out.print(eggs.number);
    }

    private int number = 3;

    // Executed even  before the constructor
    {
        number = 4;
    } //instance initializer block
}
