package org.example;

import java.util.*;

public class Operations {

    public static String BuildString(TreeMap<Integer, Integer> result){
        StringBuilder sb = new StringBuilder();
        boolean isFirstTerm = true;
        for (Map.Entry<Integer, Integer> term : result.entrySet()) {
            int power = term.getKey();
            int coefficient = term.getValue();
            if (coefficient != 0) {
                if (!isFirstTerm) {
                    sb.append(coefficient > 0 ? " + " : " - ");
                } else if (coefficient < 0) {
                    sb.append("-");
                }
                coefficient = Math.abs(coefficient);
                if (power == 0 || coefficient != 1) {
                    sb.append(coefficient);
                }
                if (power > 0) {
                    sb.append("x");
                }
                if (power > 1) {
                    sb.append("^").append(power);
                }
                isFirstTerm = false;
            }
        }
        if (isFirstTerm) {
            return "0";
        } else {
            return sb.toString();
        }
    }

    public static String BuildString1(TreeMap<Integer, Double> result){
        StringBuilder sb = new StringBuilder();
        boolean isFirstTerm = true;
        for (Map.Entry<Integer, Double> term : result.entrySet()) {
            int power = term.getKey();
            Double coefficient = term.getValue();
            if (coefficient != 0) {
                if (!isFirstTerm) {
                    sb.append(coefficient > 0 ? " + " : " - ");
                } else if (coefficient < 0) {
                    sb.append("-");
                }
                coefficient = Math.abs(coefficient);
                if (power == 0 || coefficient != 1) {
                    sb.append(coefficient);
                }
                if (power > 0) {
                    sb.append("x");
                }
                if (power > 1) {
                    sb.append("^").append(power);
                }
                isFirstTerm = false;
            }
        }
        sb.append("+C");
        if (isFirstTerm) {
            return "0";
        } else {
            return sb.toString();
        }
    }
    public static String addPolynomials(TreeMap<Integer, Integer> poly1, TreeMap<Integer, Integer> poly2) {

        TreeMap<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
        Set<Integer> keys = new TreeSet<>(poly1.keySet());
        keys.addAll(poly2.keySet());

        for (Integer key : keys) {
            int coef1 = poly1.getOrDefault(key, 0);
            int coef2 = poly2.getOrDefault(key, 0);
            int sum = coef1 + coef2;
            if (sum != 0) {
                result.put(key, sum);
            }
        }

        String finalresult=BuildString(result);
        return finalresult;
    }

    public static String subPolynomials(TreeMap<Integer, Integer> poly1, TreeMap<Integer, Integer> poly2) {
        TreeMap<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
        Set<Integer> keys = new TreeSet<>(poly1.keySet());
        keys.addAll(poly2.keySet());

        for (Integer key : keys) {
            int coef1 = poly1.getOrDefault(key, 0);
            int coef2 = poly2.getOrDefault(key, 0);
            int sub = coef1 - coef2;
            if (sub != 0) {
                result.put(key, sub);
            }
        }

        String finalresult = BuildString(result);
        return finalresult;
    }

    public static String divPolynomials(TreeMap<Integer, Integer> dividend, TreeMap<Integer, Integer> divisor) {
        if (dividend.isEmpty()) {
            return "Error: dividend is empty";
        } else if (divisor.isEmpty()) {
            return "Error: divisor is empty";
        } else {
            TreeMap<Integer, Integer> quotient = new TreeMap<>(java.util.Collections.reverseOrder());
            TreeMap<Integer, Integer> remainder = new TreeMap<>(java.util.Collections.reverseOrder());
            TreeMap<Integer, Integer> tempDividend = new TreeMap<>(dividend);
            int dividendDegree = tempDividend.firstKey();
            int divisorDegree = divisor.firstKey();
            while (dividendDegree >= divisorDegree) {
                int quotientDegree = dividendDegree - divisorDegree;
                int quotientCoefficient = tempDividend.get(dividendDegree) / divisor.get(divisorDegree);
                quotient.put(quotientDegree, quotientCoefficient);
                for (Integer key : divisor.keySet()) {
                    int degree = quotientDegree + key;
                    int coefficient = quotientCoefficient * divisor.get(key);
                    tempDividend.merge(degree, -coefficient, Integer::sum);
                }
                tempDividend.remove(dividendDegree);
                dividendDegree = tempDividend.isEmpty() ? -1 : tempDividend.firstKey();
            }
            remainder = tempDividend;
            System.out.println(BuildString(remainder));
            return "Quotient: " + BuildString(quotient) + ", Remainder: " + BuildString(remainder);
        }
    }
    public static String mulPolynomials(TreeMap<Integer, Integer> poly1, TreeMap<Integer, Integer> poly2){
        TreeMap<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
        Set<Integer> keys1=new TreeSet<>(poly1.keySet());
        Set<Integer> keys2=new TreeSet<>(poly2.keySet());
        for(Integer key1:keys1)
            for(Integer key2:keys2) {
                int coef1 = poly1.getOrDefault(key1, 0);
                int coef2 = poly2.getOrDefault(key2, 0);
                result.merge(key1+key2,coef1*coef2,Integer::sum);
            }


        String finalresult = BuildString(result);
        return finalresult;
    }

    public static String derPolynomials(TreeMap<Integer, Integer> poly1){
        TreeMap<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
        Set<Integer> keys1=new TreeSet<>(poly1.keySet());
        for(Integer key1:keys1){
            int coef=poly1.get(key1);
            result.merge(key1-1,coef*key1, Integer::sum);
        }

        String finalresult = BuildString(result);
        return finalresult;
    }

    public static String intPolynomials(TreeMap<Integer, Integer> poly1){
        TreeMap<Integer, Double> result = new TreeMap<>(Collections.reverseOrder());
        Set<Integer> keys1=new TreeSet<>(poly1.keySet());
        for(Integer key1:keys1){
            Double coef=(double) poly1.get(key1);
            if(key1!=0)
                result.merge(key1+1,(double)coef/(key1+1), Double::sum);
            else
                result.merge(key1+1,(double)coef,Double::sum);
        }

        String finalresult = BuildString1(result);
        return finalresult;
    }
}


