package Search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {5,2,4};
        System.out.println(LineSearch(arr,2));
    }

    public static int LineSearch(int[] arr,int value){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
