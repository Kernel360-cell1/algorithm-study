package jugwang.hong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_가장가까운세사람의심리적거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bfr.readLine());
        while (T-- > 0) {
            final int N = Integer.parseInt(bfr.readLine());
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            // 비둘기의 원리
            int people = N > 32 ? 33 : N;
            String[] person = new String[people];
            for (int i = 0; i < people; ++i) person[i] = st.nextToken();
            int minDistance = 12; // 999 해도 상관없다 최대를 12로 잡아 둔 것뿐
            outerLoop : for (int i = 0; i < people; ++i) {
                for (int j = i + 1; j < people; ++j) {
                    for (int k = j + 1; k < people; ++k) {
                        minDistance = Math.min(minDistance, calcDistance(person[i], person[j], person[k]));
                        if (minDistance == 0) {
                            // pass
                            break outerLoop;
                        }
                    }
                }
            }
            System.out.println(minDistance);
        }
    }
    private static int calcDistance(String p1, String p2, String p3) {
        int distance = 0;
        for (int i = 0; i < 4; ++i) {
            distance += (p1.charAt(i) != p2.charAt(i) ? 1 : 0);
            distance += (p2.charAt(i) != p3.charAt(i) ? 1 : 0);
            distance += (p3.charAt(i) != p1.charAt(i) ? 1 : 0);
        }
        return distance;
    }
}