package O02;

public class Student extends Person { //super
    private String uid;

    public Student(int age, String name, String uid) {
        super(age, name); //from superclass Person
        this.uid = uid;
    }

    public String getUid() { return uid; }

    @Override
    public String toString() {
        return super.toString() + ", has uid "+uid;
    } // super.toString() a method from parent class


    public static void main(String[] args) {
        Person mary = new Student(19, "Mary", "u1234567");
        System.out.println(mary);
    }
}

