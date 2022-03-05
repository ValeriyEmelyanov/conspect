package multithreading_and_concurrency.program_lock3_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private final Condition balanceIncreased = lock.newCondition();

    private long balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            balance += amount;
            balanceIncreased.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitAndWithdraw(int amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            while (balance < amount) {
                balanceIncreased.await();
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    private void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
