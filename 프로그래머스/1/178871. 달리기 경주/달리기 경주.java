import java.util.*;

class Solution {
    static Map<String, Integer> race;
    public String[] solution(String[] players, String[] callings) {
        
        race = new HashMap<>();

        for (int i = 0; i < players.length ; i++) {
            race.put(players[i],i);
        }

        for (String calling : callings) {

            Integer ranking = race.get(calling);
            String fasterPlayer = players[ranking - 1];
            
            race.replace(fasterPlayer, ranking);
            players[ranking] = fasterPlayer;
            
            race.replace(calling, ranking - 1);
            players[ranking - 1] = calling;

        }
        
        return players;

    }
}
