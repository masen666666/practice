package practice;

import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        String a= "a";
        String b= "b";
        String z;
        String k;
        Scanner in = new Scanner(System.in);
        z=in.next();
        k=z;
        if (k.equals(a))
            System.out.println(" input  equals a");
        if (k==a)
            System.out.println(" input  = b");
    }


}
