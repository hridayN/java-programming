package Basics;

public class SingletonMain {
    public static void main(String[] args) {
        SingleInstance();
    }

    public static void MultipleInstance() {
        //this will create multiple instances of our SingletonClass
        SingletonClass ss = new SingletonClass();
        ss.x = 15;
        SingletonClass ss2 = new SingletonClass();
        ss2.x = 20;
        System.out.println("ss.x: " + ss.x + ", ss2.x: " + ss2.x);
    }

    public static void SingleInstance() {
        //this will ensure only one instance is created
        SingletonClass ss = SingletonClass.getInstance();
        ss.x = ss.x + 20;

        //this will point to same reference of SingletonClass i.e., ss
        SingletonClass ss2 = SingletonClass.getInstance();

        System.out.println("ss.x: " + ss.x + ", ss2.x: " + ss2.x);
    }
}
