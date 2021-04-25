package someClass;

import someStaticClass.SomeStaticClass;
import java.util.concurrent.Callable;

public class SomeCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.currentThread().setName("Callable");
        for (int i = 0; i < 1000; i++) {
            SomeStaticClass.ThreadName(Thread.currentThread());
        }
        return "Callable" + Thread.currentThread();
    }
}
