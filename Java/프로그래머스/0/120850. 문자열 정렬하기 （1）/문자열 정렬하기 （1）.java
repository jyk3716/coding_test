import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        // 영어 소문자 제거 -> 숫자만 남은 배열 생성
        String[] arr = my_string.replaceAll("[a-z]", "").split("");
        // 숫자 배열 길이의 정답 배열 생성
        int[] answer = new int[arr.length];
        // 숫자로 변환 및 정답 배열 삽입
        for (int i = 0; i < arr.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }
        // 오름차순 정렬
        Arrays.sort(answer);
        return answer;
    }
}