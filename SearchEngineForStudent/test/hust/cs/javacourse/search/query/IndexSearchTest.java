package hust.cs.javacourse.search.query;

import hust.cs.javacourse.search.index.AbstractTerm;
import hust.cs.javacourse.search.index.impl.Index;
import hust.cs.javacourse.search.index.impl.Term;
import hust.cs.javacourse.search.query.impl.FreqSort;
import hust.cs.javacourse.search.query.impl.NullSort;
import hust.cs.javacourse.search.util.Config;
import org.junit.jupiter.api.Test;
import hust.cs.javacourse.search.query.AbstractIndexSearcher;
import hust.cs.javacourse.search.query.impl.IndexSearcher;
import hust.cs.javacourse.search.index.IndexBuilderTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;

import java.nio.file.Paths;

/**
 * IndexSearch测试类
 */
public class IndexSearchTest {
    @Test
    void testIndexSearch() {
        new IndexBuilderTest().testIndexBuilder();
        IndexSearcher indexSearcher = new IndexSearcher();
        Path pathname = Paths.get(Config.INDEX_DIR, "index");
        indexSearcher.open(pathname.toString());
        AbstractTerm term1 = new Term("doer");
        AbstractTerm term2 = new Term("cares");

        Sort sorter;
        AbstractHit[] hits;

//        sorter = new NullSort();
//        hits = indexSearcher.search(term1, sorter);

        sorter = new FreqSort();
        hits = indexSearcher.search(term1, term2, sorter, AbstractIndexSearcher.LogicalCombination.ANDNEIGHBOR);
        if(hits!=null){
            for (AbstractHit hit : hits) {
                System.out.println(hit + " " + hit.getScore() + "分" + " 路径: " + hit.getDocPath());
            }
        }
    }
}
