import deadlock.SomeDeadClassOne;
import deadlock.SomeDeadClassTwo;
import someClass.SomeCallable;
import someClass.SomeRunnable;
import someClass.SomeThread;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws Exception {

        SomeCallable somecallable = new SomeCallable();
        SomeRunnable someRunnable = new SomeRunnable();
        SomeThread someThread = new SomeThread();

        FutureTask<String> task = new FutureTask<String>(somecallable);
        Thread callable = new Thread(task);
        callable.start();
//        callable.join();

        Thread runnable = new Thread(someRunnable);
        runnable.start();
//        runnable.join();

        someThread.start();
//        someThread.join();

        System.out.println("result = " + task.get());
////        5.1 диапазон 2540-3000
////        5.2 диапазон 2000-3000
////        5.3 диапазон 3000-3000

        SomeDeadClassOne someDeadClassOne = new SomeDeadClassOne();
        SomeDeadClassTwo someDeadClassTwo = new SomeDeadClassTwo();

        someDeadClassOne.setSomeDeadClassTwo(someDeadClassTwo);
        someDeadClassTwo.setSomeDeadClassOne(someDeadClassOne);

        Thread threadOne = new Thread(() -> System.out.println(someDeadClassOne.someDeadMethod()));
        Thread threadTwo = new Thread(() -> System.out.println(someDeadClassTwo.someDeadMethod()));

        threadOne.start();
        threadTwo.start();
    }
}
