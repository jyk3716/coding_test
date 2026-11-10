class Solution {
    // 세로 길이는 2로 고정, 가로 길이는 n으로 주어짐
    public int solution(int n) {
        if (n == 1) {
            return 1;
        }
        
        int[] dp = new int[n+1];
        
        // 초기값 설정
        dp[1] = 1; // 너비 1을 채우려면 세로 타일 한 장
        dp[2] = 2; // 너비 2를 채우려면 가로 타일 두 장이나 세로 타일 두 장
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
            
        int answer = dp[n];
        return answer;
    }
}