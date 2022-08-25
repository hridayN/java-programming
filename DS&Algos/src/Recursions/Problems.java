package Recursions;

public class Problems {
    public static void main(String[] args) {
        ShiftAllXToEndRecursive(new StringBuilder("xxx"));
        //ShiftAllXToEndIterative(new StringBuilder("xxhyxz"));
   }

    public static void ShiftAllXToEndRecursive(StringBuilder str) {
        // Create a temp String containing the str value without x
        String stringWithoutX = String.valueOf(str);
        stringWithoutX = stringWithoutX.replaceAll("x", "");

        int xIndex = str.indexOf("x");

        /*Base case: if we're comparing x's index in str with stringWithoutX,
        that means all our xs are already at the end, hence we can end the function
        */
        if (xIndex == stringWithoutX.length()) {
            System.out.print(str);
            return;
        }

        // Delete x from index i and append at end
        if (xIndex != -1) {
            str.delete(xIndex, xIndex+1);
            str.append('x');
        }

        ShiftAllXToEndRecursive(str);
    }

    public static void ShiftAllXToEndIterative(StringBuilder str) {
        System.out.println(String.format("str: %s", str));
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(0) == 'x') {
                str.delete(0, i+1);
                str.append('x');
            }
        }

        System.out.println(String.format("str: %s", str));
    }
}
