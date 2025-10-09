// homework 4

public class StairIssue {
    public static void main(String[] args) {
        int stairs = 15;
        int ways = getWays(stairs);
        System.out.println("There're " + ways + " ways to climb to the top.");
    }

    private static int getWays(int stairs) {
        if (stairs == 1) {
            return 1;
        }
        else if (stairs == 2) {
            return 1;
        }
        else if (stairs == 3) {
            return 2;
        }
        else{
            return getWays(stairs - 1) + getWays(stairs - 3);
        }
    }
}
