package someClass;

import someStaticClass.SomeStaticClass;

public class SomeThread extends Thread {

    public void run() {
        Thread.currentThread().setName("Thread");
        for (int i = 0; i < 1000; i++) {
            SomeStaticClass.ThreadName(Thread.currentThread());
        }
    }
}
