import java.util.concurrent.atomic.AtomicInteger;

public class NumberCounter implements Runnable{

    private AtomicInteger number = new AtomicInteger(0);

    @Override
    public void run() {
        while(true) {
            synchronized(number) {
                int actualValue = number.getAndIncrement();
                if(actualValue < 51){
                    System.err.println(Thread.currentThread().getName() + ": " + actualValue);
                } else break;
            }
            for(long i=0;i<1000000;i++){

            }
        }
    }

    public static void main(String[] args) {
        NumberCounter mt = new NumberCounter();
        Thread thread1 = new Thread(mt);
        thread1.setName("vlakno 1");
        Thread thread2 = new Thread(mt);
        thread2.setName("vlakno 2");
        Thread thread3 = new Thread(mt);
        thread3.setName("vlakno 3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
