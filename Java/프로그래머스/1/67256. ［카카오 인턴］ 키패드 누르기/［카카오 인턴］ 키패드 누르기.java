import java.util.List;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 좌표 저장
        // pos[숫자] = {행, 열}
        int[][] pos = {
            {1, 3}, // 0의 위치
            {0, 0}, // 1의 위치
            {1, 0}, // 2의 위치
            {2, 0}, // 3의 위치
            {0, 1}, // 4
            {1, 1}, // 5
            {2, 1}, // 6
            {0, 2}, // 7
            {1, 2}, // 8
            {2, 2}, // 9
            {0, 3}, // * (왼손 시작점)
            {2, 3}  // # (오른손 시작점)
        };
        // 각 손의 위치 초기화
        int[] left = pos[10];
        int[] right = pos[11];
        // 눌러야 할 번호 순회
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                answer += "L";
                left = pos[n];
                continue;
            }
            if (n == 3 || n == 6 || n == 9) {
                answer += "R";
                right = pos[n];
                continue;
            }
            int ldist = 
                Math.abs(left[0]-pos[n][0]) 
                + Math.abs(left[1]-pos[n][1]);
            int rdist = 
                Math.abs(right[0]-pos[n][0]) 
                + Math.abs(right[1]-pos[n][1]);
            if (ldist == rdist) {
                if (hand.equals("right")) {
                    answer += "R";
                    right = pos[n];
                } else {
                    answer += "L";
                    left = pos[n];
                }
            } else if (ldist > rdist) {
                answer += "R";
                right = pos[n];
            } else if (ldist < rdist) {
                answer += "L";
                left = pos[n];
            }
        }
        return answer;
    }
}