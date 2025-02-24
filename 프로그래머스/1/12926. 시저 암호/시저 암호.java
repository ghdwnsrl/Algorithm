import java.util.stream.Collectors;

class Solution {
    public String solution(String s, int n) {
        return s.chars()
                .mapToObj(c -> {
                    if (c == ' ') return " ";
                    if (c >= 'A' && c <= 'Z') {
                        if (c + n > 'Z')
                            return String.valueOf((char) (c + n - 26));
                        else
                            return String.valueOf((char) (c + n));
                    } else if (c >= 'a' && c <= 'z') {
                        if (c + n > 'z')
                            return String.valueOf((char) (c + n - 26));
                        else
                            return String.valueOf((char) (c + n));
                    }
                    return String.valueOf((char) (c + n));
                }).collect(Collectors.joining());
    }
}