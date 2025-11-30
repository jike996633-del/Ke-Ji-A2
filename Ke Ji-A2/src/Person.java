// 抽象父类：存储人员通用属性，不可实例化
public abstract class Person {
    // 3个通用实例变量（姓名、年龄、联系方式）
    private String name;
    private int age;
    private String contact;

    // 默认构造器
    public Person() {}

    // 带参构造器（初始化所有通用变量）
    public Person(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    // 所有变量的getter和setter（必须完整）
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}