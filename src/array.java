import java.util.Random;


public class array {
    public static boolean isPrime(int num){
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        Random rand = new Random();

        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(0, 100);

        for (int element: arr)
            System.out.print(element + " ");
        System.out.println();

        for (int element: arr) {
            if (element % 2 == 0)
                System.out.print(element + " ");
        }
        System.out.println();

        for (int element: arr){
            if (isPrime(element))
                System.out.print(element + " ");
        }
        System.out.println();

        int[] reversedArr = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
            System.out.print(reversedArr[i] + " ");
        }
        System.out.println();

        System.out.println(arr[0] + " " + arr[arr.length - 1]);
    }
}
