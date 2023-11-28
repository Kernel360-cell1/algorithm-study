package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_개미 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int currentX = (t+p) % (2*w);
        int currentY = (t+q) % (2*h);

        if (currentX > w) currentX = 2*w - currentX;
        if (currentY > h) currentY = 2*h - currentY;

        System.out.println(currentX+" "+currentY);

    }

}
