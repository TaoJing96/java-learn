package design_pattern.observer.v2;

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

abstract class EventObject<T> {
    //事件源对象
    abstract T getSource();
}

class CryEvent extends EventObject<Child> {

    String loc;
    long time;
    Child child;

    @Override
    public Child getSource() {
        return child;
    }

    public String getLoc() {
        return loc;
    }
}

class Child {
    private boolean cry;
    List<Observer> observerList = Arrays.asList(new Dog(), new Mum());

    public void wakeup() {
        cry = true;
        CryEvent cryEvent = new CryEvent();
        cryEvent.loc = "bed";
        for (Observer observer : observerList) {
            observer.actionOnEvent(cryEvent);
        }
    }
}

interface Observer {
    void actionOnEvent(CryEvent cryEvent);
}

class Dog implements Observer {

    @Override
    public void actionOnEvent(CryEvent cryEvent) {
        System.out.println("bark....");
    }
}

class Mum implements Observer {

    @Override
    public void actionOnEvent(CryEvent cryEvent) {
        if (cryEvent.getLoc() == "bed") {
            System.out.println("hug...");
        } else {
            System.out.println("feed....");
        }
    }
}