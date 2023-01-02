package OOPs.MathematicalConcepts;

public class ComplexNumber_Driver {
    public static void main(String[] args) {
        ComplexNumber cn = new ComplexNumber(1, 3);
        // cn.PrintComplexNumber(cn);

        ComplexNumber cn1 = new ComplexNumber(1, 3);
        ComplexNumber cn2 = new ComplexNumber(1, 2);
        // System.out.println(ComplexNumber.AddComplexNumbers(cn1, cn2));
        System.out.println(ComplexNumber.MultiplyComplexNumbers(cn1, cn2));
    }
}
