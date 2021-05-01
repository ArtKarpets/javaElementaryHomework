import java.util.concurrent.atomic.AtomicInteger;

public class Decrement {
    private static AtomicInteger atomicInteger = new AtomicInteger(200);

    public synchronized static void decrement(Thread thread) {
        atomicInteger.decrementAndGet();
        System.out.println(atomicInteger + thread.getName());
    }
}
