// 员工类：继承Person，存储员工专属属性
public class Employee extends Person {
    // 2个专属变量（员工ID、负责岗位）
    private String employeeId;
    private String position;

    // 默认构造器
    public Employee() {}

    // 带参构造器（含父类变量）
    public Employee(String name, int age, String contact, String employeeId, String position) {
        super(name, age, contact); // 调用父类构造器
        this.employeeId = employeeId;
        this.position = position;
    }

    // 所有专属变量的getter和setter
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}