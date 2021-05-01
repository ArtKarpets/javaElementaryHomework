package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SomeClass {
    static Lock lock = new ReentrantLock();

    public static void one() {
        lock.lock();
        System.out.println("one");
    }

    public static void two() {
        System.out.println("two");
    }

    public static void three() {
        System.out.println("three");
        lock.unlock();
    }
}
