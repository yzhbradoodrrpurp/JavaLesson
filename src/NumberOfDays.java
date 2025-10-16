public class NumberOfDays {
    public static void main(String[] args) {
        for (int year = 2030; year <= 2040; year++)
            System.out.println(year + ": " + numberOfDaysInAYear(year) + " days");
    }

    public static int numberOfDaysInAYear(int year){
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            return 366;  // 闰年
        else
            return 365;  // 平年
    }
}
