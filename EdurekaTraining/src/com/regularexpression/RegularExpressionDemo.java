package com.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemo {
    public static void main(String[] args) {
        smallLettersWord();
    }

    public static void smallLettersWord() {
        /*
        [a-z]+ =>
        [a-z]: any one letter from a to z should be present in the sequence
        +: it can occur one or more time
        */
        String pattern = "[a-z]+";
        String input = "Check regular expressions"; /* C will not be considered as favourable, being an uppercase alphabet*/
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(input);
        while(matcher.find()){
            System.out.println(input.substring(matcher.start(), matcher.end()));
        }
    }
}
