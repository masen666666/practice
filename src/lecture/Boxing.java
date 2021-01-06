package lecture;

public class Boxing {
    // Number,integer,short ,float,etc
    //autoboxing
    //math
    public static void main(String[] args) {
        Integer a = new Integer(6); // explicitly boxing( intellij tell you don't have to do that)
        Integer b = 6;  // auto boxing

        int c= b; //auto unboxing

        if(a == b)  // a and b are two different boxes but with same thing in those boxes
            System.out.println("a ("+a+") == b ("+b+")");
        else
            System.out.println("a ("+a+") != b ("+b+")");

        if(a.equals(b))  // == means is this same thing  , equals referred to value
            System.out.println("a ("+a+") equals b ("+b+")");
        else
            System.out.println("a ("+a+") !equals ("+b+")");

        if(a == c)  // auto unboxing before comparison
            System.out.println("a ("+a+") == c ("+c+")");
        else
            System.out.println("a ("+a+") != c ("+c+")");

    }

}
