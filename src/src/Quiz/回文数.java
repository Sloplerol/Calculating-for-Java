package Quiz;

public class 回文数 {
    public static void main(String[] args) {
        System.out.println(isReverse(121));
    }


    public static boolean isReverse(int num){
        int reverse = 0;
        int origin = num;
        while(num > 0){
            int digital = num % 10;
            reverse = reverse * 10 + digital;
            num /= 10;
        }
        return reverse == origin;
    }
}
