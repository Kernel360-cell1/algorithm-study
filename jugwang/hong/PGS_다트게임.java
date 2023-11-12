package jugwang;

public class PGS_다트게임 {
    public int solution(String dartResult) {
        // 라운드당 점수
        int[] roundScore = new int[3];
        // 배열로 변환
        char[] arr = dartResult.toCharArray();
        // roundScore 인덱스
        int idx = -1;
        
        for (int i = 0; i < arr.length; i++) {
            // 숫자인 경우
            
            // 그 중 '10' 인 경우
            if (arr[i] == '1' && arr [i + 1] == '0') {
                idx++;
                roundScore[idx] = 10;
                i++;
                continue;
            } else if (arr[i] >= '0' && arr[i] <='9') {
                idx++;
                // 숫자인 경우 해당 값을 정수로 변환하여 roundScore 배열에 저장
                roundScore[idx] = Integer.parseInt(String.valueOf(arr[i]));
                continue;
            }
            
            // 문자인 경우
            switch (arr[i]) {
                case 'D' :
                    roundScore[idx] = (int) Math.pow(roundScore[idx], 2);
                    break;
                case 'T' :
                    roundScore[idx] = (int) Math.pow(roundScore[idx], 3);
                    break;
                case '*' :
                    // 해당 라운드 2배
                    roundScore[idx] *= 2;
                    // 1 라운드일 경우 이전 라운드에 2배 못하니 체크 하는 부분
                    if (idx - 1 >= 0) {
                        roundScore[idx - 1] *= 2;
                    }
                    break;
                case '#' :
                    // 해당 라운드 음수
                    roundScore[idx] *= -1;
            }
        }
        
        // 각 라운드 점수 합
        return roundScore[0] + roundScore[1] + roundScore[2];
        
        
    }
}
