// 游客类：继承Person，存储游客专属属性
public class Visitor extends Person {
    // 2个专属变量（游客ID、是否有快速通行证）
    private String visitorId;
    private boolean hasFastPass;

    // 默认构造器
    public Visitor() {}

    // 带参构造器（含父类变量）
    public Visitor(String name, int age, String contact, String visitorId, boolean hasFastPass) {
        super(name, age, contact);
        this.visitorId = visitorId;
        this.hasFastPass = hasFastPass;
    }

    // 所有专属变量的getter和setter
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public boolean isHasFastPass() {
        return hasFastPass;
    }

    public void setHasFastPass(boolean hasFastPass) {
        this.hasFastPass = hasFastPass;
    }

    // 重写toString()：方便打印游客详情
    @Override
    public String toString() {
        return "Visitor{ID='" + visitorId + "', 姓名='" + getName() + "', 年龄=" + getAge() +
                ", 联系方式='" + getContact() + "', 快速通行证=" + hasFastPass + "}";
    }
}