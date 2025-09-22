package F03_thread_Methods;

public class MyThread_03_typesOfThread extends Thread{
    String Name;
    public MyThread_03_typesOfThread(String name) {
        super(name); // Pass the name to the parent Thread class constructor
       //    this.Name = name; // You can still keep this for your own reference
    }
    @Override
    public void run(){
        while(true){
            System.out.println("hello");
        }
    }
    public static void main(String[] args) throws InterruptedException {

        // there are two types of threads
        //Type 01. User Thread -> that we create now (and main thread have to wait to complete its execution)
        //Type 02. Daemon Thread -> we cann change the type of user Thread as Daemon (and main thread don't wait to complete its execution, main thread can exit during its execution)
        MyThread_03_typesOfThread t2= new MyThread_03_typesOfThread("Demon");
        // 07. Daemon()
        t2.setDaemon(true);
        t2.start();
        // hello should be printed infinite times from the t2 thread but see the result, that means main method dont care about the cmpletion of daemon thread
        System.out.println("main thread exited");
    }
}
