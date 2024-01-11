package jongchan.lee;

public class PGS_점프와_순간이동 {
    public int solution(int n) {
        int ans = 0;
        while(n!=0){
            while (n%2==0) n/=2;
            if(n>=1){
                --n;
                ++ans;
            }
        }

        return ans;
    }
}
