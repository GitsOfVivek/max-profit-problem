import java.util.Scanner;

public class MaxProfitProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();

        if (time < 5) {
            System.out.println("T 0 : P 0 : C 0");
            System.out.println("Earnings : $0");
            return;
        }

        int theater = time / 5;
        int totalEarning = 0;
        int maxEarning = Integer.MIN_VALUE;
        int result[] = new int[3];

        while (theater >= 0) {
            int leftTime = time - (theater * 5);
            int pub = 0;
            if (leftTime > 4) {
                pub = leftTime / 4;
            }
            totalEarning = findEarningTheater(time, theater, pub);
            if (maxEarning < totalEarning) {
                maxEarning = totalEarning;
                result[0] = theater;
                result[1] = pub;
                result[2] = maxEarning;
            }
            theater--;
        }
        System.out.println("T:" + result[0] + " P:" + result[1] + " C:0");
        System.out.println("Earnings : " + result[2]);

    }

    public static int findEarningTheater(int time, int theater, int pub) {
        int earning = 0;
        for (int i = 1; i <= theater; i++) {
            earning += (time - (i * 5)) * 1500;
        }
        time -= theater * 5;
        for (int i = 1; i <= pub; i++) {
            earning += (time - (i * 4)) * 1000;
        }
        return earning;
    }
}