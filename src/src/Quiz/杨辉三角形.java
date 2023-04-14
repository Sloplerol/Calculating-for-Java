package Quiz;

import java.util.Arrays;

public class 杨辉三角形 {
    public static void main(String[] args) {
        int[][] res = YanghuiAngular(5);
        for(int i = 0;i < res.length;i++){
            for(int j = 0;j < res[i].length;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] YanghuiAngular(int n){
        int[][] arr = new int[n][n];
        //处理每一行的第一个元素
        for(int i = 0;i < n;i++){
            arr[i][0] = 1;
        }
        //处理其他元素
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= i;j++){
                arr[i][j] = arr[i -1][j - 1] + arr[i - 1][j];
            }
        }

        return arr;
    }


}
