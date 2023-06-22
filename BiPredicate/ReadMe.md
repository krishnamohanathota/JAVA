## BiPredicate

- BiPredicate is a functional interface. It takes two arguments and returns a boolean.
- BiPredicate is useful when we want to compare two objects and return a boolean value based on the comparison.

### Example

```java

BiPredicate<Integer, Integer> biPredicate = (a, b) -> a > b;

System.out.println(biPredicate.test(2, 3)); // false

```

### Example

```java

public class Employee {

    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```

```java

public class EmployeePredicates {

    public static BiPredicate<Employee, Integer> isAgeGreaterThanGivenAge() {
        return (employee, age) -> employee.getAge() > age;
    }

    public static BiPredicate<Employee, String> isNameLongerThanGivenName() {
        return (employee, name) -> employee.getName().length() > name.length();
    }

}

```

```java

public class BiPredicateExample {

    public static void main(String[] args) {

        BiPredicate<Employee, Integer> isAgeGreaterThanGivenAge = EmployeePredicates.isAgeGreaterThanGivenAge();
        BiPredicate<Employee, String> isNameLongerThanGivenName = EmployeePredicates.isNameLongerThanGivenName();

        Employee employee = new Employee("Tom Jones", 45);

        System.out.println(isAgeGreaterThanGivenAge.and(isNameLongerThanGivenName).test(employee, 40)); // true

    }

}

```
