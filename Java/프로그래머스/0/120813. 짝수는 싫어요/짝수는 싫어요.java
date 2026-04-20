import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (i % 2 != 0) {
                arr.add(i);
            }
        }
        int[] answer = new int[arr.size()];
        for (int j=0; j<arr.size(); j++) {
            answer[j] = arr.get(j);
        }
        return answer;
    }
}