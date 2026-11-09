import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int maxR = park.length;
        int maxC = park[0].length();
        // 시작 지점 초기화
        int r = 0, c = 0;
        loop:
        for (int i = 0; i < maxR; i++) {
            for (int j = 0; j < maxC; j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                    break loop;
                }
            }
        }
        // 방향 벡터 사전 정의
        Map<String, int[]> dir = new HashMap<>();
        dir.put("N", new int[]{-1, 0});
        dir.put("S", new int[]{1, 0});
        dir.put("W", new int[]{0, -1});
        dir.put("E", new int[]{0, 1});
        
        // routes 순회하며 split하고 이동
        for (String s : routes) {
            String[] parts = s.split(" ");
            String d = parts[0];
            int dist = Integer.parseInt(parts[1]);
            
            int nr = r;
            int nc = c;
            boolean canMove = true;
            
            // 한 칸씩 이동하며 범위 및 장애물 검사
            for (int step = 0; step < dist; step++) {
                nr += dir.get(d)[0];
                nc += dir.get(d)[1];
                if (nr < 0 || nr >= maxR || nc < 0 || nc >= maxC 
                    || park[nr].charAt(nc) == 'X') {
                    canMove = false;
                    break;
                }
            }
            if (canMove) {
                r = nr;
                c = nc;
            }
        }
        int[] answer = {r, c};
        return answer;
    }
}