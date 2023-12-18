import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length * 5;
        
        List<String> list = Arrays.asList(cities).stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        
        List<String> cache = new ArrayList<>();
        int answer = 0;
        
        for(String city : list){
            if(cache.remove(city)) {
                ++answer;
                cache.add(city);
            }else{
                answer += 5;
                if(cache.size() >= cacheSize) cache.remove(0);
                cache.add(city);
            }
        }
        
        return answer;
    }
}
