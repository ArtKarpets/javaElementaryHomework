package someInterface;

public interface NewInterface1 {

    default void defaultPrint(String string) {
        System.out.println(string);
    }

    static void staticPrint() {
        System.out.println("Some static method1");
    }

    void print();

    void anotherPrint();
}
