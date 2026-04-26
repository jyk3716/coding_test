class Solution {
    public String solution(String my_string) {
        // charAt 메소드 사용하기
        // 성능 8.44 ~ 11.36ms
        // String answer = "";
        // for (int i = my_string.length() - 1; i >= 0; i--) {
        //     answer += my_string.charAt(i);
        // }
        
        // StringBuffer / reverse 메소드 사용하기
        // 성능 0.06 ~ 0.08ms
        StringBuffer sb = new StringBuffer(my_string);        
        String answer = sb.reverse().toString();
        return answer;
    }
}