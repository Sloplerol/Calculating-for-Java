package Quiz;

import java.util.Scanner;

public class 求PI值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = 0;
        double sum = 0;
        for(int i = 1;;i+=2){
            if(num == n){
                break;
            }
            sum += (Math.pow(-1,(i-1)) * (1.0 / i));
            num++;
        }
        System.out.printf("%.10f",sum * 4);

    }
}
