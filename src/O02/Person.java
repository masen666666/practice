package O02;

public class Person implements Comparable<Person> { // Comparable<> interface
    private int age; // an instance field
    private String name;

    public Person(int age, String name) {  //constructor
        this.age = age;  //this refer to this instance field in line 4  , equal to the parameter age
        this.name = name;
    }

    public static void main(String[] args) {

        Person mary = new Person(22, "Mary");
        Person fred = new Person(19, "Fred");
        System.out.println("I created a person: "+mary);
        System.out.println("I created a person: "+fred);
        System.out.println(mary.compareTo(fred));

    }

    @Override
    public String toString() {
        return name + " is aged " + age;
    }

    @Override // compared with java language
    public int compareTo(Person other) {
        if (age == other.age)
            return name.compareTo(other.name);
        return age - other.age;
    }
}
