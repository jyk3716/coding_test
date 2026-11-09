import java.util.List;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 좌표 저장
        // pos[숫자] = {행, 열}
        int[][] pos = {
            {1, 3},         // 0의 위치
            {0, 0}, {1, 0}, {2, 0}, // 1, 2, 3의 위치
            {0, 1}, {1, 1}, {2, 1}, // 4, 5, 6의 위치
            {0, 2}, {1, 2}, {2, 2}, // 7, 8, 9의 위치
            {0, 3}, // * (왼손 시작점)
            {2, 3}  // # (오른손 시작점)
        };
        // 각 손의 위치 초기화
        int[] left = pos[10];
        int[] right = pos[11];
        // 눌러야 할 번호 순회
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                sb.append("L");
                left = pos[n];
            } else if (n == 3 || n == 6 || n == 9) {
                sb.append("R");
                right = pos[n];
            } else {
                int ldist = 
                    Math.abs(left[0]-pos[n][0]) 
                    + Math.abs(left[1]-pos[n][1]);
                int rdist = 
                    Math.abs(right[0]-pos[n][0]) 
                    + Math.abs(right[1]-pos[n][1]);
                if ((ldist > rdist) 
                    || (ldist == rdist && hand.equals("right"))) {
                    sb.append("R");
                    right = pos[n];
                } else {
                    sb.append("L");
                    left = pos[n];
                }
            }
        }
        return sb.toString();
    }
}