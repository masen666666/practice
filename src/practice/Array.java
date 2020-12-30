package practice;

public class Array {

    public static void main(String[] args) {
        //(n,m) 2D int array
//        int[][] a = new int [2][3];
//        int []c = {1,5,6,8,2};
//        int [] d = {3,2,4,5};
//        a[0]=c;
//        a[1]=d;
//        int row=1;
//        int column=1;
//        // print out a 2D array
//        for (int[] i : a) {
//            column=1;
//            for (int j : i) {
//                System.out.println("the number in "+row+"'s row "+column+"'s column is: "+j);
//                column++;
//            }
//            row++;
//        }
//    }
        //(n,m) 2D String array
        String[][] a=new String[2][];
        String[] c = {"wo","zai","zhe","li"};
        String[] d = {"ni","zai","na","li"};
        a[0]=c;
        a[1]=d;
        int row=1;
        int column=1;
        // print out a 2D array
        for (String[] i : a) {
            column=1;
            for (String j : i) {
                System.out.println("the String in "+row+"'s row "+column+"'s column is: "+j);
                column++;
            }
            row++;
        }
    }



}
