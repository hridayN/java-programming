package OOPs.MathematicalConcepts;

public class ComplexNumber {
    private int real;

    private int imaginary;

    private String complexNumber;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        this.complexNumber = real + " + i" + imaginary;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public String getComplexNumber() {
        return complexNumber;
    }

    public void setComplexNumber(String complexNumber) {
        this.complexNumber = complexNumber;
    }

    public void PrintComplexNumber(ComplexNumber cn) {
        System.out.println(String.format("%d + i%d", cn.real, cn.imaginary));
    }

    public static ComplexNumber AddComplexNumbers(ComplexNumber cn1, ComplexNumber cn2) {
        ComplexNumber cn = new ComplexNumber(0, 0);
        int real = cn1.real + cn2.real;
        int imaginary = cn1.imaginary + cn2.imaginary;
        cn.real = real;
        cn.imaginary = imaginary;
        return cn;
    }

    public static ComplexNumber MultiplyComplexNumbers(ComplexNumber cn1, ComplexNumber cn2) {
        ComplexNumber cn = new ComplexNumber(0, 0);
        int real = (cn1.real * cn2.real) + (-1 * cn1.imaginary * cn2.imaginary);  //(cn1.real * cn2.imaginary)
        int imaginary = (cn1.real * cn2.imaginary) + (cn1.imaginary * cn2.real);
        cn.real = real;
        cn.imaginary = imaginary;
        return cn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(real);
        sb.append(" + i");
        sb.append(imaginary);
        return sb.toString();
    }
}
