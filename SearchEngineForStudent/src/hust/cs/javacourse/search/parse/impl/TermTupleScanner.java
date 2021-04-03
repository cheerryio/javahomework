package hust.cs.javacourse.search.parse.impl;

import java.io.BufferedReader;
import java.util.Scanner;

import hust.cs.javacourse.search.index.AbstractTerm;
import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.index.impl.Term;
import hust.cs.javacourse.search.index.impl.TermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleScanner;

import hust.cs.javacourse.search.util.Config;

import java.util.regex.*;

public class TermTupleScanner extends AbstractTermTupleScanner {

    Pattern spliter = Pattern.compile(Config.STRING_SPLITTER_REGEX);
    int curcurpos = 0;

    /**
     * 缺省构造函数
     */
    public TermTupleScanner() {
        super();
    }

    /**
     * 构造函数
     *
     * @param input：指定输入流对象，应该关联到一个文本文件
     */
    public TermTupleScanner(BufferedReader input) {
        super(input);
    }

    /**
     * 获得下一个三元组
     *
     * @return: 下一个三元组；如果到了流的末尾，返回null
     */
    public AbstractTermTuple next() {
        try {
            int c = this.input.read();
            Matcher m = this.spliter.matcher(String.valueOf((char) c));
            String s = "";
            while (m.find()) {
                c = this.input.read();
                m = this.spliter.matcher(String.valueOf((char) c));
            }
            while (c != -1 && !m.find()) {
                s += (char) c;
                c = this.input.read();
                m = this.spliter.matcher(String.valueOf((char) c));
            }
            if (c == -1) {
                return null;
            }
            AbstractTerm term = new Term(s);
            AbstractTermTuple termTuple = new TermTuple(term, curcurpos++);
            return termTuple;
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }
}
