import java.util.Map;
import java.util.TreeMap;

class Solution { 
    // 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아 리턴
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new TreeMap<>();
        Map<String, Integer> totalMap = new TreeMap<>();
        // records 순회하며 쪼개고 차량별 누적 주차 시간 계산해 넣기
        for (String r : records) {
            String[] parts = r.split(" ");
            // 입차 기록
            if (parts[2].equals("IN")) {
                inMap.put(parts[1], toMin(parts[0]));
            } else { // 출차 기록
                int curTime = toMin(parts[0]) - inMap.remove(parts[1]);
                totalMap.put(parts[1], totalMap.getOrDefault(parts[1], 0) + curTime);
            }
        }
        if (!inMap.isEmpty()) {
            for (String key : inMap.keySet()) {
                int curTime = toMin("23:59") - inMap.get(key);
                totalMap.put(key, totalMap.getOrDefault(key, 0) + curTime);
            }
        }
        int[] answer = new int[totalMap.size()];
        int index = 0;
        // 차량별 누적 주차 시간에 따라 요금 계산
        for (String key : totalMap.keySet()) {
            int time = totalMap.get(key);
            if (time <= fees[0]) answer[index] = fees[1];
            else {
                int extra = (int) Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
                answer[index] = fees[1] + extra;
            }
            index++;
        }
        return answer;
    }
    public int toMin(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 
            + Integer.parseInt(times[1]);
    }
}