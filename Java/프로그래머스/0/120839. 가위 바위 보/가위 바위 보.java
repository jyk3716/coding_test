class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        
        char[] charArr = rsp.toCharArray();
        
        for(char c: charArr) {
            switch (c) {
                case '0':
                    sb.append("5");
                    break;
                case '2':
                    sb.append("0");
                    break;
                case '5':
                    sb.append("2");
                    break;
            }
        }        
        
        String answer = sb.toString();
        return answer;
    }
}