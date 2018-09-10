import java.util.ArrayList;

public class Teacher extends Person {
    ArrayList<String> classes = new ArrayList<>();
    private static int teacherCount;



    public ArrayList<String> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }

    @Override
    public void calcAge(){
        setAge(2018 - getBirthYear());
    }
    public String toString(){
        return "<<" + getCpr() + ", " + getName() + ", " + getTitle() + ">>";}

}


