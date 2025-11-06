public class Account {

    public class Date {
        private int year;
        private int month;
        private int day;

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        int getYear() {
            return year;
        }

        int getMonth() {
            return  month;
        }

        int getDay() {
            return day;
        }
    }

    private static double annualInterestRate = 0;

    private int id;
    private double balance;
    private Date dateCreated;

    public Account(int id, double balance, Date date) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = date;
    }

    public Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = null;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double withdraw(double amount) {
        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Insufficient balance");

        return balance;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public static double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public static void main(String[] args) {
        Account account = new Account(32, 5000, new Account().new Date(2024, 6, 1));
        System.out.println("Account ID: " + account.getId());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Annual Interest Rate: " + Account.getAnnualInterestRate() + "%");
        System.out.println("Date Created: " + account.getDateCreated().getYear() + "-" + account.getDateCreated().getMonth() + "-" + account.getDateCreated().getDay());
    }
}

