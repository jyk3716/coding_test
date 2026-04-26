class Solution {
    public int[] solution(int[] num_list) {
        // num_list와 동일한 길이의 answer 배열 생성
        int[] answer = new int[num_list.length];
        // answer 배열의 끝부터 원소 대입
        for (int i=0; i<num_list.length; i++) {
            answer[num_list.length-1-i] = num_list[i];
        }
        return answer;
    }
}