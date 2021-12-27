package basic;

public class threadlocal {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(2);
        threadLocal.get();
    }
}
