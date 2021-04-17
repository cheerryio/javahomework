package homework.ch11_13.p3;

public class Student extends Person implements Cloneable {
    /**
     * 学生Id
     */
    private int studentId;
    /**
     *
     */
    private String department;
    /**
     * 所在班级
     */
    private String classNo;

    /**
     * 缺省构造函数
     */
    public Student() {

    }

    /**
     * 构造函数
     *
     * @param name       姓名
     * @param age        年龄
     * @param studentId  学号
     * @param department 所在院系
     * @param classNo    所在班级
     */
    public Student(String name, int age, int studentId, String department, String classNo) {
        super(name, age);
        this.studentId = studentId;
        this.department = department;
        this.classNo = classNo;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getClassNo() {
        return this.classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    @Override
    public String toString() {
        return super.toString() + "学号：" + this.studentId + " 部门：" + this.department + " 班级：" + this.classNo + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student aobj = (Student) obj;
            if(!super.equals(aobj)){
                return false;
            }
            if(this.department!=null && !this.department.equals(aobj.getDepartment())){
                return false;
            }
            if(this.classNo!=null && !this.classNo.equals(aobj.getClassNo())){
                return false;
            }
            return this.studentId==aobj.getStudentId();
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student newObj=(Student)(super.clone());
        if(this.department!=null){
            newObj.setDepartment(new String(this.department));
        }
        if(this.classNo!=null){
            newObj.setClassNo(new String(this.classNo));
        }
        return newObj;
    }
}
