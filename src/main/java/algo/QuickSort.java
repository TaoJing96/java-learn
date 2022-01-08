package algo;

import java.util.Random;

public class QuickSort {

    private void sort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    public void quicksort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partitioner(nums, l, r);
        quicksort(nums, l, p - 1);
        quicksort(nums, p + 1, r);
    }

    private int partitioner(int[] nums, int l, int r) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        int rand = l;
        swap(nums, l, rand);
        int pivot = nums[l];
        int leftBound = l;
        while (l < r) {
            while (l < r && nums[r] > pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, leftBound, l);
        return l;
    }

    public static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {2, 3, 1, 0, 4, 1, 7, -1, 33};
//        int[] nums = {2, 1, 3, 0, 6};
        quickSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
