package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    double sum = 0;
	    String score = input.nextLine();
        String s = score.substring(score.length()-1);
        String c = score.substring(0, 1);
        switch (c) {
            case "A":
                sum += 4.0;
                break;
            case "B":
                sum += 3.0;
                break;
            case "C":
                sum += 2.0;
                break;
            case "D":
                sum += 1.0;
                break;
        }
        if (s.equals("+")) {
            sum += 0.3;
        } else if (s.equals("-")) {
            sum -= 0.3;
        }
        System.out.println(sum);
    }
}
