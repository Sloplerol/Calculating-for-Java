package Quiz;

public class 摩尔投票法 {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,2,2,3};
        int result = MoerVoteWay(num);
        System.out.println(result);
    }


    public static int MoerVoteWay(int[] nums){
        int candidate = -1;
        int vote = 0;
        for(int num : nums){
            if(vote == 0){
                candidate = num;
            }
            if(candidate == num){
                vote++;
            }else {
                vote--;
            }

        }
        return candidate;
    }
}
