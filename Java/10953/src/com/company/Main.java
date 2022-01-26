package com.company;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(bf.readLine());
	    for (int i = 0; i < n; i ++) {
            String number = bf.readLine();
            String spt[] = number.split(",");
            System.out.println(Integer.parseInt(spt[0])+Integer.parseInt(spt[1]));
        }
    }
}
