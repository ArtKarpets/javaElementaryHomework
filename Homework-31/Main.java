import lock.SomeClass;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Thread.currentThread().setName("first");
                Decrement.decrement(Thread.currentThread());
            }

        });
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Thread.currentThread().setName("second");
                Decrement.decrement(Thread.currentThread());
            }
        });
        thread2.start();
        thread2.join();

        //Lock
        Thread threadLock = new Thread(new Runnable() {
            @Override
            public void run() {
                SomeClass.one();
                SomeClass.two();
                SomeClass.three();
            }
        });
        threadLock.start();

        Thread threadLock1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SomeClass.one();
                SomeClass.two();
                SomeClass.three();
            }
        });
        threadLock1.start();

        Thread threadLock2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SomeClass.one();
                SomeClass.two();
                SomeClass.three();
            }
        });
        threadLock2.start();
    }
}
