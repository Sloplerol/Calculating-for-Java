package Quiz;

import java.util.Scanner;

public class 求e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n != 0){
            double sum = 0;
            double factorial = 1;
            for(int i = 0;i <= n;i++){
                sum += i / factorial;
                //每一次的阶乘相当于是上一次取得的阶乘(i + 1);
                factorial *= (i + 1);
            }
            System.out.printf("%.2f\n",sum);
            n = scanner.nextInt();

        }


    }
}
