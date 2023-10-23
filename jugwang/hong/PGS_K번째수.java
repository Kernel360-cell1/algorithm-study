package jugwang.hong;

import java.util.Arrays;

public class PGS_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        //커맨드 들어온 만큼 배열
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            //커맨드 배열 가져옴
            int[] command = commands[i];

            //각 요소 변수에 저장
            int start = command[0] - 1;
            int end = command[1];
            int k = command[2];

            //숫자 자르기 - #1 첫풀이
            int[] sliceArray = new int[end - start];
            for (int j = start; j < end; j++) {
                sliceArray[j - start] = array[j];
            }

            //숫자 자르기 - #2 제공하는 함수 이용 풀이
            //int[] sliceArray = Arrays.copyOfRange(array, start, end);

            //sliceArray 정렬
            Arrays.sort(sliceArray);

            //k번째 숫자를 answer에 저장
            answer[i] = sliceArray[k-1];
        }

        return answer;
    }
}
