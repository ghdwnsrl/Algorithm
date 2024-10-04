class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int time = 0;
        int continueHeal = 0;
        for (int i = 0; i < attacks.length; i++) {
            while (time < attacks[i][0]) {
                if (maxHealth == health) {
                    time++;
                    continueHeal++;
                    continue;
                }
                health += bandage[1];
                continueHeal++;
                if (continueHeal == bandage[0]) {
                    health += bandage[2];
                    continueHeal = 0;
                }
                if (health > maxHealth) {
                health = maxHealth;
                }
                time++;
            }
            if (time == attacks[i][0]) {
                health -= attacks[i][1];
                continueHeal = 0;
                if (health <= 0) {
                    return -1;
                }
                time++;
            }
        }
            return health;
    }
}