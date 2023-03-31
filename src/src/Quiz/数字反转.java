package Quiz;

public class 数字反转 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }


    public static int reverse(int num){
        int reverse = 0;
        while(num != 0){
            int digital = num % 10;
            reverse = reverse * 10 + digital;
            num /= 10;
        }
        return reverse;
    }
}
