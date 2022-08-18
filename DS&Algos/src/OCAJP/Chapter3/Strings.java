package OCAJP.Chapter3;

public class Strings {
    public static void main(String[] args) {
        //ImmutableString();
        //Equals1();
        //ImmutableString2();
        //StringBuilder2();
        //StringBuilderSizeAndCapacity();
        //StringBuilderInsert();
        //ImmutableString3();
        DoubleEqualsVsEquals();
    }
    public static void ImmutableString() {
        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3"); // Since strings are immutable, we are trying to append(increase) the existing string, which isn't possible
        System.out.println(s2);
    }

    public static void ImmutableString2() {
        String s1 = "abc";
        String s2 = s1.concat("de");     // here, value of s1 will not be changed
        s2 = s1.concat("f").concat("g");
        System.out.println("builder1: " + s1);
        System.out.println("builder2: " + s2);
    }

    public static void ImmutableString3() {
        String s1 = "Hello";
        String s2 = " Hello".trim();    // since both strings are same at runtime and not at compile time, java creates 2 separate string objects for each
        System.out.println(s1 == s2);
        System.out.println("s1: " + "'" + s1 + "'");
        System.out.println("s2: " + "'" + s2 + "'");
    }

    public static void DoubleEqualsVsEquals() {
        String s1 = "Hello";
        String s2 = " Hello".trim();
        System.out.println(s1 == s2);   // == checks the object equality
        System.out.println(s1.equals(s2));   // .equals checks the logical equality
    }

    public static void Equals1() {
        String s1 = "abc";
        String s2 = "ABC";
        System.out.println(s1.equals(s2));  // false (equals checks case and order of chars)
        System.out.println(s1 == s2);  // false (equals checks case and order of chars)
    }

    public static void StringBuilderCreation() {
        // Method 1: Create an empty sequence of characters
        StringBuilder sb1 = new StringBuilder();

        // Method 2: Create the well defined sequence of chars
        StringBuilder sb2 = new StringBuilder("string");

        // Method 3: Create a sequence with the expected capacity of the sequence
        StringBuilder sb3 = new StringBuilder(10);
    }

    public static void StringBuilderSizeAndCapacity() {
        StringBuilder sb1 = new StringBuilder(10);

        System.out.println("Length: " + sb1.length());
        System.out.println("Capacity: " + sb1.capacity());

        sb1.append("first");
        // here, Java will automatically increase the capacity by the value provided by us(or default: 16)
        System.out.println("Length: " + sb1.length());
        System.out.println("Capacity: " + sb1.capacity());
    }

    public static void StringBuilder1() {
        StringBuilder builder = new StringBuilder("Start");
        builder.append("+middle");
        System.out.println(builder);

        StringBuilder builder2 = builder.append("+end");
        System.out.println(builder);
    }

    public static void StringBuilder2() {
        StringBuilder builder1 = new StringBuilder("abc");
        StringBuilder builder2 = builder1.append("de");     // here, both objects points to same StringBuilder. Any change in builder2 will also reflect in builder1 and vice a versa
        builder1 = builder1.append("f").append("g");
        System.out.println("builder1: " + builder1);
        System.out.println("builder2: " + builder2);
    }

    public static void StringBuilderInsert() {
        // offset is the prior index to insert new char/string at
        StringBuilder sb1 = new StringBuilder("first");
        System.out.println("charAt(5)" + sb1.charAt(5));
        sb1.insert(5, "second");    // offset 5 means: insert at index prior to 5, i.e., after 4
        System.out.println(sb1);
    }

    public static void susbstrings() {

    }
}


