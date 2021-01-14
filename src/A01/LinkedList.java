package A01;

public class LinkedList<T> implements List<T> {

    LLN first;
    LLN last;
    int elements;

    class LLN{
        T value;
        LLN next;

        public LLN(T value, LLN next){
            this.value = value;
            this.next= next;
        }

        @Override
        public String toString() {
            String rtn = ""+value;
            // return value+(next != null ? " "+next : "");
            if (next != null) {
                rtn += " " + next;
                return rtn; //value.toString()= ""+value
                 }
            else
                return rtn;
        }

    }

    @Override
    public void add(T value) {
        LLN lln = new LLN(value,null);
        if(first == null){
            first = last = lln;
        }
        else{
            last.next = lln;
            last = lln;
        }
        elements++;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= elements)
            throw new IndexOutOfBoundsException();
        T rtn;
        if (index == 0){
            rtn = first.value;
            first = first.next;
            if(first == null)//removed only element in list
                last= null;
        }else {
            LLN prior = getLLN(first, index-1);
            LLN target = prior.next;
            rtn = target.value;
            prior.next = target.next;
            if(prior.next == null)
                last = null;

        }

        elements--;
        return rtn;
    }

    @Override
    public int size() {
        return  elements;
    }
    private LLN getLLN(LLN start, int index){
        if (index == 0)
            return start;
        else
            return getLLN(start.next,index-1);
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= elements)
            throw new IndexOutOfBoundsException();
        return getLLN(first, index).value;
    }

    // PPT shows
    private LLN recursiveReversal(LLN oldFirst){
        if (oldFirst.next == null){
            return oldFirst;
        }else{
            LLN newPrior = oldFirst.next;
            LLN first = recursiveReversal(newPrior);
            newPrior.next = oldFirst;
            return first;
        }
    }


    @Override
    public void reverse() {
        if (first != null) {
            last = first;
            first = recursiveReversal(first);
            last.next= null;
        }

    }

    @Override // cannot make override less visible, so public is necessary here
    public String toString() {
        if (first == null)
            return "";
        return ""+first;
    }


}

