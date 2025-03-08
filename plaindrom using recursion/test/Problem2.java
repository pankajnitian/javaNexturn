package test;

abstract class BankAcc {
    protected String accNum;
    protected double bal;

    public BankAcc(String accNum, double bal) {
        this.accNum = accNum;
        this.bal = bal;
    }

    public void deposit(double amt) {
        bal += amt;
        System.out.println("Deposited: ₹" + amt + ", New Balance: ₹" + bal);
    }

    public abstract boolean withdraw(double amt);
}

interface Transact {
    void transfer(BankAcc toAcc, double amt);
}
class SavAcc extends BankAcc implements Transact {
    private static final double MIN_BAL = 500;

    public SavAcc(String accNum, double bal) {
        super(accNum, bal);
    }

    @Override
    public boolean withdraw(double amt) {
        if (bal - amt >= MIN_BAL) {
            bal -= amt;
            System.out.println("Withdrawn: ₹" + amt + ", New Balance: ₹" + bal);
            return true;
        } else {
            System.out.println("Withdrawal failed! Minimum balance of ₹" + MIN_BAL + " must be maintained.");
            return false;
        }
    }


    public void transfer(BankAcc toAcc, double amt) {
        if (withdraw(amt)) {
            toAcc.deposit(amt);
            System.out.println("Transferred: ₹" + amt + " from " + accNum + " to " + toAcc.accNum);
        } else {
            System.out.println("Transfer failed!");
        }
    }
}

class CurAcc extends BankAcc implements Transact {
    private static final double OD_LIMIT = 5000;

    public CurAcc(String accNum, double bal) {
        super(accNum, bal);
    }


    public boolean withdraw(double amt) {
        if (bal - amt >= -OD_LIMIT) {
            bal -= amt;
            System.out.println("Withdrawn: ₹" + amt + ", New Balance: ₹" + bal);
            return true;
        } else {
            System.out.println("Withdrawal failed! Overdraft limit exceeded.");
            return false;
        }
    }


    public void transfer(BankAcc toAcc, double amt) {
        if (withdraw(amt)) {
            toAcc.deposit(amt);
            System.out.println("Transferred: ₹" + amt + " from " + accNum + " to " + toAcc.accNum);
        } else {
            System.out.println("Transfer failed!");
        }
    }
}

public class Problem2 {
    public static void main(String[] args) {
        SavAcc sav = new SavAcc("SAV123", 5000);
        CurAcc cur = new CurAcc("CUR456", 2000);

        sav.deposit(1000);
        cur.withdraw(3000);

        sav.transfer(cur, 1500);
        cur.transfer(sav,6000);
    }
}
