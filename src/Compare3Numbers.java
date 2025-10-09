// homework 1

import java.util.Scanner;

public class Compare3Numbers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // 创建 Scanner 对象，绑定到键盘输入
        System.out.print("Enter three integers: ");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println("all same");
        }
        else if (a != b && a != c && b != c) {
            System.out.println("all different");
        }
        else {
            System.out.println("neither");
        }

    }
}