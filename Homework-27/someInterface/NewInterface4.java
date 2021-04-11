package someInterface;

public interface NewInterface4 extends NewInterface3 {

    default void defaultPrint(int number) {
        System.out.println("another implementation " + number);
    }

    static void staticPrint() {
        System.out.println("Some static method4");
    }

    void print();

    void anotherPrint();
}
