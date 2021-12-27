package interview;

import org.apache.logging.log4j.util.Strings;

import java.io.*;
import java.util.*;

//第一题
class MaYi1 {
    private volatile int index;

    MaYi1() {
    }

    public void print() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (index <= 100) {
                if ((index & 1) == 0) {
                    System.out.print(Thread.currentThread().getName() + " - " + index + " ");
                    index++;
                }
            }
        }, "Printer1");
        Thread thread2 = new Thread(() -> {
            while (index <= 100) {
                if ((index & 1) == 1) {
                    System.out.print(Thread.currentThread().getName() + " - " + index + " ");
                    index++;
                }
            }
        }, "Printer2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void main(String[] args) {
        try {
            new MaYi1().print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//第二题
class MaYi2 {
    public List<String> allChildStr(String str) {
        List<String> list = new LinkedList<>();
        if (Strings.isEmpty(str)) {
            return list;
        }
        traverse(list, str, "", 0);
        return list;
    }

    private void traverse(List<String> list, String str, String curStr, int loc) {
        if (loc == str.length()) {
            if (!Strings.isEmpty(curStr)) {
                list.add(curStr);
            }
            return;
        }
        traverse(list, str, curStr + str.charAt(loc), loc + 1);
        traverse(list, str, curStr, loc + 1);
    }

    public static void main(String[] args) {
        MaYi2 maYi = new MaYi2();
        for (String s : maYi.allChildStr("abc")) {
            System.out.println(s);
        }
    }
}


//第3题
class MaYi3 {
    private Queue<Integer> smallRootHeap;

    MaYi3() {
        smallRootHeap = new PriorityQueue<>(Integer::compare);
    }

    public Queue<Integer> GetMaxMNums(String filePath, int m) throws IOException {
        FileInputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new IOException("invalid filePath:" + filePath);
            }
            inputStream = new FileInputStream(file);
            streamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(streamReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (Strings.isEmpty(line)) {
                    break;
                }
                Arrays.stream(line.split(",")).filter(str -> !str.isEmpty()).forEach(s -> {
                    int num = Integer.parseInt(s);
                    addNum(num, m);
                });
            }

        } catch (IOException e) {
            //打印log
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (streamReader != null) {
                streamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return smallRootHeap;
    }

    private void addNum(int num, int capacity) {
        smallRootHeap.add(num);
        if (smallRootHeap.size() > capacity) {
            smallRootHeap.poll();
        }
    }

    //第4题
    public static void main(String[] args) throws IOException {
        MaYi3 maYi3 = new MaYi3();
        for (Integer num : maYi3.GetMaxMNums("/Users/bytedance/Desktop/learn/java-learn/src/main/java/a.txt", 2)) {
            System.out.println(num);
        }
    }
}

//第4题
class MaYi4 {
    private Stack<Integer> numStack;
    private Stack<Integer> minStack;

    MaYi4() {
        numStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void add(int num) {
        numStack.add(num);
        if (minStack.empty()) {
            minStack.add(num);
        } else {
            minStack.add(Math.min(num, minStack.peek()));
        }
    }

    public int pop() {
        if (!numStack.empty()) {
            minStack.pop();
            return numStack.pop();
        }
        throw new EmptyStackException();
    }

    public int getMin() {
        if (!numStack.empty()) {
            return minStack.peek();
        }
        throw new EmptyStackException();
    }


    //第4题
    public static void main(String[] args) {
        MaYi4 maYi = new MaYi4();
        maYi.add(3);
        maYi.add(1);
        System.out.println(maYi.getMin());//1
        maYi.add(2);
        maYi.add(5);
        maYi.add(0);
        System.out.println(maYi.getMin());//0
        maYi.pop();
        System.out.println(maYi.getMin());//1
    }
}