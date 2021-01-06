package lecture;

public class GenericLinkedList<T> {

    T value;
    GenericLinkedList next;

    GenericLinkedList(T value){
        this.value=value;
    }

    void add(T value){
        if (next==null){ // goog , we're at the end of the list, so can add another
            next = new GenericLinkedList(value);
        }
        else
            next.add(value);
    }

    @Override
    public String toString(){
        if (next == null)
            return value + "";
        else
            return value + ","+next;
    }



    public static void main(String[] args) {
        GenericLinkedList<Integer> ilist = new GenericLinkedList(5);

        ilist.add(3);
        ilist.add(3);
        ilist.add(3);
        ilist.add(3);

        GenericLinkedList<Double> dlist = new GenericLinkedList(5.0);

        dlist.add(3.0);
        dlist.add(3.1);
        dlist.add(3.2);

        GenericLinkedList<String> slist = new GenericLinkedList("hhaha");

        slist.add("hhaha");
        slist.add("hhaha");
        slist.add("hhaha");
        System.out.println("Here it is! "+ilist);
        System.out.println("Here it is! "+dlist);
        System.out.println("Here it is! "+slist);
    }

}
