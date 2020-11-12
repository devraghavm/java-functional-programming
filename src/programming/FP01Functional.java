package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args)
    {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //printAllNumbersInListFunctional(numbers);
        //printEvenNumbersInListFunctional(numbers);
        //printOddNumbersInListFunctional(numbers);
        //printSquaresOfEvenNumbersInListFunctional(numbers);
        printCubesOdOddNumbersInListFunctional(numbers);
    }

/*    private static void print(int number) {
        System.out.println(number);
    }*/
/*    private static  boolean isEven(int number) {
        return number%2 == 0;
    }*/
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //What to do
        numbers.stream()
                .forEach(System.out::println);//Method Reference
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //What to do
        numbers.stream()
                //.filter(FP01Functional::isEven)//Filter - Only allow even numbers
                .filter(number -> number%2 == 0)//Lambda Expression
                .forEach(System.out::println);//Method Reference
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        //What to do
        numbers.stream()
                //.filter(FP01Functional::isEven)//Filter - Only allow even numbers
                .filter(number -> number%2 == 0)//Lambda Expression
                .map(number -> number * number)//mapping - x -> x * x
                .forEach(System.out::println);//Method Reference
    }


    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        //What to do
        numbers.stream()
                //.filter(FP01Functional::isEven)//Filter - Only allow even numbers
                .filter(number -> number%2 != 0)//Lambda Expression
                .forEach(System.out::println);//Method Reference
    }

    private static void printCubesOdOddNumbersInListFunctional(List<Integer> numbers) {
        //What to do
        numbers.stream()
                //.filter(FP01Functional::isEven)//Filter - Only allow even numbers
                .filter(number -> number%2 != 0)//Lambda Expression
                .map(number -> number * number * number)
                .forEach(System.out::println);//Method Reference
    }
}
