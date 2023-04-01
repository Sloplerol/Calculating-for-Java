### 数据结构

- [x] 栈的实现

    * 设置初始容量，数组，栈针
    * 压栈，弹栈
    * 判断是否回文
    * 能计算简单的字符串运算

- [ ] 稀疏数组

    * 为什么要使用稀疏数组

        `通过稀疏数组我们可以过滤掉很多没有作用的数据，筛选出二维数组里面有数据的数再构建成一个新的二维数组`

    * 二维数组转化稀疏数组的实现思路

        * 通过遍历二维数组来获取数据的多少
        * 创建一个二维数组SparArr\[num + 1][3]
        * 将二维数组的数据存放到稀疏数组里面

    * 稀疏数组转化为二维数组的思路

        * 通过row 和 line的值初始化一个二维数组
        * 然后读取稀疏数组后面的数据将指定的下标和值填写再二维数组中

        - [ ] Java附加：通过序列化和反序列化将计算出来的稀疏数组存储到硬盘中

- [ ] 队列

    * 简单介绍

        `队列和栈相反，队列遵循先进先出，后进后出的原则`

    * 实现思路

        * 定义数组的最大长度

        * 初始化队列数组的容量
        * 设置front和rear 分别代表头和尾 并且值都是-1
        * 当用户添加数据时rear + 1 
        * 当用户拿出数据时front + 1
        * 当rear + 1 == maxSize 时容器满
        * 当rear == front容器为空

    * 环形队列思路

        * front和rear初始值设置为0
        * 当队列数组满的时候rear和尾预留出一个空间
        * 队列数组满的条件 (rear + 1) % maxSize == front
        * 有效数据的个数为(rear + maxSize - front) % maxSize
        * 

- [ ] 

- [ ] 

- [ ] 

- [ ] 

- [ ] 

- [ ] 

    

    
