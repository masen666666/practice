package things;

public class Room {
    String name;
    double size;
    public Room(String name,double size){
        this.name = name;
        this.size = size;
    }

    public static void main(String[] args) {
        Room num1 = new Room("LivingRoom",30);
        Room num2 = new Room("kitchen",15);
        Meat lamb = new Meat("kitchen",15,"corner",3,2);
        Vege potato = new Vege("kitchen",15,"corner",2,5);
        System.out.println(num1);
        System.out.println(lamb);
        lamb.weight-=1;
        lamb.expire-=1;
        System.out.println(lamb+(lamb.isThatProtein()? " ":"don't")+"contain protein");
        System.out.println(potato+(potato.isThatProtein()? " ":"don't ")+"contain protein");

    }

    @Override
    public String toString(){return "Room "+name+" is "+size+" square meter";}
}
