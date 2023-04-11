

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

* 思路

    `一个for循环来解决，里面的变量代表了结束的位置right，left设置为0，先去从0开始遍历发现sum值如果大于目标值，通过循环来移动left判断减left是否满足条件，从而达到连续数组缩减长度的效果`

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

### 移除链表元素

* 思路

    `第一种可能：头信息里值是否和需要删除的值相等`

    `第二种可能：头信息里没有目标值，再去从head.next开始遍历，如果遍历到这个值的话，head.next = head.next.next`

- [ ] 单向链表实现

    ```
    public ListNode removeElements(ListNode head, int val) {
            //当头节点里的信息的值为val
            while (head != null && head.val == val) {
                head = head.next;
            }
            // 已经为null，提前退出
            if (head == null) {
                return head;
            }
            ListNode pre = head;
            ListNode cur = head.next;
            while(cur != null){
                if(cur.val == val){
                    pre.next = cur.next;
                }else {
                    pre = cur;
                }
                cur = cur.next;
            }
            return head;
            
            
            
        }
    ```

- [ ] 虚拟头节点来解决(统一规则，不需要判断删除的是否是头节点)

    ```
    public ListNode removeElements(ListNode head, int val) {
            if(head == null){
                return head;
            }
            //设置虚拟头节点
            ListNode dummys = new ListNode(-1,head);
            ListNode pre = dummys;
            ListNode cur = head;
            while(cur != null){
                if(cur.val == val){
                    pre.next = cur.next;
                }else {
                    pre = cur;
                }
                cur = cur.next;
                
            }
            //可以之前头节点的元素已经被删除
            return dummys.next;
            
            
            
        }
    ```

### 反转链表

* 双指针

    `定义一个cur指针指向的是当前所处的节点，再定义一个pre指向cur的前一个节点，然后cur，和pre两个指针后移，知道cur等于空为止，此时取pre作为新链表的头节点`

- [ ] 代码

    ```
    public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            //当cur等于null的时候 pre充当新链表的头节点
            return pre;
            
        }
    ```

* 递归解决

    `思路和双指针一样通过递归可以不用重写后移操作`

- [ ] 代码

    ```
    public ListNode reverseList(ListNode head) {
        
            return reverse(null,head);
            
        }
    
        private ListNode reverse(ListNode pre,ListNode cur){
            if(cur == null){
                return pre;
            }
            //保存一下下一个节点
            ListNode next = cur.next;
            //改变方向
            cur.next = pre;
    
            return reverse(cur,next);
        }
    ```

### 两两交换链表中的元素

* 思路

    `创建虚拟头节点，通过虚拟头节点来操作下两个元素，再将cur定位到下两个元素的前面`

- [ ] 代码

    ```
    public ListNode swapPairs(ListNode head) {
            ListNode dumyhead = new ListNode(-1);
            dumyhead.next = head;
            ListNode cur = dumyhead;
            //奇数和偶数的两种情况
            while(cur.next != null && cur.next.next != null){
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                ListNode temp1 = cur.next.next;
                cur.next.next = temp;
                temp.next = temp1;
                //首先通过虚拟头节点操作12 再通过3的前一位再来操作34
                cur = cur.next.next;
            }
            return dumyhead.next;
            
        }
    ```

### 删除倒数第n个节点

* 思路

    `可以定义快慢指针来解决，快指针用来提前移动(这一步一定要定好，保证最后慢指针指向的是倒数n个节点的前一个)，然后再让快慢指针同时移动，知道fast==null的时候停止，然后通过slow来删除他的下一位节点`

- [ ] 代码

    ```
    public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dumphead = new ListNode(0);
            dumphead.next = head;
            ListNode fast = dumphead;
            ListNode slow = dumphead;
            //先让fast指针进行后移操作
            for(int i = 0;i < n;i++){
                fast = fast.next;
            }
    
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dumphead.next;
            
            
            
        }
    ```

### 环形链表

* 思路

    `因为这道题可以构建环，于是可以通过快慢指针来判断是否有环，接着判断相遇的可能，通过算数计算可以得到head和相遇点到入环点的距离相同，计算出最后的结果`

