package F05_Lock_ReentrantLock;



public class MyThread extends  Thread{
    private Bank_Debit bankDebit;
    public MyThread(Bank_Debit bankDebit){
        this.bankDebit=bankDebit;
    }
    @Override
    public void run() {
        bankDebit.debit(50);
    }
}
