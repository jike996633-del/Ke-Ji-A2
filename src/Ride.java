// 核心骑乘类：实现RideInterface，管理骑乘逻辑
public class Ride implements RideInterface {
    // Part 1要求：3个实例变量（含1个Employee类型）
    private String rideName;    // 骑乘名称（例：过山车）
    private int maxCapacity;    // 骑乘总容量
    private Employee operator;  // 操作员（必须为Employee类型）

    // Part 3要求：等待队列（存储等待游客，FIFO）
    private java.util.Queue<Visitor> waitingQueue;

    // Part 4要求：骑乘历史（存储已乘坐游客）
    private java.util.List<Visitor> rideHistory;

    // Part 5要求：周期相关变量
    private int maxRider;       // 每周期最大游客数
    private int numOfCycles;    // 已运行周期数（默认0）

    // 默认构造器：初始化队列和历史集合
    public Ride() {
        this.waitingQueue = new java.util.LinkedList<>();
        this.rideHistory = new java.util.LinkedList<>();
        this.numOfCycles = 0; // 初始周期数为0
    }

    // 带参构造器：初始化所有变量
    public Ride(String rideName, int maxCapacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.operator = operator;
        this.maxRider = maxRider;
        this.waitingQueue = new java.util.LinkedList<>();
        this.rideHistory = new java.util.LinkedList<>();
        this.numOfCycles = 0;
    }

    // 所有变量的getter和setter
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    // -------------------------- 接口方法实现（完善所有Part 3-5方法）--------------------------
    // Part 3：队列方法（已完善）
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.offer(visitor);
            System.out.println("✅ 成功添加游客" + visitor.getVisitorId() + "到【" + rideName + "】等待队列");
        } else {
            System.out.println("❌ 添加失败：游客信息为空");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingQueue.isEmpty()) {
            Visitor removed = waitingQueue.poll();
            System.out.println("✅ 成功从【" + rideName + "】队列移除游客" + removed.getVisitorId());
        } else {
            System.out.println("❌ 移除失败：【" + rideName + "】等待队列为空");
        }
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("【" + rideName + "】等待队列为空");
            return;
        }
        System.out.println("【" + rideName + "】等待队列（共" + waitingQueue.size() + "人）：");
        int index = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(index + ". " + visitor.toString());
            index++;
        }
    }

    // Part 4A：历史记录方法（已完善）
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("✅ 游客" + visitor.getVisitorId() + "已添加到【" + rideName + "】骑乘历史");
        } else {
            System.out.println("❌ 添加历史失败：游客信息为空");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("❌ 检查失败：游客信息为空");
            return false;
        }
        for (Visitor v : rideHistory) {
            if (v.getVisitorId().equals(visitor.getVisitorId())) {
                System.out.println("✅ 游客" + visitor.getVisitorId() + "存在于【" + rideName + "】骑乘历史");
                return true;
            }
        }
        System.out.println("❌ 游客" + visitor.getVisitorId() + "不存在于【" + rideName + "】骑乘历史");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("【" + rideName + "】骑乘历史共" + count + "名游客");
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("【" + rideName + "】骑乘历史为空");
            return;
        }
        System.out.println("【" + rideName + "】骑乘历史（共" + rideHistory.size() + "人）：");
        java.util.Iterator<Visitor> iterator = rideHistory.iterator(); // 必须用Iterator
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index + ". " + visitor.toString());
            index++;
        }
    }

    // Part 5：骑乘周期方法（完善逻辑）
    @Override
    public void runOneCycle() {
        System.out.println("\n==================== 【" + rideName + "】运行骑乘周期 ====================");
        // 1. 检查是否有操作员
        if (operator == null) {
            System.out.println("❌ 运行失败：未分配操作员");
            return;
        }
        // 2. 检查等待队列是否为空
        if (waitingQueue.isEmpty()) {
            System.out.println("❌ 运行失败：等待队列为空");
            return;
        }
        // 3. 计算本次周期可搭载游客数（不超过maxRider和队列长度）
        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        System.out.println("✅ 本次周期可搭载" + ridersThisCycle + "名游客（每周期最大" + maxRider + "人）");
        // 4. 从队列移除并添加到历史
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = waitingQueue.poll();
            addVisitorToHistory(visitor); // 复用已有方法
        }
        // 5. 周期数+1
        numOfCycles++;
        System.out.println("✅ 【" + rideName + "】第" + numOfCycles + "周期运行完成");
    }

    // Part 4B：排序方法（已完善）
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("❌ 排序失败：【" + rideName + "】骑乘历史为空");
            return;
        }
        java.util.Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("✅ 【" + rideName + "】骑乘历史排序完成（按年龄升序+快速通行证优先）");
    }

    // Part 6：文件导出方法（暂空，后续修改）
    public void exportRideHistory(String filePath) {}

    // Part 7：文件导入方法（暂空，后续修改）
    public void importRideHistory(String filePath) {}
}