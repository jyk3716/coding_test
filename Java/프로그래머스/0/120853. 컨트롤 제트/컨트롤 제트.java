import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split(" "); // 문자열을 배열에 담기
        // 뒤부터 순회하며 Z가 나오면 한 칸 건너뛰고 더함
        for (int i=arr.length-1; i>=0; i--) {
            if (arr[i].equals("Z")) {
                i -= 1;
                continue;
            }
            answer += Integer.parseInt(arr[i]);
        }
        return answer;
    }
}