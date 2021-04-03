package hust.cs.javacourse.search.index;

import hust.cs.javacourse.search.index.impl.Index;
import hust.cs.javacourse.search.index.impl.IndexBuilder;
import hust.cs.javacourse.search.index.impl.Document;
import hust.cs.javacourse.search.index.impl.DocumentBuilder;
import hust.cs.javacourse.search.util.Config;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexBuilderTest {

    @Test
    public void testIndexBuilder(){
        DocumentBuilder documentBuilder=new DocumentBuilder();
        IndexBuilder indexBuilder=new IndexBuilder(documentBuilder);
        AbstractIndex index= indexBuilder.buildIndex(Config.DOC_DIR);
        index.optimize();

        // 写到文件
        Path pathname= Paths.get(Config.INDEX_DIR,"index");
        try{
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(pathname.toString()));
            index.writeObject(out);
        }catch(Exception e){
            System.err.println(e);
            return;
        }

        //读入文件
        try{
            ObjectInputStream in=new ObjectInputStream((new FileInputStream(pathname.toString())));
            index=new Index();
            index.readObject(in);
        }catch (Exception e){
            System.err.println(e);
            return;
        }
        System.out.println(index);
    }
}
