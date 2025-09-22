package F05_Lock_ReentrantLock.UseOfReentrantLock;

import F04_Synchronisation.MyThread;

public class Test {
    public static void main(String[] args) {
        ReentrantExample reentrantExample= new ReentrantExample();
        Runnable task= new Runnable() {
            @Override
            public void run() {
                reentrantExample.outerClass();
            }
        };
        // this is the anonymous class that is built (without creating new class of name MyThread and extending Thread into it)
        // ie. this is the shortcut of implementation
        Thread t1= new Thread(task, "reentrantExample");
        t1.start();
    }
}
