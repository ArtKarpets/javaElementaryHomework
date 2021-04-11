package someInterface;

public interface NewInterface3 {

    default void defaultPrint(int number) {
        System.out.println(number);
    }

    static void staticPrint() {
        System.out.println("Some static method3");
    }

    void print();

    void anotherPrint();
}
