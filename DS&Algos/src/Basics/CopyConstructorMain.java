package Basics;

public class CopyConstructorMain {
    public static void main(String[] args) {
        // instantiated CopyConstructor class with parameterised constructor
        CopyConstructor c1 = new CopyConstructor(10, 15);

        // Called copy constructor
        CopyConstructor c2 = new CopyConstructor(c1);

        CopyConstructor c3 = c2;
        System.out.println(c2);
    }
}
