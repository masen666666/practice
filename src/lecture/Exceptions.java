package lecture;

import java.util.Date;

public class Exceptions {
    static void exceptionalMethod(){
        System.out.println("Start of method()");
        //int l = 3/0;
        try{
//            Date d = new Date(); //new Date();
            Date d = null; // will be failed
            System.out.println(d.toString());
            int i= 7/0; // for now this error will not be found by exception if there is only one catch
        }catch(NullPointerException e){
            System.out.println("Null pointer"+e);
        }catch (Exception e){
            System.out.println("Generic exception"+e);
        }finally {  // guarantee following code always being executed
            System.out.println("Finally");
        }

        System.out.println("End of method()");

    }

    public static void main(String[] args) {
        System.out.println("Start of main()");
        exceptionalMethod();
        System.out.println("End of main()");
    }
}
