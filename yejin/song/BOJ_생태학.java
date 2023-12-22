package yejin.song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        HashMap<String,Integer> hm = new HashMap<>();

        String line = br.readLine();
        // line에 br 담은 후에 line값이 null이 아닌 경우에만 진행
        while (true){
            count++;
            hm.put(line, hm.getOrDefault(line,0)+1);
            line = br.readLine();
            if (line == null || line.length()==0)
                break;
        }


        // 오름차순을 위해 해시맵에 저장된 키값만 뽑아와서 array로 변환 후, 오름차순 정렬을 합니다.
        // Set의 키들이 Object 타입의 배열로 반환되기 때문에 Object에 담는다.
        Object[] hmkey = hm.keySet().toArray();
        Arrays.sort(hmkey);

        // System.out.println(Arrays.toString(hmkey));


        StringBuilder sb = new StringBuilder();

        //hm에서 순서대로 키값 가져와서 비율 구하기. 이 후 소수 4째자리까지 출력
        for (int i = 0; i< hmkey.length; i++){
            int num = hm.get(hmkey[i]);
            double per = (double) (num * 100.0) / count;
            sb.append(hmkey[i] + " " + String.format("%.4f",per)+ "\n");
        }

        System.out.println(sb.toString());
    }


}
