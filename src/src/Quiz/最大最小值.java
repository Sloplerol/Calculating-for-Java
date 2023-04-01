package Quiz;

import java.util.Scanner;

public class 最大最小值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = -10000;
        int min = 99999;
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            if(n == 0){
                break;
            }
            if(n > 0 && n < min){
                min = n;
            }else if(n < 0 && n > max) {
                max = n;
            }

        }
        System.out.printf("%d %d\n",max,min);




    }
}
