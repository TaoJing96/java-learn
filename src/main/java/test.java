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

    public void print() {
        ListNode node = this;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class test {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        Solution solution = new Solution();

    }
}

class Solution {
    private int ans;

    public int minCameraCover(TreeNode root) {
        ans = 0;
        int n = helper(root);
        if (n == 0) {
            ans++;
        }
        return ans;
    }

    //0表示没有覆盖，1表示被覆盖，2表示放摄像头
    private int helper(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        } else if (left == 1 && right == 1) {
            return 0;
        } else {
            //其余都是被覆盖
            return 1;
        }
    }
}
