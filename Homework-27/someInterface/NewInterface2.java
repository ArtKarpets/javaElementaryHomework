package someInterface;

public interface NewInterface2 extends NewInterface1 {

    default void defaultPrint(String string) {
        System.out.println("another implementation " + string);
    }

    static void staticPrint() {
        System.out.println("Some static method2");
    }

    void print();

    void anotherPrint();
}
