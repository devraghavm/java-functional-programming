package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
/*        int sumOfSquares = numbers.stream()
                .map(number -> number * number)
                .reduce(0, (x,y) -> x+y);
        System.out.println(sumOfSquares);

        int sumOfCubes = numbers.stream()
                .map(number -> number * number * number)
                .reduce(0, (x,y) -> x+y);
        System.out.println(sumOfCubes);

        int sumOfOddNumbers = numbers.stream()
                .filter(number -> number % 2 != 0)
                .reduce(0, (x,y) -> x+y);
        System.out.println(sumOfOddNumbers);

        List<Integer> evenNumbers = evenNumberList(numbers);
        System.out.println(evenNumbers);*/

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Windows");

        List<Integer> lengthsOfCourses = courses.stream()
                                            .map(course -> course.length())
                                            .collect(Collectors.toList());
        System.out.println(lengthsOfCourses);

    }

    private static List<Integer> evenNumberList(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }
}
