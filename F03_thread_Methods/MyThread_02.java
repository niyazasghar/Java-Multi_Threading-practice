package F03_thread_Methods;

public class MyThread_02 extends Thread{
    String Name;
    public MyThread_02(String name) {
        super(name); // Pass the name to the parent Thread class constructor
       //    this.Name = name; // You can still keep this for your own reference
    }
    @Override
    public void run(){
        synchronized(this){
            try {
                wait(1000000);
                System.out.println("thread is running");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " thread is interrupted  and the error is: " + e);
            }
        }

        // 06. yeild() it tells the CPU that you can give chances to other thread also
        for(int i=0; i<5; i++){
            System.out.println(i);
            Thread.yield();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread_02 t1= new MyThread_02("low");
        t1.start();
        // 05. interrupt() this tells the thread to stop what you are doing
        t1.interrupt();
        // there are two types of threads
        //Type 01. User Thread -> that we create now (and main thread have to wait to complete its execution)
        //Type 02. Daemon Thread -> we cann change the type of user Thread as Daemon (and main thread don't wait to complete its execution, main thread can exit during its execution)

    }
}
