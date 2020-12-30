package practice;

import java.util.Random;

public class Number {
    public static void main(String[] args) {

        Random r = new Random();
        for(int i=0;i<10;i++)
            System.out.println(r.nextInt(11));
        //        Returns a pseudorandom, uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)
    }
}
