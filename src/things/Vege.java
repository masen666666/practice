package things;

public class Vege extends Fridge implements Quality{
    public static void main(String[] args) {

    }

    int expire;
    int weight;

    public Vege(String name, int size, String location, int level,int weight){
        super(name, size, location, level);
        this.expire=2;
        this.weight=weight;


    }

    @Override
    public String toString(){
        return super.toString()+". There are "+weight+"kg vegs expiring in "+expire+" days.";
    }
    @Override
    public boolean isThatProtein() {
        return false;
    }
}
