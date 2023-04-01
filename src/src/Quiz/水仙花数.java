package Quiz;

public class 水仙花数 {
    public static void main(String[] args) {

        for(int i = 100;i<=1000;i++){
            String three = "" + i;
            int[] arr = new int[3];
            for(int j = 0;j < 3;j++){
                arr[j] = Integer.parseInt(Character.toString(three.charAt(j)));
            }
            int sum = 0;
            for(int k = 0;k<arr.length;k++){

                sum += arr[k] * arr[k] * arr[k];
            }
            if(sum == i){
                System.out.println(i);
            }
        }
    }
}
