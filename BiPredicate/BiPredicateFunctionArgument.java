//BiPredicate as a Function argument

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BiPredicateFunctionArgument {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Student#1", 10.0),
                new Student("Student#2", 9.0),
                new Student("Student#3", 8.0),
                new Student("Student#4", 7.0));

        // BiPredicate
        BiPredicate<Student, Double> filter = (student, score) -> student.getScore() > score;

        // Check if Student score is > 9.0
        Student student = new Student("MLRIT", 9.5);
        boolean result = filter.test(student, 9.0);
        System.out.println(result);

        // Sending BiPredicate as a parameter to a function

        // Filter students whose score is > 8.0
        List<Student> filteredStudents = filterStudents(students, filter, 8.0);
        System.out.println(filteredStudents);

        // Filter students whose score is 8.0
        filteredStudents = filterStudents(students, (s, score) -> s.getScore() == 8.0, 0.0);
        System.out.println(filteredStudents);

    }

    public static <T extends Student> List<T> filterStudents(List<T> studentsList,
            BiPredicate<Student, Double> biPredicate, Double score) {
        return studentsList.stream()
                .filter(x -> biPredicate.test(x, score))
                .collect(Collectors.toList());
    }

}

class Student {

    private String studentName;
    private Double score;

    public Student(String studentName, Double score) {
        this.studentName = studentName;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public Double getScore() {
        return score;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student [studentName=" + studentName + ", score=" + score + "]";
    }
}