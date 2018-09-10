import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Run {
    public static void main(String[] args) {
       /*
        ArrayList<Student> list = new ArrayList<>();

        Person p = new Person("name", "2803962017", 1996);
        Person s = new Person("929292929", 12.0);
        Person t = new Person("course");

        Set<Integer> setList = new TreeSet<>();


        setList.add(7);
        setList.add(10);
        setList.add(12);
        setList.add(5);
        System.out.println(setList);
        p.setName("Alice");
        p.setCpr("2803962017");
        p.calcAge();

        */
        Person p = new Person("name", "2803962017", 1996);
        MyArrayList array = new MyArrayList();

        array.add("sd");
        System.out.println(array.size());
        System.out.println(array.get(0));

    }
}
