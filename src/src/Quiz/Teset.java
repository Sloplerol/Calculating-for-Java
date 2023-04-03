package Quiz;

public class Teset {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int minlength = 0;
        int sum = 0;
        //第一个for循环用来设置起始位置
        for(int i = 0;i<nums.length;i++){
            sum = 0;
            //第二个for循环用来设置终止位置
            for(int j = i;j<nums.length;j++){
                sum += nums[j];
                if(sum >= target){
                    minlength = j - i + 1;
                    result = Math.min(minlength,result);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}




