package com.company;

import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


    private static int isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return 1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> mapIndex = new HashMap(n, 0.8f);
        Map<String, Integer> mapName = new HashMap(n, 0.8f);
        for (int i = 0; i < n; i ++) {
            String word = br.readLine();
            mapIndex.put(i+1, word);
            mapName.put(word, i+1);
        }

        for (int i = 0; i < m; i ++) {
            String word = br.readLine();
            if (isNumeric(word) == 1) { //value = 숫자, key = 문자열
                System.out.println(mapIndex.get(Integer.parseInt(word)));
            } else {
                System.out.println(mapName.get(word));
            }
        }
    }
}
