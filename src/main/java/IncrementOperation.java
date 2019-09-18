public class IncrementOperation implements Runnable{
    private int c = 0;
    private void increment(){
        c++;
        System.out.println(Thread.currentThread().getName() + " : " +c);
    }
    public void run() {
      this.increment();
    }
}
