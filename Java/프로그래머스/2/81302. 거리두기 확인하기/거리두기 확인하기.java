import java.util.*;

class Solution {
    boolean isInRange(int r, int c) {
        return (r >= 0 && r < 5) && (c >= 0 && c < 5);
    }
    public int[] solution(String[][] places) { //1:00~
        int answer[] = new int[5];
        for (int i = 0; i < 5; i++) { //대기실 번호
            //일단 거리두기를 잘 지켰다고 가정
            answer[i] = 1;
            for (int r = 0; r < 5; r++) { //행
                for (int c = 0; c < 5; c++) { //열
                    if (places[i][r].charAt(c) == 'P') {
                        //bfs 결과 거리두기 위반자가 단 한 명이라도 있으면
                        if (!bfs(r, c, places[i])) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
    boolean bfs(int r, int c, String[] place) {
        //4방향 이동 배열 생성
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //방문 여부 배열 생성
        boolean[][] visited = new boolean[5][5];
        //BFS 구현 위한 큐 생성
        Queue<int[]> queue = new ArrayDeque<>();
        //시작점 정보(행, 열, 거리) 큐에 넣고 방문 처리
        queue.add(new int[]{r, c, 0});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            //현 위치 정보 큐에서 제거 및 저장
            int[] cur = queue.remove();
            //거리가 2에 도달하면 더 이상 안 뻗어나감
            if (cur[2] >= 2) continue;
            
            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                int ndist = cur[2] + 1;
                //파티션이 아닌 곳만 통과
                if (isInRange(nr, nc) && place[nr].charAt(nc) != 'X') {
                    if (!visited[nr][nc]) {
                        //사람을 만나면 거리두기 위반이므로 즉시 종료
                        if (place[nr].charAt(nc) == 'P') return false;
                        //빈 테이블일 경우에만 다음 탐색 이어감
                        queue.add(new int[]{nr, nc, ndist});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return true;
    }
}