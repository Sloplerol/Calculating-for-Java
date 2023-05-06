package Tree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.lastOrdered();
    }
}

class ArrayBinaryTree{
    private int[] arr;
    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }


    public void preOrdered(){
        this.preOrdered(0);
    }

    public void midOrdered(){
        this.midOrdered(0);
    }

    public void lastOrdered(){
        this.lastOrdered(0);
    }

    public void preOrdered(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空，无法进行遍历");
        }
        System.out.println(arr[index]);
        //向左进行递归
        if((index * 2 + 1) < arr.length){
            preOrdered(2 * index + 1);
        }

        if((index * 2 + 2) < arr.length){
            preOrdered(2 * index + 2);
        }

    }

    public void midOrdered(int index){
        if(arr == null || arr.length == 0) return;

        if((index * 2 + 1) < arr.length){
            midOrdered(index * 2 + 1);
        }

        System.out.println(arr[index]);

        if((index * 2 + 1) < arr.length){
            midOrdered(index * 2 + 2);
        }


    }

    public void lastOrdered(int index){
        if(arr == null || arr.length == 0) return;
        if(index * 2 + 1 < arr.length){
            lastOrdered(index * 2 + 1);
        }
        if(index * 2 + 2 < arr.length){
            lastOrdered(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }

}
