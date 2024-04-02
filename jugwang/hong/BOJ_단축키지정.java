package jugwang.hong;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_단축키지정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new ArrayList();

        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        // 단축키 지정
        for(int i=0; i<N; i++){
            String[] temp = input[i].split(" ");
            int idx = 0;
            for(int j=0; j<temp.length; j++){ // 첫문자 확인
                char fir = temp[j].charAt(0);
                if(!list.contains(Character.toUpperCase(fir))){
                    list.add(Character.toUpperCase(fir));
                    input[i] = insertS(input[i], idx);
                    visited[i] = true;
                    break;
                }
                idx += temp[j].length() + 1;
            }
            if(!visited[i]){ // 첫문자가 전부 중복이면 진행
                for (int j = 1; j < input[i].length(); j++) { // 왼쪽부터 확인하기
                    char t = input[i].charAt(j);
                    if (t == ' ') {
                        continue;
                    } else if (!list.contains(Character.toUpperCase(t))) {
                        list.add(Character.toUpperCase(t));
                        input[i] = insertS(input[i], j);
                        break;
                    }
                }
            }
        }
        // 출력
        for (int i = 0; i < N; i++) {
            System.out.println(input[i]);
        }
    }

    // 괄호 삽입 함수
    public static String insertS(String s, int idx){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,idx));
        sb.append("[");
        sb.append(s.charAt(idx));
        sb.append("]");
        sb.append(s.substring(idx+1));
        return sb.toString();
    }
}
