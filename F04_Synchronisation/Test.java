package F04_Synchronisation;

public class Test {
    public static void main(String[] args) {
        // this section is to understand the actual use of synchronized keyword(to prevent critical section)
        // there is a critical section created at the counter class, by two thread
        // both threads are updating the count variable of same class
        Counter counter= new Counter();
        MyThread t1= new MyThread(counter);
        MyThread t2= new MyThread(counter);
        t1.start();
        t2.start();
        try {
            // let both the thread complete
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(counter.getCount());
    }
}
