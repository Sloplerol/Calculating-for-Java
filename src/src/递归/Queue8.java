package 递归;

public class Queue8 {
    //定义有多少个皇后
    int max = 8;
    //数组用来存放皇后放置的位置
    int[] arr = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue8 q = new Queue8();
        q.check(0);
        System.out.println(count);

    }
    //编写一个方法用来放置皇后
    private void check(int n){
        if(n == 8){
            print();
            return;
        }
        for(int i = 0;i < max;i++){
            arr[n] = i;

            if(judge(n)){
                //如果不冲突 往下一个行的第一列开始
                check(n + 1);
            }
        }
    }



    //用来判断皇后放置的位置是否与前面的位置冲突
    private boolean judge(int n){
        for(int i = 0;i < n;i++){
            //如果放入皇后的位置和前面放置皇后的列和对角线一样的话
            //对角线的原理
            if(arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])){
                return false;
            }
        }
        return true;
    }

    public void print(){
        count++;
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
