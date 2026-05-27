import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) { // 40분 고민했는데 아직 안 풀림 + 19:09~
        // 100 미만일 때 넣고, 100 이상이 되면 뺀다?
        // 가장 먼저 넣은 것부터 뺄 수 있음 -> 선입선출 FIFO 구조 ->  스택/큐
        // 큐에 인덱스만 넣으면 될 듯 해보자
        Queue<Integer> q = new ArrayDeque<>();
        int len = progresses.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                progresses[i] += speeds[i];
                int cur = q.peek();
                //System.out.println(cur);
                if (progresses[cur] >= 100) {
                    q.poll();
                    count++;
                    //System.out.println("카운트" + count);
                }
            }
            //System.out.println("사이즈" + q.size());
            if (count != 0) {
                list.add(count);
            }
        } 
        
        //System.out.println(progresses[2]);
        int[] answer = new int[list.size()];
        int size = 0;
        for (int l : list) {
            answer[size++] = l;
        }
        return answer;
    }
}