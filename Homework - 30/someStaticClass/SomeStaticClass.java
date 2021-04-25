package someStaticClass;

public class SomeStaticClass {
    private static int increment;

    public static void ThreadName(Thread thread) {
//        synchronized (SomeStaticClass.class) {
        System.out.println(thread.getName() + increment++);
//        }
    }
}

