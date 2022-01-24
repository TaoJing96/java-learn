import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

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
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                ans = Math.max(ans, height[l] * (r - l));
                l++;
            } else {
                ans = Math.max(ans, height[r] * (r - l));
                r--;
            }
        }
        return ans;
    }
}