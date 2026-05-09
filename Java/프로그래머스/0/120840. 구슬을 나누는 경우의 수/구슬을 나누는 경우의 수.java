class Solution {
    public int solution(int balls, int share) {
        //조합 공식 이용하기
        //(balls)C(share) = (balls)! / (balls-share)! / (share)!
        
        long answer = 1L;
        int divide = 1;
        
        for (int i = balls; i > balls-share; i--) {
            answer *= i;
            answer /= divide;
            divide++;
        }
        
        return (int) answer;
    }
}