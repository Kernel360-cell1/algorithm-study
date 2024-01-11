package yejin.song;
import java.util.HashSet;

public class PGS_폰켓몬 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums){
            hs.add(num);
        }

        if (nums.length/2 < hs.size()) return nums.length/2;

        return hs.size();
    }
}
