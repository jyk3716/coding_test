import java.util.Set;
import java.util.LinkedHashSet;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                set.add(i);
            }
            if (n == 1) break;
        }
        int[] answer = set.stream().mapToInt(x -> x).toArray();
        return answer;
    }
}