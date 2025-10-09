// homework 3

public class PrizeAllocation {
    public static void main(String[] args) {
        int gift = 50;
        int people = 30;

        for (int first = 0; first <= people; first++) {
            for(int second = 0; second <= people; second++) {
                for(int third = 0; third <= people; third++) {
                    if (first + second + third == people && 3 * first + 2 * second + third == gift) {
                        System.out.print("First prize: " + first + ", ");
                        System.out.print("Second prize: " + second + ", ");
                        System.out.println("Third prize: " + third);
                    }
                }
            }
        }
    }

}
