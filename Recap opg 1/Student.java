import java.util.ArrayList;

public class Student extends Person{
private static int studentCount;

    @Override
    public void calcAge(){
        setAge(2018 - getBirthYear());
    }

    public String toString(){
        return "<<" + getCpr() + ", " + getName() + ", " + getStudentNo() + ">>";}

        public void sCount() {
            ArrayList<String> studentCount = new ArrayList<>();
        }
    }