package jongchan.lee;

class PGS_예상_대진표 {
    public int solution(int n, int a, int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int answer = 1;
        
        while(true){
            if(min%2==1 && max-min==1) break;
            min = min % 2 == 1 ? (min + 1) / 2 : min / 2;
            max = max % 2 == 1 ? (max + 1) / 2 : max / 2;
            ++answer;
        }
        return answer;
    }
}
