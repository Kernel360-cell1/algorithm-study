package yoonseon.lee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_단축키지정 {
    static int N;
    static List<Character> shortcutKeys;
    static StringBuilder sb;
    static final Character noneShortcutKey = '@';
    static final int noneIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        shortcutKeys = new ArrayList<>();

        for (int i=0; i<N; i++) {
            String text = br.readLine();
            String[] strArr = text.split(" ");
            boolean isShortcutKey = false;

            for (int j = 0; j < strArr.length; j++) { // 입력받은 문자열을 공백 기준으로 순차적으로 순회
                String firstText = strArr[j];
                Character shortcutKey = firstText.charAt(0);
                if (!isExistShortcutKey(shortcutKey)) {
                    applyShortcut(shortcutKey);
                    int index = strArr.length > 1 ? j : noneIndex; // 공백이 포함된 문자열이였을 경우 단축키가 걸린 인덱스, 아니면 0
                    writeAnswer(shortcutKey, text, index);
                    isShortcutKey = true;
                    break;
                }

            }

            if (!isShortcutKey) { // 단어 별 맨 앞자리가 다 단축키로 지정되있으면
                String removeSpaceText = Arrays.stream(strArr).collect(Collectors.joining()); // 공백제거하고 문자열로 만들어서 찾음
                boolean isNoneShortcutKey = false;
                for (char c : removeSpaceText.toCharArray()) {
                    if (!isExistShortcutKey(c)) {
                        applyShortcut(c);
                        writeAnswer(c, text, null);
                        isNoneShortcutKey = true;
                        break;
                    }
                }
                if (!isNoneShortcutKey) {
                    writeAnswer(noneShortcutKey, text, noneIndex);
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean isExistShortcutKey(Character c) {
        char upper = Character.toUpperCase(c);
        return shortcutKeys.contains(upper);
    }

    public static void applyShortcut(Character c) {
        char upper = Character.toUpperCase(c);
        shortcutKeys.add(upper);
    }

    public static void writeAnswer(Character shortcutKey, String text, Integer index) {
        String[] s = text.split(" ");
        boolean isShortcutKeyAlreadyWrite = false;
        for (int i=0; i<s.length; i++) {
            for (Character c : s[i].toCharArray()) {
                if (c == shortcutKey && !isShortcutKeyAlreadyWrite && (index == null || i == index)) {
                    // 단축키로 등록해야하는 문자가 발견됐을 때
                    // 해당 문자열에서 이미 단축키로 등록한 적이 없고
                    // index가 null 이거나 매겨변수로 받은 인덱스가 찾은 배열의 인덱스랑 같을 때
                    // index가 null인 경우는 문자열로 합쳐서 전달 받았을 때.
                    sb.append("[" + c + "]");
                    isShortcutKeyAlreadyWrite = true;
                } else {
                    sb.append(c);
                }
            }
            sb.append(" ");
        }
        sb.append("\n");
    }
}
