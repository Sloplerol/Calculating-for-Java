package Search;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0;i < arr.length;i++){
            arr[i] = i + 1;
        }
        int res = insertSea(arr,0,arr.length - 1,78);
        System.out.println(res);

    }

    public static int insertSea(int[] arr,int left,int right,int value){
        System.out.println("插值查找次数");
        //判断第一位大于value和最后一位小于value必须有 否则当value值过大或者过小就会出现越界的情况
        if(left > right || arr[0] > value || arr[arr.length - 1] < value){
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if(midValue < value){
            return insertSea(arr,mid + 1,right,value);
        }else if(midValue > value){
            return insertSea(arr,left,mid - 1,value);
        }else {
            return mid;
        }
    }
}
