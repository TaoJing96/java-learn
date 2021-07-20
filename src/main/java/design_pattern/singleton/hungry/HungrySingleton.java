package design_pattern.singleton.hungry;

public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton() {
    }

    public static HungrySingleton GetSingleton() {
        return hungrySingleton;
    }
}
