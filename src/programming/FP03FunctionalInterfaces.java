package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;


public class FP03FunctionalInterfaces {
    /*
     boolean isEven(int x) {
        return x%2 == 0;
     }

     int squared(int x) {
        return x*x;
     }
     */
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

/*        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        // Story behind a Predicate creation
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };
        Function<Integer, Integer> squareFunction = x -> x * x;
        // Story behind a Function creation
        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };
        Consumer<Integer> sysoutConsumer = System.out::println;
        // Story behind a Consumer creation
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };
        numbers.stream()
                .filter(isEvenPredicate2)
                .map(squareFunction2)
                .forEach(sysoutConsumer2);*/

/*        // No input > return something
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        System.out.println(randomIntegerSupplier.get());*/

/*        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;

        System.out.println(unaryOperator.apply(10));*/

        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number<10 && str.length() > 5;
        };

        System.out.println(biPredicate.test(15, "Raghav"));

        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + " " + str;
        };

        System.out.println(biFunction.apply(15, "Raghav"));

        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept("Java", "is awesome!!!");

        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;

        System.out.println(intBinaryOperator.applyAsInt(10, 20));
    }
}
