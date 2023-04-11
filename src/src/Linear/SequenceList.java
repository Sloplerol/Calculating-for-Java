package Linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    //存储元素的数组
    private T[] eles;

    //定义元素的个数
    private int N;

    public SequenceList(int capacity){
        this.eles = (T[])new Object[capacity];

        this.N = 0;
    }

    public int getLength(){
        return this.N;
    }

    public T get(int i){
        return eles[i];
    }

    public void clear(){
        this.N = 0;
    }

    public boolean isEmpty(){
        return this.N == 0;
    }

    public void insert(T t){
        if(N == eles.length){
            resize(2 * eles.length);
        }
        eles[N++] = t;
    }

    public void insetInIndex(T t,int i){
        if(N == eles.length){
            resize(2 * eles.length);
        }

        //将从指定下标开始的元素都向后移动一位
        for(int j = N;j > i;j--){
            eles[j] = eles[j - 1];
        }
        //最后插入需要出入的t
        eles[i] = t;
        N++;
    }

    public T remove(int i){
        T current = eles[i];
        //当移除元素的时候需要向前进行移动
        for(int j = i;j < N - 1;j++){
            eles[j] = eles[j + 1];
        }
        N--;
        if(N < eles.length / 4){
            resize(eles.length / 2);
        }

        return current;
    }

    //查找元素第一次出现的位置
    public int indexOf(T t){
        for(int i = 0;i < N;i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }
    //对原数组进行扩容操作
    public void resize(int newSize){
        T[] temp = eles;
        eles = (T[])new Object[newSize];
        for(int i = 0;i < N;i++){
            eles[i] = temp[i];
        }
    }



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




}
