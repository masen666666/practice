package lecture;

import java.util.Random;

public class Boggle {
// sixteen dice
    static String[] dice = {"AJBBOO","AFFPSK","ANEAGE","APSHCO","QNUMHI","ZNHRLN","TDSTYI","TTWOOA","TLRYET","TUMIOC","EDVLRY","EDRLXI","EEGNHW","EIOTSS","ERHTWV","EENUSI"};

    //which dice
    public static void main(String[] args) {
        Random rand = new Random();
        int rowlength = (int) Math.sqrt(dice.length);

        for (int i = 0 ; i < dice.length; i++){
            int die = rand.nextInt(dice.length); // a random integer between 0-15
            while(dice[die] == null ){  // each dice can be chosen only once
                die = (die + 1) % dice.length;
            }
            //which face up
            int face = rand.nextInt(6);
            char value= dice [die].charAt(face);
            dice[die]=null;
            System.out.print(value);  // print next to the last one
            if(i%rowlength == (rowlength-1))
                System.out.println(); // print new line

        }



    }



}
