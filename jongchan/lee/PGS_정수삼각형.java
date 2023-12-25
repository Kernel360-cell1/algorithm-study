class Solution {
    public int solution(int[][] triangle) {
        if (triangle.length == 1) return triangle[0][0];

        int height = triangle[triangle.length - 1].length - 2;

        while (height >= 0) {
            for (int i = 0; i < triangle[height].length; i++) {
                triangle[height][i] += Math.max(triangle[height + 1][i], triangle[height + 1][i + 1]);
            }
            height--;
        }
        return triangle[0][0];
    }
}
