package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}
public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                    new Course("Spring", "Framework", 98, 20000),
                    new Course("Spring Boot", "Framework", 95, 25000),
                    new Course("API", "Microservices", 97, 10000),
                    new Course("Microservices", "Microservices", 96, 15000),
                    new Course("FullStack", "FullStack", 95, 18000),
                    new Course("AWS", "Cloud", 92, 30000),
                    new Course("Azure", "Cloud", 95, 25000),
                    new Course("Docker", "Cloud", 97, 30000),
                    new Course("Kubernetes", "Cloud", 99, 25000)
            );

        //allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGt95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGt90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLt90Predicate = course -> course.getReviewScore() < 90;
        System.out.println(courses.stream().allMatch(reviewScoreGt95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLt90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGt90Predicate));

        Comparator<Course> comparingByNoOfStudentsAsc = Comparator
                .comparingInt(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsDesc = Comparator
                .comparingInt(Course::getNoOfStudents)
                .reversed();
        Comparator<Course> comparingByNoOfStudentsAndReviewScore = Comparator
                .comparingInt(Course::getNoOfStudents)
                .thenComparingInt(Course::getReviewScore)
                .reversed();
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAsc)
                        .collect(Collectors.toList())
        );
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsDesc)
                        .collect(Collectors.toList())
        );
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndReviewScore)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndReviewScore)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndReviewScore)
                        .skip(3)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndReviewScore)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        System.out.println(courses);
        //[Spring:20000:98, Spring Boot:25000:95, API:10000:97, Microservices:15000:96, FullStack:18000:95, AWS:30000:92, Azure:25000:95, Docker:30000:97, Kubernetes:25000:99]

        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() >= 95)
                        .collect(Collectors.toList())
        );

        System.out.println(
                courses.stream()
                        .max(comparingByNoOfStudentsAndReviewScore)
        );

        System.out.println(
                courses.stream()
                        .min(comparingByNoOfStudentsAndReviewScore)
                        .orElse(new Course("Apache Kafka", "Framework", 98, 40000))
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreLt90Predicate)
                        .min(comparingByNoOfStudentsAndReviewScore)
                        .orElse(new Course("Apache Kafka", "Framework", 98, 40000))
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreLt90Predicate)
                        .findFirst()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt90Predicate)
                        .findFirst()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .findAny()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .sum()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .count()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .max()
        );

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .min()
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList())))
        );

        Predicate<Course> reviewScoreGt95Predicate2 = createPredicateWithCutoffReviewScore(95);
        Predicate<Course> reviewScoreGt90Predicate2 = createPredicateWithCutoffReviewScore(90);

        System.out.println(courses.stream().allMatch(reviewScoreGt95Predicate2));
        System.out.println(courses.stream().anyMatch(reviewScoreGt90Predicate2));
    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }
}
