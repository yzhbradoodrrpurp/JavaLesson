import java.util.Scanner;

public class ATM {
    private Account[] accounts;

    ATM(Account[] accounts){
        this.accounts = accounts;
    }

    private Account authenticate(int id){
        for (Account account : accounts) {
            if (account.getID() == id) {
                return account;
            }
        }
        return null;
    }

    public void execute(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your account ID: ");
        int id = sc.nextInt();

        Account account = authenticate(id);

        if (account == null) {
            System.out.println("Invalid account ID, please retry: ");
            do {
                id = sc.nextInt();
                account = authenticate(id);
            } while(account == null);
        }

        while (true) {
            showMenu(account);
            int operation = sc.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Your current balance is: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using our ATM.");
                    execute();
                    break;
            }
        }


    }

    private void showMenu(Account account){
        System.out.println("============================================================");
        System.out.println("You've successfully logged in as " + account.getID() + ".");
        System.out.println("Select Operation You want to do:\n1. Check Balance\t\t2. Withdraw\t\t3. Deposit\t\t4. Exit");
    }

    public static void main(String[] args){
        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(100 + i, 100, new Account().new Date(2024, 6, 1));
        }

        ATM atm = new ATM(accounts);
        atm.execute();
    }
}
