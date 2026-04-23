import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array) {
        int mode = 0; // 최빈값
        
        List<Integer> list = Arrays.stream(array)
            .boxed()
            .collect(Collectors.toList());
        
        int maxCount = 0;
        
        for (int i=0; i<array.length; i++){
            int currentCount = Collections.frequency(list, array[i]);
            if (currentCount > maxCount) {
                mode = array[i];
                maxCount = currentCount;
            } else if (currentCount == maxCount && array[i] != mode) {
                mode = -1;
            }
        }
        
        int answer = mode;
        return answer;
    }
}