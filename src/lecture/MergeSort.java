package lecture;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MergeSort {
    public static List<Integer> mergesort(List<Integer> unsorted){
        if(unsorted == null || unsorted.size() <= 1)
            return unsorted;

        int size = unsorted.size();
        List<Integer> uleft = unsorted.subList(0, size/2);
        List<Integer> uright = unsorted.subList(size/2,size);

        List<Integer> sleft = mergesort(uleft);
        List<Integer> sright = mergesort(uright);

        List<Integer> result = new ArrayList<>();
        int l = 0;
        int r = 0;

        while (l< sleft.size() || r< sright.size() ){
            if (r< sright.size()&&( l== sleft.size() || sright.get(r) <= sleft.get(l))){
                result.add(sright.get(r));
                r++;
            }
            else{
                result.add(sleft.get(l));
                l++;

            }

        }


        return result;

    }
    @Test
    public void testSort(){
        Integer [] single = {8};
        assertTrue("Not sorted",Arrays.asList(single).equals(mergesort(Arrays.asList(single))));
        Integer[] unsorted = {11,6,8,10,21,3};
        Integer[] sorted = {3,6,8,10,11,21};
        assertTrue("Not sorted",Arrays.asList(sorted).equals(mergesort(Arrays.asList(unsorted))));

    }



}
