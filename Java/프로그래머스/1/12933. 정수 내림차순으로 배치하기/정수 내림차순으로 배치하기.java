//Arrays와 Collections 불러오기
import java.util.*;

class Solution {
    public long solution(long n) {
        String answer = "";
        
        String[] nums = String.valueOf(n).split("");
        Arrays.sort(nums, Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            answer += nums[i];
        }
        return Long.parseLong(answer);
    }
}