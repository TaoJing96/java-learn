package jvm;

import java.util.ArrayList;

/**
 * @author jingtao
 * @date 2022/7/20 21:15
 */
public class GcDetail {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<>();
        while (true) {
            int[] ints = new int[10000];
            int[] ints2 = new int[10000];
            objects.add(ints);
            Thread.sleep(19);
        }
    }
}
