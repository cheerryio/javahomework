package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractDocument;
import hust.cs.javacourse.search.index.AbstractDocumentBuilder;
import hust.cs.javacourse.search.index.AbstractIndex;
import hust.cs.javacourse.search.index.AbstractIndexBuilder;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;

public class IndexBuilder extends AbstractIndexBuilder{
    public IndexBuilder(AbstractDocumentBuilder docBuilder){
        super(docBuilder);
    }

    /**
     * <pre>
     * 构建指定目录下的所有文本文件的倒排索引.
     *      需要遍历和解析目录下的每个文本文件, 得到对应的Document对象，再依次加入到索引，并将索引保存到文件.
     * @param rootDirectory ：指定目录
     * @return ：构建好的索引
     * </pre>
     */
    public AbstractIndex buildIndex(String rootDirectory){
        AbstractIndex index=new Index();

        File rootDir=new File(rootDirectory);
        if(rootDir.isDirectory()) {
            for (String s : rootDir.list()) {
                String path = Paths.get(rootDir.getAbsolutePath(), s).toString();
                File file = new File(path);
                AbstractDocument document = this.docBuilder.build(this.docId++, path, file);
                index.addDocument(document);
            }
        }
        return index;
    }
}
