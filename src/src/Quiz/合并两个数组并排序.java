package Quiz;

import java.util.Arrays;

public class 合并两个数组并排序 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6};
        int i = 0;
        int j = 0;
        int[] result = new int[nums1.length + nums2.length];
        for (int k = 0; k < result.length; k ++) {
            if (i >= nums1.length) {
                result[k] = nums2[j];
                j ++;
            } else if (j >= nums2.length) {
                result[k] = nums1[i];
                i ++;
            } else if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                i ++;
            } else {
                result[k] = nums2[j];
                j ++;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