- [ ] 代码

    ```
    public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            //判断是否有环
            while(fast != null && fast.next != null){
                //定义快慢指针
                slow = slow.next;
                fast = fast.next.next;
                //通过相遇点来计算出索引节点的长度
                if(slow == fast){
                    ListNode index1 = fast;
                    ListNode index2 = head;
                    while(index1 != index2){
                        index1 = index1.next;
                        index2 = index2.next;
                    }
                    return index1;
                }
            }
            return null;
        }
    ```

### 设计链表

- [ ] 代码

    ```
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        
        ListNode(int val){
            this.val = val;
        }
    }
    
    class MyLinkedList {
        //定义链表的长度
        int size = 0;
        //定义虚拟头节点
        ListNode head;
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }
        
        public int get(int index) {
            if(index < 0 || size <= index){
                return -1;
            }
            //遍历链表
            ListNode currentNode = head;
            for(int i = 0;i<=index;i++){
                currentNode = currentNode.next;
            }
            return currentNode.val;
        }
        
        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            newNode.next = head.next;
            head.next = newNode;
            size++;
        }
        
        public void addAtTail(int val) {
            ListNode pre = head;
            ListNode newNode = new ListNode(val);
            while(pre.next != null){
                pre = pre.next;
            }
            size++;
            newNode.next = pre.next;
            pre.next = newNode;
            
            
            
        }
        
        public void addAtIndex(int index, int val) {
    
            if(index > size){
                return;
            }
    
            if(index < 0){
                index = 0;
            }
            size++;
            
            ListNode prev = head;
            ListNode newNode = new ListNode(val);
            for(int i = 0;i<index;i++){
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
            
            
        }
        
        public void deleteAtIndex(int index) {
            if(index >= size || index < 0){
                return;
            }
            size--;
            //如果要删除的是头节点那么直接head后移
            if(index == 0){
                head = head.next;
                return;
            }
            
            ListNode prev = head;
            
            for(int i = 0;i < index;i++){
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }
    ```

# 哈希表

### 有效的字母异位词

* 思路

    `由于字母之间ASCII的值都是连续的所以可以创建一个26位的数组，让每一位的ASCII值都-a的ASCII值，从而每个字母有与之对应的下角标，遍历第一个字符串，将每一个值的个数++，遍历第二个字符串，每一个值对应的个数--，判断最后是否数组都是0`

- [ ] 代码

    ```
    char[] arr1 = s.toCharArray();
            char[] arr2 = t.toCharArray();
            int[] arr = new int[26];
    
            for(int i = 0;i < arr1.length;i++){
                arr[arr1[i] - 'a']++;
            }
    
            for(int j = 0;j < arr2.length;j++){
                arr[arr2[j] - 'a']--;
            }
    
            for(int data : arr){
                if(data != 0){
                    return false;
                }
            }
            return true;
    ```

### 两个数组的交集

* 思路

    `可以将数组里的所有元素添加到HashSet集合中，在此集合中元素不能重复，通过集合的contains方法判断另一个数组中是否有这个元素，如果有将它添加到另一个Set集合中最后通过`

- [ ] 代码

    ```
    public int[] intersection(int[] nums1, int[] nums2) {
            //判断集合不可能存在的情况
            if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
                return new int[0];
            }
            //设置哈希表
            Set<Integer> set = new HashSet<>();
            for(int i : nums1){
                set.add(i);
            }
            Set<Integer> newset = new HashSet<>();
            //用nums2进行比对
            for(int i = 0;i<nums2.length;i++){
                if(set.contains(nums2[i])){
                    newset.add(nums2[i]);
                }
            }
    
            //将set转化为数组
            int[] newarr = new int[newset.size()];
            int index = 0;
            for(int data : newset){
                newarr[index++] = data;
            }
    
            return newarr;
            
        }
    ```

**在这里比较重要的就是数组去重操作，这里通过定义Set集合来解决的, 最后需要将set集合转化成int类型的数组，set转化为数组可以借助set.toArray(空数组),这个空数组的长度必须等于set集合的长度**

### 两数之和

* 思路

    `由于是在数组中查找两个元素，可以想到用集合中的map来解决，通过判断map里面是否有另一半来解决`

