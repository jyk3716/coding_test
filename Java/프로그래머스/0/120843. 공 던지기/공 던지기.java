class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int index = 0;
        
        int len = numbers.length;        
        for (int i = 0; i < k; i++) {
            answer = numbers[index];
            index += 2;
            if (index >= len) {
                index -= len;
            }
            
        }
        
        return answer;
    }
}