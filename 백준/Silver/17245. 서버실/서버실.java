
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static long sum = 0;
    static long half = 0;

    static int lowerBound(int n) {
        int start = 0, end = arr[arr.length - 1], mid = 0;
        long tmpSum = 0;

        while (start < end) {
            mid = (start + end) / 2;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= mid)
                    tmpSum += mid;
                else
                    tmpSum += arr[i];
            }

            if (tmpSum >= half)
                end = mid;
            else
                start = mid + 1;

            tmpSum = 0;
        }

        return end;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        arr = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            int num = scanner.nextInt();
            arr[i] = num;
            sum += num;
        }

        half = Math.round(sum / 2.0);

        Arrays.sort(arr);

        System.out.println(lowerBound(n));
    }
}

