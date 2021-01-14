package A01;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ListTest {
    private static final boolean ARRAY = true;


    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmpty(){
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();
        l.get(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty(){
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();
        l.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOverflow(){
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();
        l.add("a");
        l.get(1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOverflow(){
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();
        l.add("a");
        l.remove(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetUnderflow(){
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();
        l.add("a");
        l.get(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveUnderflow(){
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();
        l.add("a");
        l.remove(-1);
    }

    @Test
    public void testAdd(){// implicitly testing size() and toString()
 // null list(155)
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();
        assertTrue(l.size()==0);
        l.add("a");
        assertTrue(l.size()==1);
        assertTrue(l.toString().equals("a"));
        l.add("bb");
        assertTrue(l.size()==2);
        assertTrue(l.toString().equals("a bb"));
        l.add("ccc");
        assertTrue(l.size()==3);
        assertTrue(l.toString().equals("a bb ccc"));

    }

    @Test
    public void testRemove(){// implicitly testing size() and toString() and add()
// remove non-existent element
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();

        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size()==3);
        assertTrue(l.toString().equals("a bb ccc"));
        String r = l.remove(1);
        assertTrue(r.equals("bb"));
        assertTrue(l.size()==2);
        assertTrue(l.toString().equals("a ccc"));
        r = l.remove(1);
        assertTrue(r.equals("ccc"));
        assertTrue(l.size()==1);
        assertTrue(l.toString().equals("a"));
        r = l.remove(0);
        assertTrue(r.equals("a"));
        assertTrue(l.size()==0);
        assertTrue(l.toString().equals(""));
    }
    @Test
    public void testGet(){
// out of bound (J15)
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();

        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size()==3);
        assertTrue(l.toString().equals("a bb ccc"));
        assertTrue(l.get(0).equals("a"));
        assertTrue(l.get(1).equals("bb"));
        assertTrue(l.get(2).equals("ccc"));
    }

    @Test
    public void testReverse() {
// empty, single
        List<String> l = ARRAY ? new ArrayList<>(): new LinkedList<>();

        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size()==3);
        assertTrue(l.toString().equals("a bb ccc"));
        l.reverse();
        assertTrue(l.toString().equals("ccc bb a"));
        l.reverse();
        assertTrue(l.toString().equals("a bb ccc"));
        l.remove(2);
        assertTrue(l.toString().equals("a bb"));
        l.reverse();
        assertTrue(l.toString().equals("bb a"));
        l.reverse();
        assertTrue(l.toString().equals("a bb"));
        l.remove(1);
        assertTrue(l.toString().equals("a"));
        l.reverse();
        assertTrue(l.toString().equals("a"));
        l.remove(0);
        assertTrue(l.toString().equals(""));
        l.reverse();
        assertTrue(l.toString().equals(""));



    }
}
