package lecture;


import O02.COMP1110Student;

import java.util.*;

public class ClassList {
    public static void main(String[] args) {
        COMP1110Student stuarray[] = {
                new COMP1110Student(19,"Mary",  "u1234567", 4, 15, 5, 4, 7, 60),
                new COMP1110Student(20,"Bob",  "u2345678", 3, 16, 5, 4, 6, 70),
                new COMP1110Student(21,"Ting",  "u3456789", 4, 15, 4, 5, 9, 85),
                new COMP1110Student(18,"Vijay",  "u4567890", 5, 13, 3, 4, 6, 75),
        };
        // array
        for (COMP1110Student student : stuarray){
            System.out.println("From array: "+student);

        }
        // List
        List<COMP1110Student> students = new ArrayList<>(Arrays.asList(stuarray));
        // Arrays.asList() method to create a list like existed array
        for (COMP1110Student student : students){
            System.out.println("From list: "+student);

        }

        //Map
        Map<String, COMP1110Student> uidmap = new HashMap<>(); // key: uid String   student is the value

        for (COMP1110Student student : stuarray){
            uidmap.put(student.getUid(), student);
        }

        String key ="u2345678";
        COMP1110Student value = uidmap.get(key);
        System.out.println("Found "+value);

        for (COMP1110Student student : uidmap.values()){
            //no order in map
            System.out.println("From map: "+student);
        }

        COMP1110Student sue= new COMP1110Student(19,"Sue",  "u4567891", 4, 15, 5, 4, 7, 60);
        uidmap.put("u45678901",sue);  // cannot contain two same key objects in map

        System.out.println("Added Sue");
        for (COMP1110Student student : uidmap.values()){
            //no order in map
            System.out.println("From map: "+student);
        }

        students.add(sue);
        Collections.sort(students);
        System.out.println("All students natural order");
        for (COMP1110Student student : students){
            System.out.println("From sorted list: "+student);
        }

        // lambda expression for Collections.sort
        Collections.sort(students, (COMP1110Student s1, COMP1110Student s2) -> {return s1.getUid().compareTo(s2.getUid());} );
        System.out.println("All students UID order");
        for (COMP1110Student student : students){
            System.out.println("From sorted list: "+student);
        }

        Collections.sort(students, (COMP1110Student s1, COMP1110Student s2) -> {return s1.mark() - (s2.mark());} );
        System.out.println("All students grade order");
        for (COMP1110Student student : students){
            System.out.println("From sorted list: "+student);
        }


    }
}
