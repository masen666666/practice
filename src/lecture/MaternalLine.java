package lecture;

import java.util.Scanner;

public class MaternalLine {

    static String maternalAncestor(int n){
        if (n == 1)
            return "mother";
        else
            return "mothers'"+maternalAncestor(n-1); // recursive, the function reverse itself

    }

    public static void main(String[] args) {
        System.out.println("Type the depth of the maternal line you want to see");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            System.out.println("Your "+n+"-degree maternal ancestor is your "+ maternalAncestor(n));
            System.out.println("Type the depth of the maternal line you want to see");
        }
    }
}
