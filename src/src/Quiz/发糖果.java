package Quiz;

import java.util.Scanner;

public class 发糖果 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int S = 0;
        int n = 0;
        for(int i = 1;;i++){
            if(S == m){
                n = i - 2;
                S -= (i-1);
                break;
            }else if(S > m){
                n = i - 1;
                S -= (i-1);
                break;
            }
            S += i;

        }
        System.out.printf("%d %d\n",n,S);


    }
}
