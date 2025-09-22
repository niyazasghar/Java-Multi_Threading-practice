package F05_Lock_ReentrantLock.UseOfReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    // this is the demo to show why Reentrant is there in the ReentrantLock(), where one thread having a lock access another lock , and lock works here as counter
    private final  Lock lock = new ReentrantLock();
    public void outerClass(){
        try {
            lock.lock();
            System.out.println("in the outerClass");
            innerClass(); // calling another class where this thread will acquire another lock
        }
        finally
         {
            lock.unlock();// after the execution of try or catch,  and releasing the second lock,  it will release the first lock
        }
    }
    public void innerClass(){
        try {
            lock.lock();
            System.out.println("in the innerClass");
        }finally {
            lock.unlock(); // after the execution of try or catch, it will release the second lock
        }
    }
}
