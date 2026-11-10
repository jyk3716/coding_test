import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<String> q = new ArrayDeque<>(); 
        for (String a : s.split("")) {
            if (a.equals("(")) q.add("(");
            else {
                if (q.isEmpty()) answer = false;
                else q.poll();
            }
        }
        if (!q.isEmpty()) answer = false;

        return answer;
    }
}