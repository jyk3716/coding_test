class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        // 향상된 for문과 split("")을 활용해 
        // 한 글자씩 쪼개고 스트링 배열 만듦
        for (String s : my_string.split("")) {
            // repeat() 활용해 각 글자를 n번 반복
            answer += s.repeat(n);
        }
        return answer;
    }
}