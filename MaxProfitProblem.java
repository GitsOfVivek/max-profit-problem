// In this problem Commercial Park is redundant because
// instead of making Commercial Park, I can make Theater
// It will give more profit.
// P : 4, 1000
// T : 5, 1500
// C : 10, 6000

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
        int totalEarning = 0;
        int maxEarning = Integer.MIN_VALUE;

        int cPark = time / 10;

        while(cPark >= 0) {
            int timeLeft1 = time - (cPark * 10);
            int theater = timeLeft1 / 5;
            while(theater >= 0) {
                int timeLeft2 = timeLeft1 - (theater * 5);
                int pub = 0;
                if(timeLeft2 > 4) {
                    pub = timeLeft2 / 4;
                }
                totalEarning = findEarning(time, cPark, theater, pub);
                int[] result = new int[4];
                if(maxEarning < totalEarning) {
                    maxEarning = totalEarning;
                    result[0] = cPark;
                    result[1] = theater;
                    result[2] = pub;
                    result[3] = maxEarning;
                }
                listOfResult.add(result);
                theater--;
            }
            cPark--;
        }
        for(int i = 0; i < listOfResult.size(); i++) {
            if(listOfResult.get(i)[3] == maxEarning) {
                System.out.println("T:" + listOfResult.get(i)[1] + " P:" + listOfResult.get(i)[2] + " C:" + listOfResult.get(i)[0]);
            }
        }
        System.out.println("Earnings : $" + maxEarning);

    }

    public static int findEarning(int time, int cPark, int theater, int pub) {
        int earning = 0;
        for(int i = 1; i <= cPark; i++) {
            earning += (time - (i * 10)) * 6000;
        }
        time -= cPark * 10;
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

