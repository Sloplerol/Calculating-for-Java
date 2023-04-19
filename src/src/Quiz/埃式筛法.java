package Quiz;

import java.util.Arrays;

public class 埃式筛法 {
    public static void main(String[] args) {

        int res = countPrimes(10);
        System.out.println(res);
    }

    public static int countPrimes(int N){
        if(N == 0 || N == 1) return 0;
        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime,true);
        for(int i = 2;i < N;i++){
            //当为质数的时候
            if(isPrime[i]){
                int index = 2;
                for(int j = i;j * index < N;index++){
                    isPrime[j * index] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2;i < isPrime.length;i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
}







