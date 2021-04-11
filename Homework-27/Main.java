import someInterface.AnotherInterfaceImpl;
import someInterface.InterfaceImpl;
import someInterface.NewInterface1;
import someInterface.NewInterface2;
import someInterface.NewInterface3;
import someInterface.NewInterface4;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        NewInterface1.staticPrint();
        NewInterface2.staticPrint();
        NewInterface3.staticPrint();
        NewInterface4.staticPrint();

        InterfaceImpl interfaceImpl = new InterfaceImpl();
        interfaceImpl.defaultPrint("default print");
        interfaceImpl.print();
        interfaceImpl.anotherPrint();

        AnotherInterfaceImpl anotherInterface = new AnotherInterfaceImpl();
        anotherInterface.defaultPrint(5);
        anotherInterface.print();
        anotherInterface.anotherPrint();

        System.out.println(Helper.someMethodOptional("art@mail.com"));
        System.out.println(Helper.someMethodOptional(" "));
    }
}
