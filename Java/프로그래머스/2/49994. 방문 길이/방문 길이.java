import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution { // 캐릭터가 처음 걸어본 길의 길이만 구할 것
    public int solution(String dirs) {
        // 시작점 초기화
        int x = 0;
        int y = 0;
        // 방문 여부 Set
        Set<String> visited = new HashSet<>();
        // 문자열 순회하며 이동
        for (char d : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            
            if (d == 'U' && ny < 5) ny++;
            else if (d == 'D' && ny > -5) ny--;
            else if (d == 'R' && nx < 5) nx++;
            else if (d == 'L' && nx > -5) nx--;
            else continue;
            
            //양방향 경로를 구분하여 Set에 추가
            visited.add(x + "" + y + "" + nx + "" + ny);
            visited.add(nx + "" + ny + "" + x + "" + y);
            
            x = nx;
            y = ny;
        }
        return visited.size() / 2;
    }
}