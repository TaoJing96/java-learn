package algo;

public class kmp {

    public static void main(String[] args) {
        System.out.println(new kmp().strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int[] nextArray = nextArray(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (nextArray[j] >= 0) {
                j = nextArray[j];
            } else {
                i++;
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }

    private int[] nextArray(String str) {
        if (str.length() == 1) {
            return new int[]{-1};
        }
        int[] arr = new int[str.length() + 1];
        arr[0] = -1;
        arr[1] = 0;
        int curJump = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(curJump) == str.charAt(i)) {
                arr[++i] = ++curJump;//这里是++i，有可能溢出（"aaa"），所以arr长度为str.length() + 1
            } else if (arr[curJump] >= 0) {
                curJump = arr[curJump];
            } else {
                i++;
            }
        }
        return arr;
    }
}
