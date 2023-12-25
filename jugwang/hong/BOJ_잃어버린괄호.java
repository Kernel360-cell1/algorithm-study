package jugwang.hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 부호 기준으로 나눈다.
        StringTokenizer tokenizer = new StringTokenizer(input, "+-", true);
        int tokenCount = tokenizer.countTokens();

        String[] array = new String[tokenCount];
        int index = 0;

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            try {
                int number = Integer.parseInt(token);
                array[index++] = Integer.toString(number);
            } catch (NumberFormatException ex) {
                array[index++] = token;
            }
        }


        int result = 0;
        boolean isAddition = true;
        for (String value : array) {
            if (value.equals("-")) {
                isAddition = false;
            } else if (value.equals("+")) {
                // 부호가 + 인데 isAddition 이 false 면 false 유지
                if (!isAddition) {
                    isAddition = false;
                }
            } else {
                int number = Integer.parseInt(value);
                if (isAddition) {
                    result += number;
                } else {
                    result -= number;
                }
            }
        }


        System.out.println(result);

    }
}
