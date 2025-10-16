import java.util.Scanner;

public class SocialAid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the anual income: (Press -1 to exit) ");
            int anualIncome = sc.nextInt();

            if (anualIncome == -1)
                break;

            System.out.print("Enter the number of children: ");
            int numOfChildren = sc.nextInt();

            int socialAid = 0;

            if (anualIncome >= 15000 && anualIncome <= 20000 && numOfChildren >= 3)
                socialAid = 1000 * numOfChildren;
            else if (anualIncome <= 15000 && anualIncome >= 10000 && numOfChildren >= 2)
                socialAid = 1500 * numOfChildren;
            else if (anualIncome < 10000)
                socialAid = 2000 * numOfChildren;

            System.out.println("The social aid is: " + socialAid);
        }
    }
}
