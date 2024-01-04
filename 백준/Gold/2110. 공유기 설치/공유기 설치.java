import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] house;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int C = Integer.parseInt(arr[1]);

        house = new int[N];


        for (int i = 0 ; i < N ; i ++ ) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int low = 1;
        int high = house[N-1] - house[0] + 1;

        while (low < high) {

            int mid = (low + high) / 2;

            /*
            거리가 너무 크니까 공유기 설치 수에 못 미침 -> high 값 수정
             */
            if (checkWifi(mid) < C) {
                high = mid ;
            } else {
                low = mid + 1;
            }

        }
        System.out.println(low - 1);
    }

    private static int checkWifi(int mid) {

        int count = 1;
        int prev = house[0];

        for (int i = 1; i < house.length ; i++) {
            if ((house[i] - prev) >= mid) {
                count++;
                prev = house[i];
            }

        }
        return count;
    }
}

