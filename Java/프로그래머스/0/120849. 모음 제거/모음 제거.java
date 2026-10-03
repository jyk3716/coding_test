class Solution {
    public String solution(String my_string) {
        String[] arr = my_string.split("");
        String answer = "";
        
        for (String i : arr) {
            if (!i.equals("a") && !i.equals("e") && !i.equals("i") && !i.equals("o") && !i.equals("u")) {
                answer += i;
            }
        }
        return answer;
    }
}