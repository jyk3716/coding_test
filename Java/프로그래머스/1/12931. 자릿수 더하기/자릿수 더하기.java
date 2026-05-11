import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //n을 문자열로 변환 후 한 글자씩 쪼개 문자 배열로 저장
        String[] nums = Integer.toString(n).split("");
        
        //문자 배열을 순회하며 정수형으로 변환하고 answer에 더해줌
        for (int i = 0; i < nums.length; i++) {
            answer += Integer.parseInt(nums[i]);
        }
        
        return answer;
    }
}