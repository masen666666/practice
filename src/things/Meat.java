package things;

public class Meat extends Fridge implements Quality {
    int expire;
    int weight;

    public Meat(String name, int size, String location, int level,int weight){
        super(name, size, location, level);
        this.expire=3;
        this.weight=weight;


    }

    @Override
    public String toString(){
        return super.toString()+". There are "+weight+"kg meats expiring in "+expire+" days.";
    }

    @Override
    public boolean isThatProtein() {
        return true;
    }
}
