package _ch2_guava;

import cn.hutool.core.lang.Console;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetDemo {
    public static void main(String[] args) {
        Multiset<String> set = LinkedHashMultiset.create();
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("b");
        set.add("b");
        set.setCount("a", 5);

        Console.log("a的个数 -> {} \nset -> {} \nset.size -> {} \nset的元素个数 -> {}", set.count("a"), set, set.size(), set.elementSet().size());
        set.clear(); //清空集合
        Console.log(set);

    }
}

