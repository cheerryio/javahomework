package hust.cs.javacourse.search.index.impl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.List;
import hust.cs.javacourse.search.index.AbstractPosting;
/**
 * <pre>
 * AbstractPosting是Posting对象的抽象父类.
 *      Posting对象代表倒排索引里每一项， 一个Posting对象包括:
 *          包含单词的文档id.
 *          单词在文档里出现的次数.
 *          单词在文档里出现的位置列表（位置下标不是以字符为编号，而是以单词为单位进行编号.
 *      必须实现下面二个接口:
 *          Comparable：可比较大小（按照docId大小排序）,
 *                      当检索词为二个单词时，需要求这二个单词对应的PostingList的交集,
 *                      如果每个PostingList按docId从小到大排序，可以提高求交集的效率.
 *          FileSerializable：可序列化到文件或从文件反序列化
 *  </pre>
 */
public class Posting extends AbstractPosting{
    /**
     * 判断二个Posting内容是否相同
     * @param obj ：要比较的另外一个Posting
     * @return 如果内容相等返回true，否则返回false
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        Posting t=(Posting) obj;
        return this.docId==t.docId && this.freq==t.freq && this.positions.equals(t.positions);
    }

    /**
     * 返回Posting的字符串表示
     * @return 字符串
     */
    @Override
    public String toString(){
        return new String("posting字符串表示");
    }

    /**
     * 返回包含单词的文档id
     * @return ：文档id
     */
    @Override
    public int getDocId(){
        return this.docId;
    }

    /**
     * 设置包含单词的文档id
     * @param docId：包含单词的文档id
     */
    @Override
    public void setDocId(int docId){
        this.docId=docId;
    }

    /**
     * 返回单词在文档里出现的次数
     * @return ：出现次数
     */
    @Override
    public int getFreq(){
        return this.freq;
    }

    /**
     * 设置单词在文档里出现的次数
     * @param freq:单词在文档里出现的次数
     */
    @Override
    public void setFreq(int freq){
        this.freq=freq;
    }

    /**
     * 返回单词在文档里出现的位置列表
     * @return ：位置列表
     */
    @Override
    public List<Integer> getPositions(){
        return this.positions;
    }

    /**
     * 设置单词在文档里出现的位置列表
     * @param positions：单词在文档里出现的位置列表
     */
    @Override
    public void setPositions(List<Integer> positions){
        if(positions == null)
            return;
        this.positions=positions;
    }

    /**
     * 比较二个Posting对象的大小（根据docId）
     * @param o： 另一个Posting对象
     * @return ：二个Posting对象的docId的差值
     */
    @Override
    public int compareTo(hust.cs.javacourse.search.index.AbstractPosting o){
        return this.docId;
    }

    /**
     * 对内部positions从小到大排序
     */
    @Override
    public void sort(){
        this.positions.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    /**
     * 写到二进制文件
     *
     * @param out :输出流对象
     */
    @Override
    public void writeObject(ObjectOutputStream out){
    }

    /**
     * 从二进制文件读
     *
     * @param in ：输入流对象
     */
    @Override
    public void readObject(ObjectInputStream in) {

    }
}
