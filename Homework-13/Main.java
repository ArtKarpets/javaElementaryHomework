package elementary13;

import elementary13.exception.StringFormatException;
import elementary13.utils.CheckHelper;
import elementary13.utils.StringHelper;

public class Main {

    public static void main(String[] args) throws StringFormatException {

        System.out.println(StringHelper.stringConversion("Artem", "Karpets".toCharArray()));
        System.out.println(CheckHelper.phoneNumber("+3809852658"));
        System.out.println(CheckHelper.mail("art@mail.com"));
        System.out.println(CheckHelper.DateOfBirth("12.12.1222"));

    }
}
