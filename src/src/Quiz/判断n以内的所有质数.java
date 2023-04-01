package Quiz;

import java.util.Scanner;

public class 判断n以内的所有质数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 2;i<n;i++){
            boolean flag = true;
            for(int j = 2;j<i;j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(i);
            }
        }
    }
}
