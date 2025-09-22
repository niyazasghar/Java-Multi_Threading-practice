package F01_basics;

public class code1 {
    public static void main(String[] args) {
        System.out.println("hello world");
        // here only one thread runs : which is main thread
        System.out.println("name of current thred : "   + Thread.currentThread().getName());
        // create instance of Threaded class (which is created by extending Thread Class)
        /*

        Create_thread c= new Create_thread();
        c.start();
        */
        // second method is when thread is created by implementing the Runnable interface
        //for this method create obj of thred class, then create obj of thread passing the obj of thread class, then start it

        Create_thread c = new Create_thread();
        Thread thread= new Thread(c);
        thread.start();
        for ( ;  ;){
            System.out.println("main");
        }
    }
}
