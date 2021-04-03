package hust.cs.javacourse.search.parse;

import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.parse.impl.TermTupleScanner;
import org.junit.jupiter.api.Test;

import hust.cs.javacourse.search.parse.impl.StopWordTermTupleFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StopWordTermTupleFilterTest {
    @Test
    void testTermTupleFilter(){
        String filePath="text/1.txt";
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
            AbstractTermTupleScanner termTupleScanner=new TermTupleScanner(reader);
            AbstractTermTupleFilter termTupleFilter=new StopWordTermTupleFilter(termTupleScanner);
            AbstractTermTuple termTuple =termTupleFilter.next();
            System.out.println(termTuple);
            termTuple =termTupleFilter.next();
            System.out.println(termTuple);
            termTuple =termTupleFilter.next();
            System.out.println(termTuple);
            termTuple =termTupleFilter.next();
            System.out.println(termTuple);
            termTuple =termTupleFilter.next();
            System.out.println(termTuple);
            termTuple =termTupleFilter.next();
            System.out.println(termTuple);
            termTuple =termTupleFilter.next();
            System.out.println(termTuple);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
