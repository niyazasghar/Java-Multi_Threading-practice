package F04_Synchronisation;

public class Counter {
    int count=0;
    // if this counter function will be called by multiple thread concurrently then there might be case of race condition and
    // this will become  critical section to avoid this what i do is Use Synchronize Keyeword for this function
//    public void increment(){
//        count++;
//    }
//     see the result first without synchronised and then using synchronised
    // USE of synchronized
    public synchronized void  increment(){
        count++;
    }
    // there is other use of synchronized also ( above use implies to every thing in the increment function , but if you want to apply this in a particular block them that is also possible
    public int getCount(){
        return count;
    }

}
