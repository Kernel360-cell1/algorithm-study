package jugwang.hong;

public class PGS_JadenCase문자열만들기 {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        String answer = "";
        // 소문자로 바꾸고 한자씩 배열에 저장
        String[] strArr = s.toLowerCase().split("");
        // 대문자 소문자 스위치
        boolean swit = true;

        for(String w : strArr) {
            if(swit == true) {
                sb.append(w.toUpperCase());
                swit = false;
            }
            else if(swit == false){
                sb.append(w);
            }
            //공백 문자를 만나면 스위치
            if(w.equals(" ")) {
                swit = true;
            }
        }
        return answer = sb.toString();
    }
}
