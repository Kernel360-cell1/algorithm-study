package minhyeop.kim;

public class PGS_하노이의탑 {
    private int index = 0; // 원판이동배열 저장용 index
    public int[][] solution(int n) {
        int[][] result = new int[(int)Math.pow(2, n) - 1][2];
        move(n,1, 2, 3, result);
        return result;
    }

    public void move(int n, int start, int mid, int end, int[][] result){
        if(n == 1) // 1번에 원판 1개, 2번에 원판 0개 남은 경우
            result[index++] = new int[] {start, end};
        else{
            move(n-1, start, end, mid, result); //가장 큰 원판 제외하고 2번으로 이동
            result[index++] = new int[] {start, end}; //가장 큰 원판 1번에서 3번으로 이동
            move(n-1, mid, start, end, result); //n-1 반복하기 위해 호출
        }
    }
}