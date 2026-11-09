import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution { // 캐릭터가 처음 걸어본 길의 길이만 구할 것
    public int solution(String dirs) {
        // 시작점 초기화
        int x = 0;
        int y = 0;
        // 방문 여부 셋
        Set<String> visited = new HashSet<>();
        // 방향 벡터 사전 정의
        Map<String, int[]> dir = new HashMap<>();
        dir.put("U", new int[]{0, 1});
        dir.put("D", new int[]{0, -1});
        dir.put("R", new int[]{1, 0});
        dir.put("L", new int[]{-1, 0});
        // 문자열 순회하며 이동
        for (String s : dirs.split("")) {
            int nx = x + dir.get(s)[0];
            int ny = y + dir.get(s)[1];
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            // 양방향 경로를 구분하여 Set에 추가
            visited.add(x + "" + y + "" + nx + "" + ny);
            visited.add(nx + "" + ny + "" + x + "" + y);
            
            // 좌표 갱신
            x = nx;
            y = ny;
        }
        return visited.size() / 2;
    }
}