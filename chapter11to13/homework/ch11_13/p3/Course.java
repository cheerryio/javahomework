package homework.ch11_13.p3;

import java.util.ArrayList;
import java.util.List;

public class Course implements Cloneable {
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 选修课程的学生列表，保存在 ArrayList里
     */
    private List<Person> students=new ArrayList<Person>();
    /**
     * 课程的授课老师
     */
    private Person teacher;

    /**
     * 构造函数
     *
     * @param courseName
     * @param teacher
     */
    public Course(String courseName,Person teacher){
        this.courseName=courseName;
        this.teacher=teacher;
    }

    /**
     * 选修课程。 应该把选修的学生加入到学生列表里。注意同一个学生只能选修一次，内
     * 部的 ArrayList 里不能出现重复的学生
     *
     * @param s  选修课程的学生
     */
    public void register(Person s){
        if(!this.students.contains(s)){
            this.students.add(s);
        }
    }

    /**
     * 取消选修 应该把取消选修的学生从学生名单里删除
     *
     * @param s 取消选修的学生
     */
    public void unregister(Person s){
        this.students.remove(s);
    }

    public String getCourseName(){
        return this.courseName;
    }

    public List<Person> getStudents(){
        return this.students;
    }

    public Person getTeacher(){
        return this.teacher;
    }

    /**
     * 获取选修课程的学生总数
     *
     * @return
     */
    public int getNumberOfStudent(){
        return this.students.size();
    }

    @Override
    public String toString() {
        return "课程名称："+this.courseName+" 学生人数："+this.getNumberOfStudent()+"老师："+this.teacher;
    }

    /**
     * 当二个对象当二个对象所有数据成员的内容相等，返回 true。注意学生名单内容也要相等（元素
     * 个数相等，每个 List 里的每个对象在另外一个 List 里都有唯一的内容相等的元素，但次序可以不
     * 同）
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof Course){
            Course aobj=(Course)obj;
            if(this.courseName!=null && !this.courseName.equals(aobj.getCourseName())){
                return false;
            }
            if(this.teacher!=null && !this.teacher.equals(aobj.getTeacher())){
                return false;
            }
            if(!(this.getNumberOfStudent() == aobj.getNumberOfStudent()) || !this.students.containsAll(aobj.getStudents())){
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Course newObj=(Course)super.clone();
        newObj.courseName=new String(this.courseName);
        newObj.students=new ArrayList<Person>(this.students);
        newObj.teacher=(Person)this.teacher.clone();
        return newObj;
    }
}
