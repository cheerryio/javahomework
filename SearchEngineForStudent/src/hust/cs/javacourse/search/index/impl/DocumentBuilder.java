package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractDocument;
import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.index.impl.Document;
import hust.cs.javacourse.search.index.impl.Term;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;
import hust.cs.javacourse.search.index.AbstractDocumentBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class DocumentBuilder extends AbstractDocumentBuilder{
    /**
     * <pre>
     * 由解析文本文档得到的TermTupleStream,构造Document对象.
     * @param docId             : 文档id
     * @param docPath           : 文档绝对路径
     * @param termTupleStream   : 文档对应的TermTupleStream
     * @return ：Document对象
     * </pre>
     */
    public AbstractDocument build(int docId, String docPath, AbstractTermTupleStream termTupleStream){
        return new Document();
    }

    /**
     * <pre>
     * 由给定的File,构造Document对象.
     * 该方法利用输入参数file构造出AbstractTermTupleStream子类对象后,内部调用
     *      AbstractDocument build(int docId, String docPath, AbstractTermTupleStream termTupleStream)
     * @param docId     : 文档id
     * @param docPath   : 文档绝对路径
     * @param file      : 文档对应File对象
     * @return          : Document对象
     * </pre>
     */
    public AbstractDocument build(int docId, String docPath, File file){
        List<AbstractTermTuple> tuples=new ArrayList<AbstractTermTuple>();

        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNext()){
                String word=scanner.next();
                Term term=new Term(word);
                TermTuple termTuple=new TermTuple(term,4);
                tuples.add(termTuple);
            }
        }catch(FileNotFoundException e){
            System.out.println("error");
        }
        return new Document(docId,docPath,tuples);
    }
}
