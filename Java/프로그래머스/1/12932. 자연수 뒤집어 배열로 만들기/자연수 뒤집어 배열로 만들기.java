class Solution {
    public int[] solution(long n) {
        //n을 문자열로 변환 후 한 글자씩 쪼개 문자 배열로 저장
        String[] nums = String.valueOf(n).split("");
        //여러 번 사용하게 될 nums.length를 변수로 선언
        int len = nums.length; 

        int[] answer = new int[len];
        
        //nums 배열 역순회하며 정수형으로 변환하고 answer 배열에 저장
        for (int i = 0; i < len; i++) {
            answer[i] = Integer.parseInt(nums[len - 1 - i]);
        }
        return answer;
    }
}