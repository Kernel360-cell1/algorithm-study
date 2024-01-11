package yejin.song;

import java.util.Arrays;
import java.util.Comparator;

public class PGS_전화번호목록 {
    public static void main(String args[]){
        System.out.println(solution(new String[]{"12","123","1235","567","88","134"}));
    }
    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
//        Arrays.sort(phone_book, Comparator.comparing(String::length));
//        System.out.println(Arrays.toString(phone_book));
//
//        for (int i = 0; i < phone_book.length; i++){
//
//            for (int j = i+1; j < phone_book.length; j++){
//                if(phone_book[j].startsWith(phone_book[i])) return false;
//            }
//    }
//        return true;
}

