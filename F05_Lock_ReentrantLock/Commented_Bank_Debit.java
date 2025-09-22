package F05_Lock_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Bank_Debit
 *
 * Demonstrates using ReentrantLock to protect a critical section (debiting a shared balance)
 * with a bounded wait using tryLock(timeout). This avoids indefinite blocking under contention
 * and ensures the lock is always released in a finally block.
 *
 * Notes:
 * - The sleep inside the critical section simulates a long-running task while holding the lock.
 * - In production, prefer catching InterruptedException explicitly and re-interrupting the thread.
 * - Consider fairness policy (new ReentrantLock(true)) if starvation should be minimized.
 */
public class Commented_Bank_Debit {

    /**
     * Shared mutable state guarded by 'lock'.
     * Consider making this field private and always mutate/read it under the same lock.
     */
    public int amount = 200;

    /**
     * Explicit lock protecting the critical section.
     * Prefer 'final' for immutability, and consider fairness if needed: new ReentrantLock(true).
     */
    Lock lock = new ReentrantLock();

    /**
     * Attempts to withdraw from the shared balance.
     * Uses tryLock with a 1-second timeout to avoid waiting forever if another thread holds the lock.
     *
     * @param withdraw_amount the amount to subtract from the balance if sufficient funds are available
     */
    public void debit(int withdraw_amount) {
        // Log which thread is attempting the operation and the current balance (printed via 'amount').
        // For clarity in logs, consider printing 'withdraw_amount' here if desired.
        System.out.println(Thread.currentThread().getName() + "attempting to withdraw " + amount);

        try {
            // Non-blocking acquisition with bounded wait:
            // - Returns true if the lock is acquired within 1 second.
            // - Returns false immediately after 1 second if the lock could not be acquired.
            // This prevents indefinite waiting and enables fail-fast behavior under contention.
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) { // lock.lock() here would block indefinitely (similar to synchronized)
                try {
                    // Validate funds atomically while holding the lock, so the check and update are consistent.
                    if (amount >= withdraw_amount) {
                        // Log processing; currently prints the balance ('amount').
                        // Consider logging the requested amount to make messages more descriptive.
                        System.out.println(Thread.currentThread().getName() + "processing the withdraw " + amount);

                        // Perform the state change inside the critical section.
                        amount -= withdraw_amount;

                        // Simulate a long-running operation while the lock is held.
                        // This increases lock hold time; in production, keep critical sections minimal.
                        Thread.sleep(3000);

                        // Confirmation log after successful debit.
                        System.out.println(
                                Thread.currentThread().getName() + " completed withdrawl, Remaining balance : " + amount
                        );
                    } else {
                        // Insufficient funds path (still inside the lock to keep check+log consistent).
                        System.out.println("insufficient balance");
                    }
                } catch (Exception e) {
                    // Catching generic Exception for demo; in production:
                    // - Prefer catching InterruptedException separately
                    // - Re-interrupt the thread to preserve interruption status:
                    //   if (e instanceof InterruptedException) { Thread.currentThread().interrupt(); }
                    System.out.println(e.getMessage());
                } finally {
                    // Always release the lock in a finally block so it is freed even when exceptions occur.
                    lock.unlock();
                }
            } else {
                // Could not get the lock within the timeout window.
                // This is the fail-fast branch—log and optionally retry with backoff outside this method.
                System.out.println(Thread.currentThread().getName() + "could not acquire the lock, so will try later");
            }
        } catch (Exception e) {
            // tryLock(timeout) can throw InterruptedException if the waiting thread is interrupted.
            // Best practice is to log and then re-interrupt to propagate cancellation semantics:
            // Thread.currentThread().interrupt();
            System.out.println(e);
        }
    }
}
