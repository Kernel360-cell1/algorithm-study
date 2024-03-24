package jugwang.hong;

import java.util.Arrays;

public class PGS_도둑질 {
    public int solution(int[] money) {
        if (money.length == 1) return money[0];
        return Math.max(rob(Arrays.copyOfRange(money, 0, money.length - 1)),
                rob(Arrays.copyOfRange(money, 1, money.length)));
    }

    // 주어진 범위의 집들에서 털 수 있는 최대 금액을 계산하는 함수
    private int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
