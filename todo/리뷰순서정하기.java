package todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 리뷰순서정하기 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> members = new ArrayList<>(Arrays.asList("윤선", "주광", "예진", "병룡", "민협"));
        Collections.shuffle(members);
        for (int i=0; i<members.size(); i++) {
            if (i==0)
                sb.append(members.get(i)+ " ←─┐ \n").append(" ↓    │ \n");
            else if (i== members.size()-1)
                sb.append(members.get(i)+ "  ─┘ \n");
            else
                sb.append(members.get(i)+"   │ \n").append(" ↓    │ \n");
        }
        System.out.println(sb);
    }
}
