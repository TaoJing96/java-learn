package design_pattern.singleton.lazy;

import design_pattern.singleton.hungry.HungrySingleton;

public class LazySingleton {
    private volatile static LazySingleton lazySingleton;//volatile保证线程可见
    private LazySingleton() {
    }

    public static LazySingleton GetSingleton() {
        if (lazySingleton== null) {
            synchronized (HungrySingleton.class) {
                if (lazySingleton== null) {//double check 防止高并发下重复初始化单例
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
