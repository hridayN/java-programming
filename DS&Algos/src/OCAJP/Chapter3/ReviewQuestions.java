package OCAJP.Chapter3;

public class ReviewQuestions {
    public static void main(String[] args) {
        // question2();
        // question4();
        // question8();
        // question9();
        question12();
    }

    public static void question2() {
        String s = "Hello";
        String t = new String(s);
        if ("Hello".equals(s)) System.out.println("one");
        if (t == s) System.out.println("two");
        if (t.equals(s)) System.out.println("three");
        if ("Hello" == s) System.out.println("four");
        if ("Hello" == t) System.out.println("five");
        System.out.println("t: " + t);
    }

    public static void question4() {
        StringBuilder sb = new StringBuilder();
        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println(sb);
    }

    public static void question5() {
        String s1 = "java";
        StringBuilder s2 = new StringBuilder("java");
        /*if (s1 == s2)
            System.out.print("1");*/
        if (s1.equals(s2))
            System.out.print("2");
    }

    public static void question6() {
        String s1 = "roar";
        s1 += false;
        StringBuilder s2 = new StringBuilder("roar");
    }

    public static void question8() {
        String numbers = "012345678";
        System.out.println(numbers.substring(1, 3));
        System.out.println("substring(7, 7): " + numbers.substring(7, 7));
        System.out.println("substring(7, 6): " + numbers.substring(7, 6));
        System.out.println(numbers.substring(7));
    }

    public static void question9() {
        String a = "";
        a += 2;
        a += 'c';
        a += false;
        if ( a == "2cfalse") System.out.println("==");
        if ( a.equals("2cfalse")) System.out.println("equals");
    }

    public static void question12() {
        StringBuilder numbers = new StringBuilder("0123456789");
        numbers.delete(2, 8);
        numbers.append("-").insert(2, "+");
        System.out.println(numbers);
    }
}

class Lion {
    public static void roar(String roar1, StringBuilder roar2) {
        roar1.concat("!!!");
        roar2.append("!!!");
    }
}
