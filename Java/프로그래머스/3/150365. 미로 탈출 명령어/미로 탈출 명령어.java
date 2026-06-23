import java.util.*;

class Solution { // 20:45~
    // 사전 순으로 빠른 경로로 탈출하려면 dlru 순으로 시도해보고 
    // 가장 먼저 나온 케이스에서 바로 리턴
    
    // 4뱡향 이동 배열 생성 (d하, l좌, r우, u상)
    int[] dr = {1, 0, 0, -1};
    int[] dc = {0, -1, 1, 0};
    String[] ds = {"d", "l", "r", "u"};
    String answer = null;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 격자의 크기 : n x m
        // 출발 위치 : (x, y)
        // 탈출 지점 : (r, c)
        // 이동 거리 : k
        // 탈출 불가한 경우 : "impossible"

        // 시작 전 불가능한 케이스 가지치기
        // 시작점과 도착점 사이 거리 계산해
        // 이동 거리 조건인 k보다 크거나 
        // 두 수의 차가 짝수가 아닐 경우 불가능 리턴
        if (isImpossible(x, y, r, c, k)) return "impossible";
        
        DFS(n, m, x, y, r, c, k, 0, new StringBuilder());
        
        return answer == null ? "impossible" : answer;
    }
    void DFS(int n, int m, int curR, int curC, int r, int c, int k, 
             int depth, StringBuilder path) {
        // 이미 정답을 찾았다면 다른 가지 무시 (처음 찾은 정답이 사전 순으로 가장 빠름)
        if (answer != null) return;
        // DFS 진행할 때마다 불가능 케이스 가지치기
        if (isImpossible(curR, curC, r, c, k-depth)) return;
        
        if (depth == k) {
            if (curR == r && curC == c) {
                answer = path.toString();
            }
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nextR = curR + dr[i];
            int nextC = curC + dc[i];
            if (isInRange(n, m, nextR, nextC)) {
                path.append(ds[i]);
                DFS(n, m, nextR, nextC, r, c, k, depth+1, path);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
    boolean isInRange (int n, int m, int x, int y) {
        return (x >= 1 && x <= n) && (y >= 1 && y <= m);
    }
    boolean isImpossible (int x, int y, int r, int c, int k) {
        int dist = Math.abs(r-x) + Math.abs(y-c);
        return (dist > k || (k-dist) % 2 != 0);
    }
}