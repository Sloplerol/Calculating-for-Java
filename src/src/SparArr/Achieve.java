package SparArr;

import java.io.Serializable;

public class Achieve {
    public String str = "zjj";
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        //0代表没有棋子
        //1代表白色棋子
        //2代表黑色棋子
        arr[2][3] = 1;
        arr[3][4] = 2;
        int sum = 0;
        //构建二维数组 并且查找非0元素
        for(int[] line : arr){
            for(int data : line){
                System.out.printf("%d\t",data);
                if(data != 0){
                    sum++;
                }
            }
            System.out.println();
        }

        System.out.println("sum:" + sum);

        int[][] SparArr = Spar.toSparArr(arr,sum);

        System.out.println();

        for(int[] spar : SparArr){
            for(int s : spar){
                System.out.printf("%d\t",s);
            }
            System.out.println();
        }

        int[][] orginArr = new int[SparArr[0][0]][SparArr[0][1]];
        //遍历稀疏数组从第二行开始
        for(int i = 1;i<SparArr.length;i++){
            orginArr[SparArr[i][0]][SparArr[i][1]] = SparArr[i][2];
        }

        for(int[] origin : orginArr){
            for(int i : origin){
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }



    }



}

class Spar implements Serializable{
    public static int[][] toSparArr(int[][] arr,int sum){
        //创建稀疏数组
        int SparArr[][] = new int[sum+1][3];
        SparArr[0][0] = 11;
        SparArr[0][1] = 11;
        SparArr[0][2] = sum;
        //count用来记录非0数据
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                if(arr[i][j] != 0){
                    count++;
                    SparArr[count][0] = i;
                    SparArr[count][1] = j;
                    SparArr[count][2] = arr[i][j];
                }
            }
        }
        return SparArr;
    }


}
