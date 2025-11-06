public class Account {

    protected class Date {
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

        void resetDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account(int id, double balance, double annualInterestRate, Date date) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
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

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public static void main(String[] args) {
        Account account = new Account(32, 5000, 3.5, new Account().new Date(2024, 6, 1));
        System.out.println("Account ID: " + account.getId());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Annual Interest Rate: " + account.getAnnualInterestRate() + "%");
        System.out.println("Date Created: " + account.getDateCreated().getYear() + "-" + account.getDateCreated().getMonth() + "-" + account.getDateCreated().getDay());

    }
}
