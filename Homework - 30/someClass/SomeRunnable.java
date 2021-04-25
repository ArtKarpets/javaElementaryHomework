package someClass;

import someStaticClass.SomeStaticClass;

public class SomeRunnable implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName("Runnable");
        for (int i = 0; i < 1000; i++) {
            SomeStaticClass.ThreadName(Thread.currentThread());
        }
    }
}
