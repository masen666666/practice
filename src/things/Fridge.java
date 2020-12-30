package things;

public class Fridge extends Room {
    String location;
    int level;

    public Fridge(String name, int size, String location, int level){
        super(name, size);
        this.location = location;
        this.level=level;

    }

    @Override
    public String toString() { return super.toString()+" has a "+level+"levels fridge in "+location;}
}
