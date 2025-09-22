package F06_ReadWriteLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ReaderWritter readerWritter = new ReaderWritter();

        Runnable Readertask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    readerWritter.retrieve();
                }

            }
        };
        Runnable Writtertask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    readerWritter.increament();
                }
            }
        };
        Thread t1= new Thread(Readertask);
        Thread.sleep(1000);
        Thread t3= new Thread(Readertask);
        Thread.sleep(1000);
        Thread t2= new Thread(Writtertask);

        t3.start();
        t1.start();
        t2.start();


        t1.join();
        t2.join();
        t3.join();



    }

}
