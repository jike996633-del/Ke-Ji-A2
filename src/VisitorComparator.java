// 排序类：实现Comparator，按“年龄升序+快速通行证优先”排序
import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 第一条件：年龄升序（小年龄在前）
        if (v1.getAge() != v2.getAge()) {
            return v1.getAge() - v2.getAge();
        }
        // 第二条件：有快速通行证的在前（true > false，反转顺序）
        return Boolean.compare(v2.isHasFastPass(), v1.isHasFastPass());
    }
}