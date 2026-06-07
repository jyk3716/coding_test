import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) { // 15:49~
        //substring, split, charAt중 뭘 사용할지 고민
        //약관 종류는 알파벳 대문자 하나라 charAt 써도 무관하지만, 
        //유효기간이 1~3자리 수이므로 charAt은 가장 좋지 않은 선택
        //split 사용시 공백 기준으로 쪼갠 배열이 되므로 List<String[]>
        //substring 사용시 쪼갤 위치 지정해 각각 문자열로 만들고 map에 저장
        //map에 저장하는 방식이 가장 효율적일 듯함
        Map<Character, Integer> tMap = new HashMap<>();
        List<Integer> expList = new ArrayList<>();
        Integer todayDays = getDateInDays(today);
        for (String t : terms) {
            tMap.put(t.charAt(0), Integer.valueOf(t.substring(2)));
        }
        //System.out.println(tMap);
        //for문 돌며 유효기간 가져오기,
        //만료일 구하기, 
        //동일 여부 구해 배열에 넣기까지 한 번에 처리
        for (int i = 0; i < privacies.length; i++) {
            String p = privacies[i];
            Integer period = tMap.get(p.charAt(11)) * 28;
            //System.out.println(period);
            Integer expireDays = getDateInDays(p.substring(0, 10)) + period;
            if (todayDays >= expireDays) {
                expList.add(i+1);
            }
        }
        int[] answer = new int[expList.size()];
        int index = 0;
        for (Integer e : expList) {
            answer[index++] = e;
        }
        return answer;
    }
    private int getDateInDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        return (year*12*28) + (month*28) + day;
    }
}