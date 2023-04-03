

# 数组篇

### 二分查找

- [ ] [left,right]解决

    ```
    int left = 0;
    int right = nums.length - 1;
    while(left <= right){
    		int middle = (left+right) / 2;
    		if(nums[middle] < target){
    				left = middle + 1;
    		}else if(nums[middle] > target){
    				right = middle - 1;
    		}else {
    				return middle;
    		}
    }
    return -1;
    ```

    

- [ ] [left,right) 解决

    ```
    int left = 0;
    int right = nums.length;
    while(left < right){
    		int middle = (left+right) / 2;
    		if(nums[middle] < target){
    				left = middle + 1;
    		}else if(nums[middle] > target){
    				right = middle;
    		}else {
    				return middle;
    		}
    }
    return -1;
    ```

### 移除元素

- [ ] 暴力方法

    **核心思路：需要两个for循环一个用来遍历数组的同时获取要删除的元素，另一个for循环从删除的元素的下一个元素开始前移，并且将第一个for的i和数组长度 - -**

    ```
    public int removeElement(int[] nums, int val) {
            int size = nums.length;
            for(int i = 0;i<nums.length;i++){
                if(nums[i] == val){
                    for(int j = i + 1;j<nums.length;j++){
                        nums[j - 1] = nums[j];
                    }
                    //由于元素前移所以i和长度都需要前移
                    i--;
                    size--;
                }
            }
            return size;
            
        }
    ```

- [ ] 双指针

    **核心思路：快指针用来获取新数组的元素，将值赋值给慢指针**

    ```
    public int removeElement(int[] nums, int val) {
            
            int slow = 0;
            for(int fast = 0;fast<nums.length;fast++){
                
                if(nums[fast] != val){
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            return slow;
            
        }
    ```

### 有序数组的平方

- [ ] 通过Arrays.sort排序替换原来的数组

    ```
    public int[] sortedSquares(int[] nums) {
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                ans[i] = nums[i] * nums[i];
            }
            Arrays.sort(ans);
            return ans;
        }
    ```

- [ ] 双指针

    ```
    public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] arr = new int[n];
            //i往后 j往前 pos用来将大的值放到后面
            for(int i = 0,j = n - 1,pos = n - 1;i <= j;){
                if(nums[i] * nums[i] > nums[j] * nums[j]){
                    arr[pos] = nums[i] * nums[i];
                    i++;
                }else {
                    arr[pos] = nums[j] * nums[j];
                    j--;
                }
                pos--;
            }
            return arr;
        }
    ```

### 滑动数组

* 暴力

* 思路: 一个for循环来解决，里面的变量代表了结束的位置right，left设置为0，先去从0开始遍历发现sum值如果大于目标值，通过循环来移动left判断减left是否满足条件，从而达到连续数组缩减长度的效果

- [ ] 暴力解法

    ```
    public static int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int minlength = 0;
            int sum = 0;
            //第一个for循环用来设置起始位置
            for(int i = 0;i<nums.length;i++){
                sum = 0;
                //第二个for循环用来设置终止位置
                for(int j = i;j<nums.length;j++){
                    sum += nums[j];
                    if(sum >= target){
                        minlength = j - i + 1;
                        result = Math.min(minlength,result);
                        break;
                    }
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    ```

- [ ] 滑动数组

    ```
    public int minSubArrayLen(int target, int[] nums) {
            //滑动窗口解决 通过一个for循环来解决这个循环代表的一定是结束的位置
            int left = 0;
            int result = Integer.MAX_VALUE;
            int sum = 0;
            for(int right = 0;right<nums.length;right++){
                sum += nums[right];
                while(sum >= target){
                    result = Math.min(result,right - left + 1);
                    sum -= nums[left++];
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
            
        }
    ```

### 螺旋矩阵

* 思路

    `首先需要判断n的奇偶，因为当n为奇数的时候需要给中间的位置单独取值，while循环的次数为loop的圈数，可以通过n / 2来判断执行的次数，然后就是环形四循环，要注意的是在第二圈向下x值要取好`

- [ ] 代码

    ```
    public int[][] generateMatrix(int n) {
            //需要判断螺旋矩阵的奇偶
            int start = 0;
            int count = 1;
            int nums[][] = new int[n][n];
            int loop = 0;
            int i = 0,j = 0;
            while(loop++ < n / 2){
                //左闭右开的原则 
                //j代表列 i代表行
                
                for(j = start;j<n - loop;j++){
                    nums[start][j] = count++;
                }
    
                for(i = start;i<n - loop;i++){
                    nums[i][j] = count++;
                }
                //由于此时的i j索引的位置位于二维数组的右下角
                for(;j >= loop;j--){
                    nums[i][j] = count++;
                }
    
                for(;i >= loop;i--){
                    nums[i][j] = count++;
                }
                start++;
    
                  
            }
            if(n % 2 == 1){
                nums[start][start] = count;
            }
            return nums;
            
    
            
            
        }
    ```

### P561 数组拆分

* 要求：将长度为2n的数组拆分成n份，每一份从2n数组选两个元素，并且将每一份的最小值相加，得到最后的结果
* 思路： 将数组进行排序，奇偶算一份，每次的最小值一定是奇数项，所以只需要将新数组的奇数项进行相加操作

- [ ] 代码实现

    ```
    public int arrayPairSum(int[] nums) {
            
            Arrays.sort(nums);
            int result = 0;
            for(int i = 0;i<nums.length;i+=2){
                result += nums[i];
            }
            return result;
    
        }
    ```

### P1929 数组串联

* 思路：可以通过创建一个新的二倍数组来进行填充，但是效率较低，如果使用Arrays.copyOf()，就不需要再去填充前面的元素了

- [ ] 代码实现

    ```
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] num = Arrays.copyOf(nums,nums.length * 2);
            for(int i = 0;i<nums.length;i++){
            		num[nums.length + i] = nums[i];
            }
            return num;
        }
    }
    
    ```

    















# 链表篇























