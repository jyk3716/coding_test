class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int len = num2 - num1 + 1;
        int[] answer = new int[len];
        int index = 0;
        
        for (int i = num1; i <= num2; i++) {
                answer[index] = numbers[i];
                index++;
        }
        return answer;
    }
}