package F03_thread_Methods;

public class MyThread_01 extends Thread{
    // 02 . run() write all the code and functions in this run function so that these codes can be recognised as different thread
    String name;
    public MyThread_01(String name){
        this.name=name;
    }
    @Override

    public void run(){
        // 03. wait(n) this keeps the call for waiting to n milisecond
        try {
            wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MyThread_01 low= new MyThread_01("low");
        // 01 . start() to start the thread
        low.start();
        // similarly we can create multiple threads of same type with different name;
        // there is a function which give priority to these threads
        //04. setPriority()
        // by creating multiple thread we can assign priority to them
        MyThread_01 med= new MyThread_01("medium");
        MyThread_01 high= new MyThread_01("high");
        low.setPriority(Thread.MIN_PRIORITY);
        med.setPriority(Thread.NORM_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);
        // 05. interrupt() this tells the thread to stop what you are doing (in next code)(MyThread_02)
    }
}
