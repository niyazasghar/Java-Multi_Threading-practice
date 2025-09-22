package F06_ReadWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWritter {
    public int count=0;
    // define a lock of type ReentrantReadWriteLock
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    // using that lock define read and write lock
    private final Lock writeLock =lock.writeLock();
    private final Lock readWriteLock = lock.readLock();

    public void increament(){
        writeLock.lock();
        try {
            count++;
            System.out.println("thread :  "+ Thread.currentThread().getName() + " increament of counter is done , count id = " + count);
        }finally {
            writeLock.unlock();
        }
    }
    public void retrieve(){
        readWriteLock.lock();
        try {
            System.out.println("thread :  "+ Thread.currentThread().getName() + "  gets the values of counter,  which is : " + count);
        }finally {
            readWriteLock.unlock();
        }
    }


}
