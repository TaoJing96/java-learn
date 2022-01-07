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

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return root.val;
        }
        ans = root.val;
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        ans = Math.max(ans, leftSum + rightSum + root.val);
        return Math.max(Math.max(leftSum, rightSum) + root.val, 0);
    }
}
