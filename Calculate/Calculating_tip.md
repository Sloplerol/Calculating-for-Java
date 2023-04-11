## Scanner

**hasNextInt可以判断输入的下一个是否为整数**

```
当定义nextint如果输入的不是整数的话会抛出InputMismatchException异常这是后可以使用hasNextInt来做出条件判断
```



**nextLine读取字符串会讲字符串和特殊字符全部算进去**

```
nextLine缺点:在使用 scanner.nextInt() 读取整数后，输入缓冲区中通常会留下一个回车符 (newline character)。当你调用 scanner.nextLine() 时，它会读取输入缓冲区中的这个回车符，并将其解释为一个空行。
```

> 解决手段: 外部声明scanner.nextLine() 消耗掉回车符

**next只会读取纯字符串**

### 增强型循环forEach

**假如ascii : asciivalue ascii相当于是一个临时变量，用来存储asciivalue数组中的值，每一次循环将asciivalue下一个值赋值给ascii**

* 语法: for (int ascii : asciiValues)



### 常见题目简单算法

* 反转字符

    ```
    String str = scanner.nextLine();
    String reversedStr = new StringBuilder(str).reverse().toString();
    ```

* 判断回文数

    ```
    public static boolean isPalindrome(int num) {
            int reversed = 0;
            int original = num;
            while (num > 0) {
                int digit = num % 10;
                reversed = reversed * 10 + digit;
                num /= 10;
            }
            return original == reversed;
        }
    ```

* 通过回文数来实现数字反转

    * 简单算法

        ```
        Scanner sc=new Scanner(System.in);
                int n =sc.nextInt();
                int reverse = 0;
                int ipt = n;
                while(ipt!=0) {
                    //负数取余结果也是负数
                    reverse = reverse*10 + ipt%10;
                    ipt=ipt/10;
                }
                System.out.println(reverse);
        ```

    

* 判断一个数的最大乘数

    ```
    //可以通过最小乘数来判断
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int p = 2;
            while(n % p != 0){
                p++;
            }
            System.out.println(n / p);
    
        }
    
    ```

* 打印特殊三角形

    ```
        01
      0203
    040506
    //代码如下
    Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int fi = 1;
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    if(n - i + 1 > j){
                        System.out.print(" ");
                    }else {
                        if(fi < 10){
                            System.out.print("0" + fi);
                        }else {
                            System.out.print(fi);
                        }
                        fi++;
                    }
                }
                System.out.println();
            }
    ```

    

* 计算区间并集

    ```
    思路:
    初始化数组 默认情况下取值都是0
    可以将这些区间内的所有数字都设置为1
    最后遍历数组统计1有都少个
    ```

    

* 连续几个数的总和

    ```
    思路:
    最外层循环查找总共包含多少个n哥连续的可能
    内存循环查找的次数和连续的个数保持一致
    ```

* 蛇形矩阵

    ```
    由于数字是连续的可以设置一个count初始值为1，每一个方向推移时++count
    while(count<n*n){
    		//right
        while(arr[line][row + 1] == 0 && row + 1 < n){
            arr[line][++row] = ++count;
        }
        //down
        while(arr[line + 1][row] == 0 && line + 1 < n){
            arr[++line][row] = ++count;
        }
        //left
        while(row - 1 >= 0 && arr[line][row - 1] == 0 ){
            arr[line][--row] = ++count;
        }
        //up
        while(line - 1 >= 0 && arr[line - 1][row] == 0){
            arr[--line][row] = ++count;
        }
    }
    ```

    

* 杨辉三角形

    ```
    思路：
    创建二维数组的时候只设置行的初始值，在进入行循环的时候再去补列
    当列处于0和length-1的时候将值设置为1
    其余的等同于上面和左边的和
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] Yanghui = new int[n][];
        for(int i = 0;i<Yanghui.length;i++){
            Yanghui[i] = new int[i+1];
            for(int j = 0;j< Yanghui[i].length;j++){
                if(j == 0 || j == Yanghui[i].length - 1){
                    Yanghui[i][j] = 1;
                }else {
                    Yanghui[i][j] = Yanghui[i - 1][j - 1] + Yanghui[i - 1][j];
                }
                System.out.print(Yanghui[i][j] + " ");
            }
            System.out.println();
        }
    }
    ```

    

* 可以通过以下方式将Scanner输入的数字放入到数组中

    ```
    Scanner scanner = new Scanner(System.in);
    String[] input = scanner.nextLine().split(" ");sd
    int n = Integer.parseInt(input[0]);
    int[] nums = new int[input.length - 1];
    ```

    

* 判断公共前缀问题

    ```
    思路
    可以选择某一个先作为公共前缀
    while循环条件为是否每一个元素startsWith为公共前缀
    如果不能的话需要将公共前缀的长度进行截取 -1
    ```

    

* 数组去重

* sdf



### 算法注意点

* '0' + 某非字符串数字得到的是ASCII码的值
* 字符串转数字可以通过 - '0'的形式来实现 但是注意当你输出数字的时候需要再加上'0'

