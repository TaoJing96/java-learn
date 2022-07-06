package design_pattern.composition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingtao
 * @date 2022/7/6 8:29 PM
 */
public class Test {

    public static void main(String[] args) {
        Branch branch = new Branch();
        branch.name = "root";

        Branch branch1 = new Branch();
        branch1.name = "d1";

        Branch branch11 = new Branch();
        branch11.name = "d11";

        Branch branch2 = new Branch();
        branch2.name = "d2";

        Leaf leaf11 = new Leaf();
        leaf11.content = "f11";

        Leaf leaf111 = new Leaf();
        leaf111.content = "f111";

        Leaf leaf112 = new Leaf();
        leaf112.content = "f112";

        Leaf leaf21 = new Leaf();
        leaf21.content = "f21";

        branch.nodeList = Arrays.asList(branch1, branch2);
        branch1.nodeList = Arrays.asList(leaf11, branch11);
        branch11.nodeList = Arrays.asList(leaf111, leaf112);
        branch2.nodeList = Arrays.asList(leaf21);

        dfsNode(branch, 0);
    }

    public static void dfsNode(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        node.print();
        if (node instanceof Branch) {
            List<Node> nodeList = ((Branch) node).nodeList;
            for (Node n : nodeList) {
                dfsNode(n, depth + 1);
            }
        }
    }
}


//文件模型 文件夹or文件
abstract class Node {
    abstract void print();
}

class Branch extends Node {

    String name;
    List<Node> nodeList = new ArrayList<>();

    @Override
    void print() {
        System.out.println(name);
    }
}

class Leaf extends Node {

    String content;

    @Override
    void print() {
        System.out.println(content);
    }
}