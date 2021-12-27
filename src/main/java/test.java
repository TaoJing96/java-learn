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

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        TreeNode treeNode = solution.sortedListToBST(n1);
        System.out.println(treeNode);
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode midNode = splitListNode(head, tail);
        TreeNode node = new TreeNode(midNode.val);
        node.left = helper(head, midNode);
        node.right = helper(midNode.next, tail);
        return node;
    }

    private ListNode splitListNode(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode.next != tail && fastNode.next.next != tail) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }
}
