class Solution {
    public String solution(int age) {
        String answer = "";
        String strAge = Integer.toString(age);
        int a = 0;
        for (int i = 0; i < strAge.length(); i++) {
            a = strAge.charAt(i) - '0';
            a += 'a';
            answer += (char) a;
        }
        return answer;
    }
}