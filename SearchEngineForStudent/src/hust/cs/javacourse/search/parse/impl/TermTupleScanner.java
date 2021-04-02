package hust.cs.javacourse.search.parse.impl;

import java.io.BufferedReader;
import java.util.Scanner;

import hust.cs.javacourse.search.index.AbstractTerm;
import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.index.impl.Term;
import hust.cs.javacourse.search.index.impl.TermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleScanner;

public class TermTupleScanner extends AbstractTermTupleScanner{
    /**
     * 缺省构造函数
     */
    public TermTupleScanner(){
        super();
    }

    /**
     * 构造函数
     * @param input：指定输入流对象，应该关联到一个文本文件
     */
    public TermTupleScanner(BufferedReader input){
        super(input);
    }

    /**
     * 获得下一个三元组
     * @return: 下一个三元组；如果到了流的末尾，返回null
     */
    public AbstractTermTuple next(){
        try{
            int c=this.input.read();
            String s="";
            while(c=='\r' || c=='\n' || c==' '){
                c=this.input.read();
            }
            while(c!=-1 && c!=' ' && c!='\n' && c!='\r'){
                s+=(char)c;
                c=this.input.read();
            }
            if(c==-1){
                return null;
            }
            AbstractTerm term=new Term(s);
            AbstractTermTuple termTuple=new TermTuple(term,1);
            return termTuple;
        }catch(Exception e){
            System.out.println("error");
        }
        return null;
    }
}
