package yejin.song;

import java.util.Comparator;
import java.util.PriorityQueue;



public class PGS_이중우선순위큐 {
    public int[] solution(String[] operations){
        int answer[] = {0,0};

        PriorityQueue<Integer> pqmin = new PriorityQueue<>();
        PriorityQueue<Integer> pqmax = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation:operations){
            String split[] = operation.split(" ");

            if (split[0].equals("I")){
                pqmin.add(Integer.parseInt(split[1]));
                pqmax.add(Integer.parseInt(split[1]));
            }
            else{
                if(!pqmax.isEmpty()){
                    if (split[1].equals("1")){
                        int max = pqmax.poll();
                        pqmin.remove(max);
                    }
                    else{
                        int min = pqmin.poll();
                        pqmax.remove(min);
                    }
                }
            }
        }

        if (pqmin.isEmpty()){
            return answer;
        }
        else{
            answer[0]= pqmax.peek();
            answer[1]= pqmin.peek();
        }
        return answer;
    }
}


