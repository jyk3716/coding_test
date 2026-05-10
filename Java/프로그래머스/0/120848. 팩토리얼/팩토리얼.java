class Solution {
    public int solution(int n) {
        int answer = 1;
        int fact = 1;
        while (fact * (answer + 1) <= n) {
            answer++;
            fact *= answer;
        }
        return answer;
    }
}