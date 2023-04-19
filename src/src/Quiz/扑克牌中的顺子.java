package Quiz;

import java.util.Arrays;

public class 扑克牌中的顺子 {
    public static void main(String[] args) {
        int[] nums = {11,8,12,8,10};
        System.out.println(isStraight(nums));
    }
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        int filledWithZero = 0;
        int temp = nums[1] - nums[0];
        for(int i : nums){
            if(i == 0){
                zero++;
            }
        }

        if(zero == 0){
            for(int i = 2;i < nums.length;i++){
                if(nums[i] - nums[i - 1] != temp){
                    return false;
                }

            }
            return true;
        }
        for(int i = zero + 1;i < nums.length;i++){
            //获取到后面数的最小差值
            filledWithZero += (nums[i] - nums[i - 1] - 1);
        }

        return filledWithZero == zero;


    }
}
