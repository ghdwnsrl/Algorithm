import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String> nicknameMap = new HashMap<>();

        StringTokenizer st;

        List<String> answerList = new LinkedList<>();

        for (String r : record) {
            st = new StringTokenizer(r);

            while (st.hasMoreTokens()) {
                String cmd = st.nextToken();
                if (cmd.equals("Enter")) {
                    String uid = st.nextToken();
                    String nickname = st.nextToken();
                    nicknameMap.put(uid,nickname);
                    answerList.add(uid+"님이 들어왔습니다.");
                } else if (cmd.equals("Leave")) {
                    String uid = st.nextToken();
                    answerList.add(uid+"님이 나갔습니다.");
                } else {
                    String uid = st.nextToken();
                    String changeNickname = st.nextToken();
                    nicknameMap.replace(uid, changeNickname);
                }
            }
        }
        
        String[] answer = new String[answerList.size()];
        int idx = 0;
        for (String s : answerList) {
            String[] split = s.split("님");
            String uid = split[0];
            String contents = "님" + split[1];

            String nickname = nicknameMap.get(uid);
            String result = nickname + contents;
            answer[idx++] = result;
        }
        
        return answer;
    }
}