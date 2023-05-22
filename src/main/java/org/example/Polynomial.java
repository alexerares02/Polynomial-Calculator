package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private TreeMap<Integer, Integer> polinom=new TreeMap<>(Collections.reverseOrder());

    public String findElements(String expression) {//regexul functioneaza doar daca introduci x sau X altfel da eroare


        //String pattern = "([-+]?\\d*)x\\^(\\d*)";
        if (!expression.matches(".*[xX]\\^*\\d*.*")) {
            return "Invalid input";
        }


        Pattern pattern = Pattern.compile("([+-]?\\d*)[xX]\\^(\\d+)|([+-]?\\d*)[xX]|([+-]?\\d+)");//la coeficient negativ daca e doar -1 atunci trebuie specificat

        Matcher matcher = pattern.matcher(expression);


        while (matcher.find()) {
            Integer coefficient=0;
            Integer exponent=0;

            if (matcher.group(1) != null) {
                String coefStr = matcher.group(1).trim();
                coefficient = coefStr.isEmpty() || coefStr.equals("+") ? 1 : coefStr.equals("-") ? -1 : Integer.parseInt(coefStr);
                exponent = Integer.parseInt(matcher.group(2));
            } else if (matcher.group(3) != null) {
                String coefStr = matcher.group(3).trim();
                coefficient = coefStr.isEmpty() || coefStr.equals("+") ? 1 : coefStr.equals("-") ? -1 : Integer.parseInt(coefStr);
                exponent = 1;
            } else if (matcher.group(4) != null) {
                coefficient = Integer.parseInt(matcher.group(4));
                exponent = 0;
            }


            this.polinom.merge(exponent,coefficient,Integer::sum);


            //System.out.println("Coefficient: " + coefficient);
            //System.out.println("Exponent: " + exponent);
        }
        //System.out.println(polinom);
        return "";

    }
    public TreeMap<Integer, Integer> getPolinom(){
        return this.polinom;
    }

}

