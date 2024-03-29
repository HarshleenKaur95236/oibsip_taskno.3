import java.util.*;
public class Main {
    private double balance;
    private double depositamount;
    private double withdrawamount;
    private double transfer;
    Map<Double, String> history = new HashMap<>();    //Hashmap used for string transaction history

    public Main() {
    }

    //        getter and setter methods
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTransfer() {
        return transfer;
    }

    public void setTransfer(double transferamount) {
        this.transfer = transferamount;
    }

    public double getDepositamount() {
        return depositamount;
    }

    public void setDepositamount(double depositamount) {
        this.depositamount = depositamount;
    }

    public double getwithdramount() {
        return withdrawamount;
    }

    public void setWithdrawamount(double withdrawamount) {
        this.withdrawamount = withdrawamount;
    }

    public void check_balance() {
        System.out.println(" Available Balance is: " + getBalance());
    }

    public void withdraw(double withdraw) {
        if (withdraw > getBalance()) {
            System.out.println(" Insuffient Balance..");
        } else {
            history.put(withdraw, " Amount Withdrawn");
            System.out.println(withdraw + " Amount withdraw Successfully..!");
            setBalance(getBalance() - withdraw);
            check_balance();
        }
    }

    public void deposit(double deposit) {
        history.put(deposit, " Amount Deposited");
        System.out.println(deposit + " Deposit Successfully..!");
        setBalance(getBalance() + deposit);
        check_balance();
    }

    public void transfer(double transfer) {
        if (transfer > getBalance()) {
            System.out.println(" Insuffient Balance..");
        } else {
            history.put(transfer, " Amount Transfer");
            System.out.println("Transfer Successful");
            setBalance(getBalance() - transfer);
            check_balance();
        }
    }

    public void showHistory() {
        for (Map.Entry<Double,String > entry :history.entrySet()){
            System.out.println(entry.getKey() + ";" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int atm_number = 12345;
        int atmpin = 123;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM Machine");
        System.out.println("Enter ATM number: ");
        int atmNumber = sc.nextInt();
        System.out.println("Enter PIN");
        int pin = sc.nextInt();

        Main atm = new Main();

        if ((atmNumber == atm_number) && (pin == atmpin)) {
            while (true) {
                System.out.println("1.Check Balance\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Transaction History\n6.Exit");
                System.out.println("Enter the choice:");
                int ch = sc.nextInt();
                if (ch == 1) {
                    atm.check_balance();
                } else if (ch == 2) {
                    System.out.println("Enter the amount which you want to Withdraw: ");
                    double with = sc.nextDouble();
                    atm.withdraw(with);
                } else if (ch == 3) {
                    System.out.println("Enter the amount which you want to deposit: ");
                    double depo = sc.nextDouble();
                    atm.deposit(depo);
                } else if (ch == 4) {
                    System.out.println("Enter recipient's account number: ");
                    int no = sc.nextInt();
                    System.out.println("Enter the amount which you want to transfer: ");
                    double trans = sc.nextDouble();
                    atm.transfer(trans);
                } else if (ch == 5) {
                    atm.showHistory();
                } else if (ch == 6) {
                    System.out.println("Collect Your ATM card\nThank you for using ATM Machine");
                    System.exit(0);
                } else {
                    System.out.println("Please, Enter Correct Choice..");
                }
            }
        } else {
            System.out.println("Incorrect Atm Number or pin");
            System.exit(0);
        }
    }
}
