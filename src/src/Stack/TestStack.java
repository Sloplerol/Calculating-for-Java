package Stack;

public class TestStack {
    public static void main(String[] args) {
        System.out.println(IntoData("aba"));
    }


    //判断字符串是否为回文
    public static boolean IntoData(String str){
        StackAchieve stackAchieve = new StackAchieve(10);

        //将传入的字符压入到数组中
        for(int i = 0;i<str.length();i++){
            stackAchieve.put(str.charAt(i));
        }
        String newVal = "";
        //由于每一次stackTop都会-- 所以我们需要拿到一个固定的值
        int lt = stackAchieve.length();
        for(int i = 0;i<lt;i++){
            if(!stackAchieve.isEmpty()){
                char pop = (char)stackAchieve.pop();
                newVal += pop;
            }
        }
        //字符串判断是否相等需要调用equals方法
        return newVal.equals(str);

    }
}
