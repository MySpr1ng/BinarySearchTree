package Tree.Comparat;

/**
 * Created by Spring on 16.12.2017.
 */
public class Person implements Comparable<Person>{

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return (this.getAge() > o.getAge() ? 1 : -1 );
    }

    public static void main(String[] args) {
        Person person = new Person(12,"first");
        Person person2 = new Person(14,"first");
        System.out.println(person.compareTo(person2));
    }

}
