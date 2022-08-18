package Basics;

public class CopyConstructor {
    private double _re, _im;
    public CopyConstructor(double re, double im){
        _re = re;
        _im = im;
    }

    //Copy constructor for class CopyConstructor
    CopyConstructor(CopyConstructor copyConstructor) {
        System.out.println("CopyConstructor called");
        _re = copyConstructor._re;
        _im = copyConstructor._im;
    }

    @Override
    public String toString() {
        return "(" + _re + " + " + _im + ")";
    }
}
