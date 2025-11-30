// 骑乘接口：定义Ride类必须实现的方法
public interface RideInterface {
    // Part 3：队列相关方法
    void addVisitorToQueue(Visitor visitor); // 添加游客到等待队列
    void removeVisitorFromQueue();          // 移除队列首游客
    void printQueue();                      // 打印队列所有游客

    // Part 4：历史记录相关方法
    void addVisitorToHistory(Visitor visitor); // 添加游客到骑乘历史
    boolean checkVisitorFromHistory(Visitor visitor); // 检查游客是否在历史中
    int numberOfVisitors(); // 返回历史游客总数
    void printRideHistory(); // 打印骑乘历史

    // Part 5：骑乘周期方法
    void runOneCycle(); // 运行一次骑乘周期
}