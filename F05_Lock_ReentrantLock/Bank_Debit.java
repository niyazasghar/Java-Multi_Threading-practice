package F05_Lock_ReentrantLock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank_Debit {
    public int amount=200;
    Lock lock= new ReentrantLock();
    public void debit(int withdraw_amount) {
        System.out.println(Thread.currentThread().getName() + "attempting to withdraw " + amount);
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){ // in this if condition we can use lock.lock() -> which works similar to synchronized

                try{
                    if(amount>=withdraw_amount){
                        System.out.println(Thread.currentThread().getName() + "processing the withdraw " + amount);
                        amount-=withdraw_amount;
                        Thread.sleep(3000); // this is mainly done (to show that there is long task running here)
                        System.out.println(Thread.currentThread().getName() + " completed withdrawl, Remaining balance : "+ amount);
                    }
                    else{
                        System.out.println("insufficient balance");
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                finally {
                    // always release the lock at finally block
                    lock.unlock();
                }
            }else{

                System.out.println(Thread.currentThread().getName() + "could not acquire the lock, so will try later");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
