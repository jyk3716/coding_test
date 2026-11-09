class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split("");
        for (String s : arr) {
            if (s.matches("[0-9]")) answer += Integer.parseInt(s);
        }
        return answer;
    }
}