- [ ] 代码

    ```
    public int[] twoSum(int[] nums, int target) {
            int[] arr = new int[2];
            //判断数组是否为空
            if(nums == null || nums.length == 0){
                return arr;
            }
            //创建map集合
            Map<Integer,Integer> map = new HashMap<>();
            //遍历nums如果有与之对应的值就将其取出否则就存入到map集合中
            for(int i = 0;i<nums.length;i++){
                int temp = target - nums[i];
                if(map.containsKey(temp)){
                    arr[0] = map.get(temp);
                    arr[1] = i;
                }
                
                map.put(nums[i],i);
            }
            return arr;
            
        }
    ```

### 四数相加

* 思路

    `首先将四个数组拆分为2 2的数组，减少时间复杂度，然后将一对数组的value值相加，作为Map的key值，value值对应的是你出现的次数，然后计算另外一对数组的值，map里查找如果发现有-key值那么统计此次的次数加到count上`

- [ ] 代码

    ```
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            //由于题里给定的条件是数组不能为空所以无需判断
            Map<Integer,Integer> map = new HashMap<>();
            //通过哈希映射的方式为每个结果key++
            int temp = 0;
            for(int i : nums1){
                for(int j : nums2){
                    temp = i + j;
                    if(map.containsKey(temp)){
                        map.put(temp,map.get(temp)+1);
                    }else {
                        map.put(temp,1);
                    }
                }
            }
            int target = 0;
            int count = 0;
            for(int i : nums3){
                for(int j : nums4){
                    target = 0 - (i + j); 
                    if(map.containsKey(target)){
                        count += map.get(target);
                    }
                }
            }
            return count;
        }
    ```

### 三数之和

* 思路

    `双指针，遍历数组，第一个数充当i，left作为i + 1 ，right作为length  - 1,两个指针不断向中间靠拢,i left和right都需要去重`

- [ ] 代码

    ```
    public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                if(nums[0] > 0){
                    return result;
                }
    
                if(i > 0 && nums[i] == nums[i-1]){
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while(right > left){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum < 0){
                        left++;
                    }else if(sum > 0){
                        right--;
                    }else {
                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while(right > left && nums[right] == nums[right - 1]){
                            right--;
                        }
    
                        while(right > left && nums[left] == nums[left + 1]){
                            left++;
                        }
    
                        right--;
                        left++;
                    }
                }
            }
            return result;
            
        }
    ```

### 四数之和

* 思路

    `和三数之和一样外层再套一个for循环，额外的操作：判断不可能的情况，这次不是直接让nums[i] > target了，因为两个负数加起来可能还是负数`

- [ ] 代码

    ```
    public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                if(nums[i] > 0 && nums[i] > target){
                    return result;
                }
                if(i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                for(int j = i + 1;j<nums.length;j++){
                    if(j > i + 1 && nums[j] == nums[j - 1]){
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while(right > left){
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if(sum > target){
                            right--;
                        }else if(sum < target){
                            left++;
                        }else {
                            result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                            while(right > left && nums[right] == nums[right - 1]) right--;
                            while(right > left && nums[left] == nums[left + 1]) left++;
                            right--;
                            left++;
                        }
                    }
                }
            }
            return result;
        }
    ```

# 字符串

### 反转字符II

* 思路

    `由于题比较复杂，反转操作需要借助库里的方法，于是需要StringBuffer里的reverse方法用来反转2k元素的前k个元素，然后搭配substring截取字符串来解决这道问题`

- [ ] 代码

    ```
    public String reverseStr(String s, int k) {
            //由于不想手动写reverse这个方法直接借助StringBuffer的reverse方法
            StringBuffer res = new StringBuffer();
            int start = 0;
            int length = s.length();
            while(start < length){
                StringBuffer temp = new StringBuffer();
                
                int firstK = start + k > length ? length : start + k;
                int secondK = start + 2 * k > length ? length : start + 2 * k;
                temp.append(s.substring(start,firstK));
                res.append(temp.reverse());
                
                if(firstK < secondK){
                    res.append(s.substring(firstK,secondK));
                }
                start += 2 * k;
            }
            return res.toString();
        }
    ```

### 反转字母

* 思路

    `反转原字符串，再将字符串的每一个单词进行反转`

- [ ] 代码

    ```
    
    ```

### KMP算法

* 参考[此文章](https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)

### 重复的子字符串

* 暴力算法
* KMP算法





















