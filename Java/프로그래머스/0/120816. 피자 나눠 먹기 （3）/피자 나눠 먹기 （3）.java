class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        // while문 사용해 slice * answer / n == 1 이 최초로 되는 때 찾거나
        // 수식 변형해 n / slice == answer 이라는 것 구하고 if문 활용
        if (n % slice == 0) {
            answer = n / slice;
        } else {
            answer = n / slice + 1;
        }
        return answer;
    }
}