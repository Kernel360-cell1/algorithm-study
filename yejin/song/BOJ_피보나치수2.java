package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_피보나치수2 {

    static Long[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new Long[N+1];
        arr[0]=0L;
        arr[1]=1L;
        System.out.println(Fib(N));
    }

    public static Long Fib(int N){
        if(arr[N]==null){
            return arr[N] = Fib(N-1)+Fib(N-2);
        }
        return arr[N];
    }
}
