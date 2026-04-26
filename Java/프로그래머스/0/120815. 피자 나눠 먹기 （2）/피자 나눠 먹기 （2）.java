class Solution {
    public int solution(int n) {
        int answer = 0;
        while (true) {
            answer++;
            if (6 * answer % n == 0) {
                break;
            }
        }
        return answer;
    }
}