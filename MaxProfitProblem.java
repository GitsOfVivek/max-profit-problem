import java.util.*;

public class MaxProfitProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] result = maxProfit(n);
        System.out.println("T " + result[0] + " : " + "P " + result[1] + " : " + "C " + result[2]);
        System.out.println("Earnings : $" + result[3]);
    }

    public static int[] maxProfit(int time) {
        if (time < 1) {
            return new int[] { 0, 0, 0, 0 };
        }
        int[] profitInTheater = maxProfitInBuildProp(time, 5, 1500);
        int[] profitInPub = maxProfitInBuildProp(time, 4, 1000);
        int[] profitInCommercial = maxProfitInBuildProp(time, 10, 3000);
        if (profitInTheater[0] >= profitInPub[0] && profitInTheater[0] >= profitInCommercial[0]) {
            return new int[] { profitInTheater[1], 0, 0, profitInTheater[0] };
        } else if (profitInPub[0] >= profitInTheater[0] && profitInPub[0] > profitInCommercial[0]) {
            return new int[] { 0, profitInPub[1], 0, profitInPub[0] };
        } else {
            return new int[] { 0, 0, profitInCommercial[1], profitInCommercial[0] };
        }
    }

    public static int[] maxProfitInBuildProp(int time, int buildTime, int unitEarning) {
        time -= buildTime;
        int totalProfit = time * unitEarning;
        int noOfProp = 1;
        if (time < 1) {
            return new int[] { 0, 0 };
        } else {
            while (buildTime < time) {
                time -= buildTime;
                totalProfit += (time * unitEarning);
                noOfProp++;
            }
            return new int[] { totalProfit, noOfProp };
        }
    }
}
