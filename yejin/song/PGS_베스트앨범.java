package yejin.song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PGS_베스트앨범 {

    public static void main(String[] args){
    }

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String,Integer> genres_count = new HashMap<>();
        HashMap<String,HashMap<Integer,Integer>> music_count= new HashMap<>();

        for(int i = 0; i<plays.length; i++){
            if(!genres_count.containsKey(genres[i])){
                HashMap<Integer,Integer> hm = new HashMap<>();
                hm.put(i,plays[i]);
                music_count.put(genres[i],hm);
                genres_count.put(genres[i],plays[i]);
            }
            else {
                music_count.get(genres[i]).put(i,plays[i]);
                genres_count.put(genres[i], genres_count.get(genres[i])+plays[i]);
            }
        }

        List<String> keySet = new ArrayList(genres_count.keySet());
        Collections.sort(keySet, (s1, s2) -> genres_count.get(s2) - (genres_count.get(s1)));

        for(String key : keySet) {
            HashMap<Integer, Integer> map = music_count.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());

            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));

            answer.add(genre_key.get(0));
            if(genre_key.size() > 1)
                answer.add(genre_key.get(1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
