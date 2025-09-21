package thread_Methods;

public class Code01 extends Thread{
    // 02 . run() write all the code and functions in this run function so that these codes can be recognised as different thread
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
        Code01 t1= new Code01();
        // 01 . start() to start the thread
        t1.start();

    }
}
