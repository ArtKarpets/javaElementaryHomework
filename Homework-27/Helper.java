
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public static Object someMethodOptional(String someString) throws IOException {
        Pattern pat = Pattern.compile("[a-zA-z][@mail.com]");
        Matcher mat = pat.matcher(someString);
        if (!mat.find() && someString.isBlank()) {
            return Optional.empty().orElseThrow(IOException::new);
        }
        return Optional.of(someString);
    }
}

