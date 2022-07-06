import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

public class test {
}

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.jump(new int[]{2,3,1,1,4});
    }

    public int jump(int[] nums) {
        int maxLoc = 0; //本次次能跳跃的最远位置
        int step = 0;
        int end = 0;//上次能跳跃的最远位置
        for (int i = 0; i < nums.length; i++) {
            maxLoc = Math.max(i + nums[i], maxLoc);
            if (i == end) {
                //达到上次的最远点 需要再跳一次
                if (i != nums.length - 1) {
                    step++; //最后一个位置不需要再跳
                }
                end = maxLoc;
            }
        }
        return step - 1;
    }
}