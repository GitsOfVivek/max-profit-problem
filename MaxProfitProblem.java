import java.util.*;

public class MaxProfitProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] result = maxProfit(n);
        System.out.println("T " + result[2] + " : " + "P " + result[3] + " : " + "C " + result[1]);
        System.out.println("Earnings : $" + result[0]);
    }

    public static int[] maxProfit(int time) {
        if (time < 1) {
            return new int[] { 0, 0, 0, 0 };
        }
        int[] commercial = maxProfitInBuildProp(time, "C");
        int[] theater = maxProfitInBuildProp(time, "T");
        int[] pub = maxProfitInBuildProp(time, "P");
        if (commercial[0] >= theater[0] && commercial[0] >= pub[0]) {
            return commercial;
        } else if (theater[0] >= commercial[0] && theater[0] >= pub[0]) {
            return theater;
        } else {
            return pub;
        }
    }

    public static int[] maxProfitInBuildProp(int time, String X) {

        int buildTimeC = 10;
        int buildTimeT = 5;
        int buildTimeP = 4;

        int unitEarningC = 3000;
        int unitEarningT = 1500;
        int unitEarningP = 1000;

        int noOfPropC = 0;
        int noOfPropT = 0;
        int noOfPropP = 0;

        int totalProfit;
        if (X == "C") {
            time -= buildTimeC;
            totalProfit = time * unitEarningC;
            noOfPropC++;
        } else if (X == "T") {
            time -= buildTimeT;
            totalProfit = time * unitEarningT;
            noOfPropT++;
        } else {
            time -= buildTimeP;
            totalProfit = time * unitEarningP;
            noOfPropP++;
        }
        if (time < 1) {
            return new int[] { 0, 0, 0, 0 };
        } else {
            while (time > buildTimeC || time > buildTimeT || time > buildTimeP) {
                if (time > buildTimeC) {
                    time -= buildTimeC;
                    totalProfit += (time * unitEarningC);
                    noOfPropC++;
                }
                if (time > buildTimeT) {
                    time -= buildTimeT;
                    totalProfit += (time * unitEarningT);
                    noOfPropT++;
                }
                if (time > buildTimeP) {
                    time -= buildTimeP;
                    totalProfit += (time * unitEarningP);
                    noOfPropP++;
                }
            }

            return new int[] { totalProfit, noOfPropC, noOfPropT, noOfPropP };
        }
    }
}
