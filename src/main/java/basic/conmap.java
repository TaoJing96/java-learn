package basic;

import java.util.concurrent.ConcurrentHashMap;

public class conmap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
    }
}
