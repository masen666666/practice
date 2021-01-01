package practice;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
//        String username = in.next();
//        System.out.println("Hi "+username+"!");
//
//        String a= in.next();
//        String b= in.next();
//        System.out.println("in.next: "+a+b);
        String c= in.nextLine();
        String d= in.nextLine();
        System.out.println("nextLine: "+c+d);
//        int a=0;
//
//        System.out.println("nextLine: "+c);



    }
    public static void Communicate(){
        Scanner in= new Scanner(System.in);
        String username = in.next();
        System.out.println("Hi "+username+"!");
    }
}
