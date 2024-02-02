import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] value = br.readLine().split(" ");

        int N = Integer.parseInt(value[0]);
        int M = Integer.parseInt(value[1]);


        List<List<User>> list = new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        /*
        처음 온 유저 -> 새로 생성, 값의 +- 10을 기준으로 나눔 ..
         */
        for (int i = 0; i < N; i++) {
            String[] userValue = br.readLine().split(" ");
            User user = new User(Integer.parseInt(userValue[0]), userValue[1]);

            if (list.isEmpty()) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                list.add(userList);
                continue;
            }
            boolean flag = false;

            // 새로운 방을 생성 해야하는 경우 -> level 차이

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).size() >= M)
                    continue;
                // 기존 방과 레벨 차이가 적당하다면 리스트에 추가
                if (user.getLevel() >= list.get(j).get(0).getLevel() - 10 && user.getLevel() <= list.get(j).get(0).getLevel() + 10 ) {
                    flag = true;
                    list.get(j).add(user);
                    break;
                }
            }

            /*
                전부 봤는데 들어갈 곳이 없다?
                -> 새로 방을 파라
             */
            if (!flag) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                list.add(userList);
            }
        }

        for (List<User> userList : list) {
            Collections.sort(userList,  Comparator.comparing(User::getNickname));
            if (userList.size() == M) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            for (User u : userList) {
                sb.append(u.level + " " + u.getNickname() + "\n");
            }
        }

        System.out.println(sb);
    }

    static class User {
        int level;
        String nickname;

        public User(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        public int getLevel() {
            return level;
        }

        public String getNickname() {
            return nickname;
        }
    }
}