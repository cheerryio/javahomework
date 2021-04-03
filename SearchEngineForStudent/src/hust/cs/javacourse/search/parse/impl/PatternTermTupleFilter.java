package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;
import hust.cs.javacourse.search.util.Config;

import hust.cs.javacourse.search.parse.AbstractTermTupleFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTermTupleFilter extends AbstractTermTupleFilter{
    Pattern pattern=Pattern.compile(Config.TERM_FILTER_PATTERN);

    public PatternTermTupleFilter(AbstractTermTupleStream input) {
        super(input);
    }

    /**
     * 获得下一个三元组
     * @return: 下一个三元组；如果到了流的末尾，返回null
     */
    public AbstractTermTuple next(){
        java.util.function.Function<AbstractTermTuple,Boolean> filter=(termTuple)->{
            return !pattern.matcher(termTuple.term.getContent()).matches();
        };

        AbstractTermTuple termTuple = this.input.next();
        while(termTuple != null && filter.apply(termTuple)){
            termTuple=this.input.next();
        }
        return termTuple;
    }
}
