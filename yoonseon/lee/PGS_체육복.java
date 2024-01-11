package yoonseon.lee;

public class PGS_체육복 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] lost = {2,4};
		int[] reserve = {3};
		System.out.println(s.solution(5, lost, reserve));
	}

	static class Solution {
		int[] wearArr;

		public void initWearArr(int n, int[] arr, boolean isLost) {
			for (int i=0; i<n; i++) {
				if (isLost)
					wearArr[arr[i]-1] = wearArr[arr[i]-1]-1;
				else
					wearArr[arr[i]-1] = wearArr[arr[i]-1]+1;
			}
		}

		public int solution(int n, int[] lost, int[] reserve) {
			int answer = 0;
			wearArr = new int[n];
			initWearArr(lost.length, lost, true);
			initWearArr(reserve.length, reserve, false);

			for (int i=0; i<n; i++) {
				// 순회하면서 잃어버린 사람인 경우 양옆 인덱스 확인 후 증가
				if (wearArr[i] == -1) {
					if (i != 0 && wearArr[i-1] == 1) {
						wearArr[i-1] = 0;
						answer++;
					}
					else if (i != n-1 && wearArr[i+1] == 1) {
						wearArr[i+1] = 0;
						answer++;
					}
				} else {
					answer++;
				}
			}

			return answer;
		}

	}
}
