package hust.cs.javacourse.search.index;

import hust.cs.javacourse.search.index.impl.Index;
import hust.cs.javacourse.search.index.impl.IndexBuilder;
import hust.cs.javacourse.search.index.impl.Document;
import hust.cs.javacourse.search.index.impl.DocumentBuilder;
import org.junit.jupiter.api.Test;

public class IndexBuilderTest {
    @Test
    void testIndexBuilder(){
        DocumentBuilder documentBuilder=new DocumentBuilder();
        IndexBuilder indexBuilder=new IndexBuilder(documentBuilder);
        AbstractIndex index= indexBuilder.buildIndex("text");
        System.out.println(index);
    }
}
