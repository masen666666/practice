package lecture;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Boggle {
// sixteen dice
    static String[] dice = {"AJBBOO","AFFPSK","ANEAGE","APSHCO","QNUMHI","ZNHRLN","TDSTYI","TTWOOA","TLRYET","TUMIOC","EDVLRY","EDRLXI","EEGNHW","EIOTSS","ERHTWV","EENUSI"};

    static List<Set<Integer>> neighbours =new ArrayList<>(dice.length);

    static{ // if you want a piece of code to run when the class is loaded, should mark it static
        int [] distance = {-5,-4,-3,-1,1,3,4,5};
        for (int i = 0; i < 16; i++){
            Set<Integer> die = new HashSet<>();//create a empty Hashset

            for(int d: distance){
                int n = i + d;
                int ncol = n % 4; // neighbour
                int icol = i % 4; // core
                if ( n >= 0 && n< 15 && Math.abs(ncol - icol)<= 1)
                    die.add(n);
            }
            neighbours.add(die);
        }
    }

    static char [] shake() {

        char[] result = new char[16];
        Random rand = new Random(2); // convenient for debug. same random result
        for (int i = 0; i < dice.length; i++) {
            int die = rand.nextInt(dice.length); // a random integer between 0-15
            while (dice[die] == null) {  // each dice can be chosen only once
                die = (die + 1) % dice.length;
            }
            //which face up
            int face = rand.nextInt(6);
            char value = dice[die].charAt(face);
            dice[die] = null;
            result[i]=value;
//            System.out.print(value);  // print next to the last one
//            if(i%rowlength == (rowlength-1))
//                System.out.println(); // print new line
        }
        return result;
    }

    static void printBoggle(char[] boggle){
        int rowlength = (int) Math.sqrt(dice.length);

        for(int i = 0; i < dice.length; i++){
            System.out.print(boggle[i]);  // print next to the last one
            if(i%rowlength == (rowlength-1))
                System.out.println(); // print new line
        }
    }

    static boolean bogglable(String word, char[] boggle){
        if (word.length() < 3 || word.length() > 16) return false;

        List<Character> usable = new ArrayList<>();
        for(int i = 0 ; i < boggle.length; i++)
            usable.add(boggle[i]);

        for (int i= 0; i< word.length(); i++){
            char l= word.charAt(i);
            if (usable.contains(l))
                usable.remove(usable.indexOf(l)); // where is l , then move it
            else
                return false;
        }
        return true;
    }

    static void readWords(String filename, Set<String> words,Set<String> prefixes, char[] boggle){
        int wordCount = 0;
        try{
            Scanner s = new Scanner(new File(filename));
            // read stuff from the file
            while (s.hasNext()){
                String word = s.next().toUpperCase() ;
                wordCount++;
                if(bogglable(word,boggle)){
                    words.add(word);
                    for(int i = 0; i < word.length(); i++){
                        prefixes.add(word.substring(0,i));
                    }
                }

            }

        }   catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Read in "+wordCount+" words, making a word set of size "+words.size()+" and "+prefixes.size()+" prefixes");

    }

    static void findWords(Set<String> bogglewords, Set<String> words, Set<String>prefixes, boolean[] used, char[] boggle,
                         int start, String prefix){
        used[start] = true;

        String candidate = prefix+boggle[start];
        if (candidate.length() >= 3 && words.contains(candidate))  // found a valid word
            bogglewords.add(candidate);
        if(prefixes.contains(candidate)){ //try to get another longer word
            for (int n : neighbours.get(start)){
                if( !used[n])
                    findWords(bogglewords,words,prefixes,used,boggle,n,candidate);

            }
        }



        used[start] = false;
    }

    static List<String> solveBoggle(char[] boggle){
        Set<String> words = new HashSet<>();
        Set<String> prefixes = new HashSet<>();

        //        Set<String> prefixes = new HashSet<>();

        boolean[] used = new boolean[dice.length];
        Set<String> boggleWords = new HashSet<>();

        readWords("resources/words/dictionary.txt",words,prefixes,boggle);

        for (int i=0; i< dice.length; i++)
            findWords(boggleWords,words,prefixes, used, boggle, i,"");

        return new ArrayList<>(boggleWords);  // convert a set into the list
    }



    @Test
    public void testNeighbours(){
        for (int i = 0; i < 16 ; i++){
            assertFalse("included self in neighbours ", neighbours.get(i).contains(i) );
            assertFalse("included self in neighbours ", neighbours.get(i).contains(-i) );
            assertFalse("included self in neighbours ", neighbours.get(i).contains(16) );

        }
        assertTrue("Did not include 0 in neighbours", neighbours.get(1).contains(0));
        assertTrue("Did not include 2 in neighbours", neighbours.get(1).contains(2));
        assertTrue("Did not include 4 in neighbours", neighbours.get(1).contains(4));
        assertTrue("Did not include 5 in neighbours", neighbours.get(1).contains(5));
        assertTrue("Did not include 6 in neighbours", neighbours.get(1).contains(6));

    }

    @Test
    public void testBoggle(){
        char [] dice = {'R','H','R','E','Y','P','C','S','W','N','S','N','T','E','G','O'};
        List<String> result= solveBoggle(dice);
        assertTrue("Did not contain PRESS", result.contains("PRESS"));
        assertTrue("Did not contain GENT", result.contains("PRESS"));
        assertTrue("Did not contain PRY", result.contains("PRESS"));
        assertTrue("Did not contain IRE", result.contains("PRESS"));
        assertTrue("Did not contain CENTRE", result.contains("PRESS"));
        assertTrue("Did not contain RESPECT", result.contains("PRESS"));
        assertTrue("Did not contain PRESENT", result.contains("PRESS"));
        assertTrue("Did not contain RHETORIC", result.contains("PRESS"));

    }


    public static void main(String[] args) {
        char[] boggle = shake();
        printBoggle(boggle);

        //record time
        long start = System.currentTimeMillis();
        List<String> solution= solveBoggle(boggle);
        long duration = System.currentTimeMillis()-start;

        System.out.println("N "+neighbours.size());

        System.out.println("Found "+solution.size()+" words in "+duration+" msec! ");

        Collections.sort(solution,(String s1, String s2)->{
            if(s1.length() == s2.length())
                return s1.compareTo(s2);
            else
                return s2.length() - s1.length();
        });

        for (String w : solution )
            System.out.println(w);

        }

    }




