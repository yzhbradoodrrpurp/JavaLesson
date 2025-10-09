// homework 2

import java.util.Scanner;

public class CalculateBonus {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the profit: ");

        double profit = sc.nextDouble();
        double bonus = 0;

        if (profit <= 100000)
            bonus += profit * 0.1;


        if (profit > 100000 && profit < 200000)
            bonus += 100000 * 0.1 + (profit - 100000) * 0.075;

        if (profit >= 200000 && profit < 400000)
            bonus += 100000 * 0.1 + 100000 * 0.075 + (profit - 200000) * 0.05;

        if (profit >= 400000 && profit < 600000)
            bonus += 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + (profit - 400000) * 0.03;

        if (profit >= 600000 && profit < 1000000)
            bonus = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + (profit - 600000) * 0.015;

        if (profit >= 1000000)
            bonus = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + 400000 * 0.015 + (profit - 1000000) * 0.01;

        System.out.println("The bonus is: " + bonus);
    }
}
