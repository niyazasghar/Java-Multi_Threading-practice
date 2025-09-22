package F05_Lock_ReentrantLock;



public class Test {
    public static void main(String[] args) {
        // Previously (F04) section was there to understand the actual use of synchronized keyword(to prevent critical section)
        // there is a critical section created at the counter class, by two thread, we were using synchronised keyword
        // to prevent critical section , but i you observe it allows one thread at a time(baari baari se threads enter ho rahe the),
        // which causes the longer time wait for the another thread.
        // so Lock is implemented so that manual locking can be implemented.
        // here we can implement a logic like : (upto what time the second thread can wait for the C S to get free)

        Bank_Debit bankDebit= new Bank_Debit();
        MyThread t1= new MyThread(bankDebit);
        MyThread t2= new MyThread(bankDebit);
        t1.start();
        t2.start();

        System.out.println(bankDebit.amount);
    }
}
