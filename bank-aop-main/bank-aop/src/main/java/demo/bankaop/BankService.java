
package demo.bankaop;

import org.springframework.stereotype.Service;

@Service
public class BankService {

    private double balance = 1000;

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be positive"
            );
        }

        balance += amount;

        System.out.println(
            "Deposited: " + amount + ", balance: " + balance
        );
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be positive"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance"
            );
        }

        balance -= amount;

        System.out.println(
            "Withdrawn: " + amount + ", balance: " + balance
        );
    }
}

