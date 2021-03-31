package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;

public class TermTuple extends AbstractTermTuple {
    /**
     * 判断二个三元组内容是否相同
     * @param obj ：要比较的另外一个三元组
     * @return 如果内容相等（三个属性内容都相等）返回true，否则返回false
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        TermTuple t=(TermTuple)obj;
        return this.term.equals(t.term) && this.freq == t.freq && this.curPos == t.curPos;
    }

    /**
     * 获得三元组的字符串表示
     * @return ： 三元组的字符串表示
     */
    @Override
    public String toString(){
        return new String("termTuple字符串表示");
    }
}
