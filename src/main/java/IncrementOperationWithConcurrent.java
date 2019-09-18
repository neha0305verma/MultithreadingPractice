public class IncrementOperationWithConcurrent implements Runnable{
    int count=0;

    private void increment(){
        count++;
        System.out.println(Thread.currentThread().getName() + " : " +count);
    }
    public void run() {
        this.increment();
    }
}
