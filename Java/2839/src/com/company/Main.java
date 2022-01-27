package com.company;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(bf.readLine());
	    int cnt = 0;
	    while (true) {
            if (n % 5 == 0) { //5의 배수이면
                System.out.println(n / 5 + cnt);
                break;
            }
            if (n < 0) {
                System.out.println("-1");
                break;
            }
            n -= 3;
            cnt++;
        }
    }
}
