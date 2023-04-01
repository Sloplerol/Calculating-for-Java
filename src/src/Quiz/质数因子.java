package Quiz;

import java.util.Scanner;

public class 质数因子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 2;i<=n;i++){
            if(n == 1){
                break;
            }
            if(n % i == 0){
                System.out.println(i);
                n /= i;
                i = i - 1;
            }

        }
    }
}
