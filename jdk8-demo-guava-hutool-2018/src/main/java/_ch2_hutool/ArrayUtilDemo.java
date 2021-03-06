package _ch2_hutool;


import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.util.ArrayUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;


public class ArrayUtilDemo {

    public static void main(String[] args) {

        // 判空
        int[] a = {1, 2};
        int[] b = null;
        Console.log(
                "{} {} {} {} {} {}",
                ArrayUtil.isEmpty(a),
                ArrayUtil.isNotEmpty(a),
                ArrayUtil.join(a, "-"),
                ArrayUtil.isEmpty(b),
                ArrayUtil.isArray(b), // false
                ArrayUtil.contains(a, 10)
        );

        String[] objects = ArrayUtil.newArray(String.class, 2);
        Console.log(objects);
    }


    @Test
    public void cloneDemo () {
        // 克隆
        Integer[] c = {1, 2, 3};
        Integer[] cloneC = ArrayUtil.clone(c);
//        Console.log(cloneC);
        Assert.assertArrayEquals(c, cloneC);
    }

    @Test
    public void cloneDemo2 () {
        int[] c1 = {1, 2, 3};
        int[] clone = ArrayUtil.clone(c1);
        Assert.assertArrayEquals(c1, clone);
    }

    @Test
    public void filterDemo () {
        Integer[] d = {1, 2, 3, 4, 5, 6};
        Integer[] filter = ArrayUtil.filter(d, new Editor<Integer>() {
            @Override
            public Integer edit(Integer t) {
                return (t % 2 == 0) ? t : null;
            }
        });
        Console.log(filter);
        Assert.assertArrayEquals(filter, new Integer[]{2, 4, 6});

    }

    @Test
    public void zip () {
        String[] keys = {"a", "b", "c"};
        Integer[] values = {1, 2, 3};
        Map<String, Integer> map = ArrayUtil.zip(keys, values, true);
        Console.log(map);
    }

}
