
import entity.Food;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //1
        Stream<Object> emptyStream = Stream.empty();
        emptyStream
                .limit(5)
                .sorted()
                .forEach(System.out::println);

        //2
        List<String> user = List.of("Anna", "Jack", "Ivan");
        user.stream()
                .filter(name -> name.length() < 5)
                .sorted()
                .collect(Collectors.toList());

        //3
        int[] num = new int[5];
        Arrays.stream(num)
                .boxed().collect(Collectors.toList());

        //4
        Map<Integer, String> housemates = new HashMap<>();
        housemates.put(1, "Anna");
        housemates.put(2, "Jack");
        housemates.put(3, "Ivan");
        Stream<Map.Entry<Integer, String>> mapStream = housemates.entrySet().stream();
        mapStream.collect(Collectors.toList()).forEach(System.out::println);

        //5
        List<String> stringsNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<Integer> numbers = stringsNumbers.stream()
                .skip(1)
                .limit(8)
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .distinct()
                .collect(Collectors.toList());

        //6
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream
                .parallel()
                .sorted()
                .filter(integer -> integer < 10)
                .findFirst();

        //7
        Food food = new Food("yummiFood");
        Stream.of("CHIcken,TOmato,Potato")
                .map(Food::new)
                .map(Food::getName)
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(ArrayList::new))
                .forEach(Food::howeDelicious);
    }

}
