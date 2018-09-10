public class Person {
    private String name;
    private String cpr;
    protected int birthYear;
    private int age;
    private String studentNo;
    private double gradeAvg;
    private String title;



    //Constructor
    public Person(String name, String cpr, int birthYear){
        this.cpr = cpr;
        this.name = name;
        this.birthYear = birthYear;
    }

    public Person(String studentNo, double gradeAvg){
        this.studentNo = studentNo;
        this.gradeAvg = gradeAvg;
    }

    public Person(String title){
        this.title = title;
    }

    public Person(){
    }

    public String getName(){
        if(name == null || name.equals("")){
            name = "Name is not set";
        }
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void calcAge(){
        setAge(2018 - getBirthYear());
    }

    public double getGradeAvg() {
        return gradeAvg;
    }

    public void setGradeAvg(double gradeAvg) {
        this.gradeAvg = gradeAvg;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public double updateAvg(){
        setGradeAvg(gradeAvg);
        return gradeAvg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        return "<<" + getName() + ", " + getCpr() + ">>";
    }
}
