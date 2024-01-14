package yejin.song;

import java.io.*;
import java.util.HashMap;

public class BOJ_절댓값힙_fail {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int min = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i = 0 ; i < n; i++){

            int x = Integer.parseInt(br.readLine());
            if (i == 0) {
                min = Math.abs(x);
            }

            System.out.println("x = " +  x );

            if (x == 0){
                if(hs.isEmpty()) System.out.println(0);
                else{
                    // 음수 인지 양수인지 확인해서 키 값 찾기
                    int key = search_key(min,hs);
                    System.out.println(key);

                    // 확인한 후 메소드 호출해서 삭제, 최솟값 업데이트
                    delete(min,key,hs);
                }
            }
            else{
                int value = hs.getOrDefault(x,0);
                hs.put(x, value+1);
                update_min(min, hs);
            }

            System.out.println("hs : " + hs);

        }
    }

    public static void delete(int min, int key, HashMap<Integer,Integer> hs){
        hs.put(key, hs.get(key)-1);
        System.out.println(key);

        if (hs.get(key) == 0) {
            hs.remove(key);
            update_min(min, hs);
        }
    }

    public static int update_min(int min, HashMap<Integer,Integer> hs){

        for (int i : hs.keySet()){
            min = Math.min(min, Math.abs(i));
        }

        return min;
    }

    public static int search_key(int min, HashMap<Integer,Integer> hs){
        System.out.println("min : " + min);
        System.out.println("hs: " + hs);

        int key = 0;

        for (int k : hs.keySet()){
            System.out.println("k: " + k);
            if (min == Math.abs(k)){ // 음수 혹은 양수 걸릴 때

                if (k < 0) return k; // 값이 음수면 더 볼 필요 없으니까 return
                key = k; // 양수면 일단 key에 담기
            }

        }
        return key;
    }
}
