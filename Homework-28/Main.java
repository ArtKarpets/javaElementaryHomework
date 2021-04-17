import functionalInterface.Consumer;
import functionalInterface.Function;
import functionalInterface.Predicate;
import functionalInterface.Supplier;

public class Main {
    public static void main(String[] args) {
//Predicate
        Predicate<Double> predicateInterface = Double -> Double > 1500.0;
        System.out.println(predicateInterface.salary(2000.0));
//Consumer
        Consumer<String> consumerInterface = String -> {
            char[] array = String.toCharArray();
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        };
        consumerInterface.stringToArray("Hello");
//Function
        Function<Integer, String> functionInterface = Integer -> {
            String number;
            switch (Integer) {
                case (1):
                    number = "0ne";
                    break;
                case (2):
                    number = "Two";
                    break;
                case (3):
                    number = "Three";
                    break;
                case (4):
                    number = "Four";
                    break;
                case (5):
                    number = "Five";
                    break;
                case (6):
                    number = "Six";
                    break;
                case (7):
                    number = "Seven";
                    break;
                case (8):
                    number = "Eight";
                    break;
                case (9):
                    number = "Nine";
                    break;
                case (10):
                    number = "Ten";
                    break;
                default:
                    number = "Unknown";
            }
            return number;
        };
        System.out.println(functionInterface.intToString(5));
//Supplier
        Supplier<String> someString = () -> "I finished my homework and went to clean the apartment.";
        System.out.println(someString.someValue());
    }
}
