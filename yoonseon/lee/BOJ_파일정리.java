package yoonseon.lee;

import java.io.*;
import java.util.*;

public class BOJ_파일정리 {

    static int N;
    static Map<String, Integer> map;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new TreeMap<>();
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String extension = br.readLine().split("\\.")[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}