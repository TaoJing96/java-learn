package design_pattern.observer.v1;

import java.util.Arrays;
import java.util.List;

/**
 * @author jingtao
 * @date 2022/7/6 5:18 PM
 */
public class Test {

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeup();
    }
}

class Child {
    private boolean cry;
    List<Observer> observerList = Arrays.asList(new Dog(), new Mum());

    public void wakeup() {
        cry = true;
        for (Observer observer : observerList) {
            observer.actionOnWakeup();
        }
    }
}

interface Observer {
    void actionOnWakeup();
}

class Dog implements Observer {

    @Override
    public void actionOnWakeup() {
        System.out.println("bark....");
    }
}

class Mum implements Observer {

    @Override
    public void actionOnWakeup() {
        System.out.println("feed....");
    }
}