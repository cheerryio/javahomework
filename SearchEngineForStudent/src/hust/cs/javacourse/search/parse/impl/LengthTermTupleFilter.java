package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;
import hust.cs.javacourse.search.parse.AbstractTermTupleFilter;
import hust.cs.javacourse.search.util.Config;

public class LengthTermTupleFilter extends AbstractTermTupleFilter{


    public LengthTermTupleFilter(AbstractTermTupleStream input) {
        super(input);
    }

    /**
     * 获得下一个三元组
     * @return: 下一个三元组；如果到了流的末尾，返回null
     */
    public AbstractTermTuple next(){
        java.util.function.Function<AbstractTermTuple,Boolean> filter=(termTuple)->{
            int l=termTuple.term.getContent().length();
            if(l< Config.TERM_FILTER_MINLENGTH || l>Config.TERM_FILTER_MAXLENGTH){
                return true;
            }
            return false;
        };

        AbstractTermTuple termTuple = this.input.next();
        while(termTuple != null && filter.apply(termTuple)){
            termTuple=this.input.next();
        }
        return termTuple;
    }
}
