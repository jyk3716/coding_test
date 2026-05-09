class Solution {
    public String solution(String rsp) {
        String[] rspArr = rsp.split("");
        String answer = "";
        
        for(int i = 0; i < rspArr.length; i++) {
            switch (rspArr[i]) {
                case "0":
                        answer += "5";
                        break;
                case "2":
                        answer += "0";
                        break;
                case "5":
                        answer += "2";
                        break;
            }
        }        
        
        return answer;
    }
}