package minhyeop.kim;

import java.util.*;

class PGS_여행경로 {
    String[] answer;
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            answer[i] = "ZZZ";
        }

        ArrayList<String[]> arr = new ArrayList<>();
        Collections.addAll(arr, tickets);

        ArrayList<String> gone = new ArrayList<>();
        gone.add("ICN");

        compute(gone, "ICN", arr);

        return answer;
    }

    private void compute(ArrayList<String> gone, String now, ArrayList<String[]> tickets) {
        if(tickets.isEmpty()) {
            for (int i = 0; i < answer.length; i++) {
                if (!gone.get(i).equals(answer[i])) {
                    if (gone.get(i).compareTo(answer[i]) < 0) {
                        answer = gone.toArray(new String[0]);
                    }
                    return;
                }
            }
            return;
        }

        for (String[] ticket : tickets) {
            if (ticket[0].equals(now)) {
                ArrayList<String> nextGone = new ArrayList<>(gone);
                ArrayList<String[]> nextTickets = new ArrayList<>(tickets);
                nextGone.add(ticket[1]);
                nextTickets.remove(ticket);
                compute(nextGone, ticket[1], nextTickets);
            }
        }
    }
}