import java.util.*;

class Solution {
    public int solution(String s) { // 20:55~
        int answer = s.length();
        // 1부터 문자열 길이의 절반만큼 for문으로 다 잘라보기
        for (int i = 1; i < s.length() / 2 + 1; i++) { // 자를 단위
            int count = 1;
            String compressed = "";
            String target = s.substring(0, i);
                
            // 비교 대상 정해 비교
            for (int j = i; j <= s.length(); j += i) {
                String compare = 
                    s.substring(j, Math.min(j + i, s.length()));
                // 배열 현재 값과 뒤 값 같으면 카운팅해 앞에 표기
                // 1인 경우 표기하지 않음
                if (target.equals(compare)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed += count;
                        count = 1;
                    }
                    compressed += target;
                    target = compare;
                }
            }
            compressed += target;
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}