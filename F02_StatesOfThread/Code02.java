package F02_StatesOfThread;

public class Code02 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getState());
        // Runnable state is also used when a process is running or ready to run
        try {
            System.out.println(Thread.currentThread().getState());
            Thread.sleep(3000);
            // this make the thread to wait (WAITING STATE)
            System.out.println(Thread.currentThread().getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getState());

    }

    public static void main(String[] args) throws InterruptedException {
        Code02 t1= new Code02(); // NEW state
        System.out.println(Thread.currentThread().getState());
        t1.start(); // till now ot wont run but it is ready to run (RUNNABLE)
        System.out.println(Thread.currentThread().getState());
        // Runnable state is also used when a process is running or ready to run
        Thread.sleep(1000); // this make the thread to wait (WAITING STATE)
        System.out.println(Thread.currentThread().getState());
        //all the thread state info is printed for the main thread
        // now printing the states of t1 thread
        System.out.println(t1.getState());
        t1.join(); // because of this line main method waits for the complete execution of the t1 thread
        System.out.println(t1.getState());
        System.out.println(Thread.currentThread().getState());
    }
}
