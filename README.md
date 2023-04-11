## 时间复杂度 O(n)

* 算法函数的常数可以忽略

* 算法函数幂指数前的常数项可以进行忽略

* 幂越小说明耗费的时间越少



## 排序

#### 冒泡排序

*  原理：俩俩比较，俩俩交换，最后将最大值放到最右边

* 俩俩比较大小使用compareTo方法
* 俩俩交换交换的是数组里的元素
* 最后排序进行实现

#### 选择排序

* 原理：每一个元素和他后面的所有元素进行比较并且将最小值放入到本位
* 注意：保留后面元素的最小值所对应的索引比较关键

#### 插入排序

* 原理：从下标为1开始遍历，每一个元素需要与前面的元素进行比较，如果小于前面的元素就需要进行交换位置

#### 希尔排序

* 原理：通过增长值进行多次插入排序

* 增长值的规则

    ```
    int h = 1;
    while(h < 5){
    	//计算出h的最大值
    	h = 2 * h + 1;
    }
    h的减小规则
    h /= 2;
    ```

* 时间复杂度比较低，效率高

#### 归并排序

* 原理

    `假如需要对0-5内的数据进行排序由于上一次的归并得到的0 - 2和3 - 5里的数据已经进行了排序，在这两处分别在头设置指针判断大小，将小的依次从头到尾放到辅助数组里，谁被放里面了谁的指针就进行移动，最后将这个辅助数组放回取代原来的数组`

#### 快速排序

* 原理

    `找一个排好序的分界点，对其两边进行排序，再去找分界点，重复以上操作，和归并排序非常的相似`

#### 排序的稳定性

* 如何定义一个排序是否稳定，当出现相同的值，如果进行了无意义的交换就是不稳定的，反之不交换就是稳定的
* 上述排序不稳定的有：选择排序，希尔排序，快速排序

## 线性表

#### 实现线性表

* 构建T类存储元素的数组作为线性表的主体
* 实现方法
    * get
    * getLength
    * Insert / InsetIndex
    * remove
    * clear
    * isEmpty

#### 遍历线性表

```
public Iterator<T> iterator(){
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private int cursor;
        public SIterator(){
            this.cursor = 0;
        }
        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }
```



#### 对于线性表的容积的改变

* 扩容

    ```
    public void resize(int newSize){
            T[] temp = eles;
            eles = (T[])new Object[newSize];
            for(int i = 0;i < N;i++){
                eles[i] = temp[i];
            }
        }
    ```

    









