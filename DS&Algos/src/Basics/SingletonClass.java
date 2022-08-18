package Basics;

public class SingletonClass {
    //instance of SingletonClass
    static SingletonClass instance = null;
    public int x = 10;

    // return the instantiated instance whenever an instance is requested
    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}
