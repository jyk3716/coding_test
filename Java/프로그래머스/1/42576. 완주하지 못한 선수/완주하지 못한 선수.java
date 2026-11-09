import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 두 배열 모두 오름차순 sort하고 비교해서 달라지는 순간 return
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}