import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        long time1=0;
        long time2=0;
        for (int i = 0; i < 100; i++) {
            List<Person> personList = new ArrayList<>(1000);
            for (int j = 0; j < 1000; j++) {
                Person person = new Person();
                person.setName("张三" + j);
                person.setGrade(random.nextInt(10));
                personList.add(person);
            }
            long start = System.currentTimeMillis();
            Map<Integer, List<Person>> map1 = personList.stream().collect(Collectors.groupingBy(Person::getGrade));
            Map<Integer, String> map2 = new HashMap<>(16);
            map1.forEach((k, v) -> map2.put(k, v.stream().map(Person::getName).collect(Collectors.joining(","))));
            personList.forEach(person -> person.setNames(map2.get(person.getGrade())));
            long cost = System.currentTimeMillis()-start;
            System.out.println(i+":"+cost);
            time1+=cost;
        }

        for (int i = 0; i < 100; i++) {
            List<Person> personList = new ArrayList<>(1000);
            for (int j = 0; j < 1000; j++) {
                Person person = new Person();
                person.setName("张三" + j);
                person.setGrade(random.nextInt(10));
                personList.add(person);
            }
            long start = System.currentTimeMillis();
            personList.forEach(p -> p.setNames(
                    personList.stream().filter(p2 -> p.getGrade() == p2.getGrade()).map(Person::getName).collect(Collectors.joining(","))
            ));
            long cost = System.currentTimeMillis()-start;
            System.out.println(i+":"+cost);
            time2+=cost;

        }
        System.out.println(time1);
        System.out.println(time2);

    }


}

class Person {
    private String name;
    private int grade;
    private String names;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", names='" + names + '\'' +
                '}';
    }
}