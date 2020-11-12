package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

/*
        List<Integer> squaredNumbers = squaredList(numbers);

        System.out.println(squaredNumbers);
*/

/*        int sum = addListUsingFunctional(numbers);

        System.out.println(sum);*/
    }

    private static List<Integer> squaredList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber) {
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListUsingFunctional(List<Integer> numbers) {
        //stream of numbers -> One result value
        //combine them into single result
        //start with 0 and FP02Functional::sum
        return numbers.stream()
//        .reduce(0, FP02Functional::sum);
//        .reduce(0, (x,y) -> x + y);
        .reduce(0, Integer::sum);
    }

    private static int addListUsingStructured(List<Integer> numbers) {
        //how to loop
        //how to store the sum
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

}
