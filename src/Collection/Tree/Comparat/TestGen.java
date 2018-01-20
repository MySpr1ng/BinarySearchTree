package Collection.Tree.Comparat;



/**
 * Created by Spring on 19.12.2017.
 */
public class TestGen {

    private String name;
    private  int age;

    public TestGen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestGen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {


        TestGen testGen = new TestGen("name", 15);
        TestGen testGen2 = testGen;
        testGen = null;
        System.out.println(testGen);
        System.out.println(testGen2);
    }
}
