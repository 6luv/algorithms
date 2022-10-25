package com.company;

import java.io.*;
import java.util.*;

public class Main {

    private static int lowerBound(List num, int target, int size) {
        int mid, start, end;
        start = 0;
        end = size - 1;
        while (end > start) {
            mid = (start + end) / 2;
            if (Integer.parseInt(num.get(mid).toString()) >= target)
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<Integer>(list);
        List<Integer> num = new ArrayList<Integer>(set);
        Collections.sort(num);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i ++) {
            sb.append(lowerBound(num, list.get(i), num.size()));
            sb.append(" ");
        }
        String res = sb.toString();
        System.out.println(res);
    }
}
