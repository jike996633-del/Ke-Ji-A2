// 程序入口类：含main方法和各Part演示方法
public class AssignmentTwo {
    // 程序入口
    public static void main(String[] args) {
        // 测试所有Part功能
        AssignmentTwo demo = new AssignmentTwo();
        demo.partThree();
        demo.partFourA();
        demo.partFourB();
        demo.partFive();
        demo.partSix();
        demo.partSeven();
    }

    // Part 3：等待队列演示（完善逻辑）
    public void partThree() {
        System.out.println("==================== Part 3 等待队列功能演示 ====================");
        // 1. 创建操作员
        Employee operator = new Employee("张三", 35, "13800138000", "EMP001", "过山车操作员");
        // 2. 创建骑乘对象
        Ride rollerCoaster = new Ride("过山车", 20, operator, 4);
        // 3. 创建5个游客
        Visitor v1 = new Visitor("李四", 22, "13900139000", "VIS001", true);
        Visitor v2 = new Visitor("王五", 18, "13700137000", "VIS002", false);
        Visitor v3 = new Visitor("赵六", 25, "13600136000", "VIS003", true);
        Visitor v4 = new Visitor("孙七", 30, "13500135000", "VIS004", false);
        Visitor v5 = new Visitor("周八", 28, "13400134000", "VIS005", true);
        // 4. 添加游客到队列
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        // 5. 打印初始队列
        System.out.println("\n添加5名游客后，队列详情：");
        rollerCoaster.printQueue();
        // 6. 移除1名游客
        rollerCoaster.removeVisitorFromQueue();
        // 7. 打印移除后的队列
        System.out.println("\n移除1名游客后，队列详情：");
        rollerCoaster.printQueue();
    }

    // Part 4A：骑乘历史演示（暂空，后续修改）
    public void partFourA() {}

    // Part 4B：历史排序演示（暂空，后续修改）
    public void partFourB() {}

    // Part 5：骑乘周期演示（暂空，后续修改）
    public void partFive() {}

    // Part 6：文件导出演示（暂空，后续修改）
    public void partSix() {}

    // Part 7：文件导入演示（暂空，后续修改）
    public void partSeven() {}
}