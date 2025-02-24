import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        LocalDate localDate = LocalDate.of(2016, a, b);
        int idx =  localDate.getDayOfWeek().getValue();
        return days[idx % 7];
    }
}