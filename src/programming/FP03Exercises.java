package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP03Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        };
        int sum = numbers.stream().reduce(0, sumBinaryOperator2);
        System.out.println(sum);

        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);

        System.out.println(squaredNumbers);

        List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);

        System.out.println(cubedNumbers);

        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x -> x + x);

        System.out.println(doubledNumbers);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }
}
