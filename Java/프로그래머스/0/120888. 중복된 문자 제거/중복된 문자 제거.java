import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String[] arr = my_string.split("");
        Set<String> set = new LinkedHashSet<>(Arrays.asList(arr));
        String answer = String.join("", set);
        return answer;
    }
}