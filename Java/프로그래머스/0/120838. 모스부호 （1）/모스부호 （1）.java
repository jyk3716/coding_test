import java.util.*;

class Solution {
    public String solution(String letter) {
        String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",
            ".-.","...","-","..-","...-",".--","-..-","-.--","--.."
            };
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < morse.length; i++) {
            char alphabet = (char) ('a' + i);
            map.put(morse[i], String.valueOf(alphabet));
        }
        
        StringTokenizer st = new StringTokenizer(letter);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(map.get(st.nextToken()));
        }
        String answer = sb.toString();
        return answer;
    }
}