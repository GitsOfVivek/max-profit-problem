// In this problem Commercial Park is redundant because
// instead of making Commercial Park, I can make Theater
// It will give more profit.

import java.util.ArrayList;
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

        ArrayList<int[]> listOfResult = new ArrayList<>();
        int theater = time / 5;
        int totalEarning = 0;
        int maxEarning = Integer.MIN_VALUE;

        while (theater >= 0) {
            int leftTime = time - (theater * 5);
            int pub = 0;
            if (leftTime > 4) {
                pub = leftTime / 4;
            }
            totalEarning = findEarningTheater(time, theater, pub);
            int result[] = new int[3];
            if (maxEarning <= totalEarning) {
                maxEarning = totalEarning;
                result[0] = theater;
                result[1] = pub;
                result[2] = maxEarning;
            }
            listOfResult.add(result);
            theater--;
        }
        for(int i = 0; i < listOfResult.size(); i++) {
            if(listOfResult.get(i)[2] == maxEarning) {
                System.out.println("T:" + listOfResult.get(i)[0] + " P:" + listOfResult.get(i)[1] + " C:0");
            }
        }
        System.out.println("Earnings : $" + maxEarning);
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