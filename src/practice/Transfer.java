package practice;

public class Transfer {
    public static void main(String[] args) {
        String aString = "123";
        System.out.println("aString: "+aString);
        System.out.println("aString+1: "+(aString+1));
        // String to Integer/Double
        int aInt = Integer.parseInt(aString);   // Double.parseDouble(string)
        System.out.println("aInt: "+aInt);
        System.out.println("aInt+1: "+(aInt+1));



        //String and char , char and int(ascii code)
        String sString = "asb23";
        char [] aAsc=sString.toCharArray();
        // shift
        char c= (char) (aAsc[0]+20); //  char+number=int--ascii code
        System.out.println("char aAsc[0]: "+aAsc[0]);
        System.out.println("aAsc[0] shift 20: "+c);

        // judge ascii code
        if(aAsc[0]==97)
            System.out.println("a is 97");

        // char array to String
        String aAscString = new String(aAsc);
        System.out.println("convert char array aAsc back to String: "+aAscString);

    }


}
