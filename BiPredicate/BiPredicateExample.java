import java.util.function.BiPredicate;

public class BiPredicateExample {

    public static void main(String[] args) {

        BiPredicate<String, Integer> filter = (x, y) -> x.length() == y;

        Boolean result = filter.test("krishna", 7);
        System.out.println(result);

        result = filter.test("madhavi", 4);
        System.out.println(result);

    }

}
