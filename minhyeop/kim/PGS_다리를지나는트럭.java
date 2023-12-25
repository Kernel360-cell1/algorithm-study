package minhyeop.kim;

import java.util.ArrayList;

public class PGS_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        ArrayList<int[]> trucks = new ArrayList<>();
        for (int truckWeight : truck_weights) {
            trucks.add(new int[]{truckWeight, bridge_length - 1});
        }
        ArrayList<int[]> now = new ArrayList<>();

        int answer = 0;

        while (!trucks.isEmpty() || !now.isEmpty()) {
            int sum = 0;
            for (int i = 0; i < now.size(); i++) {
                sum += now.get(i)[0];
                now.get(i)[1]--;
                if (now.get(i)[1] == 0) {
                    now.remove(i--);
                }
            }

            if (!trucks.isEmpty()) {
                if (weight - sum >= trucks.get(0)[0]) {
                    now.add(trucks.get(0));
                    trucks.remove(0);
                }
            }
            answer++;
        }


        return ++answer;
    }
}
