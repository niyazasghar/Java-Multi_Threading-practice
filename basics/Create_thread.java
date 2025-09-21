package basics;
//public class Create_thread extends Thread {
//    @Override
//    public void run() {
//        for ( ;  ;){
//            System.out.println("thread");
//        }
//
//    }
//}

public class Create_thread implements Runnable {
    @Override
    public void run() {
        for ( ;  ;){
            System.out.println("thread");
        }
    }
}