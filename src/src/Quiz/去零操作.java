package Quiz;

public class 去零操作 {
    public static void main(String[] args) {
        String str = "30000";
        String res = RemoveLastZero(str);
        System.out.println(res);
    }


    //去前面的0 0003 -> 3
    public static String RemoveFrontZero(String str){
        if("0".equals(str)) return "0";
        StringBuilder res = new StringBuilder(str);
        while(res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        return res.toString();
    }


    //去除后后面的0
    public static String RemoveLastZero(String str){
        if(str.equals("0")) return "0";
        StringBuilder res = new StringBuilder(str);
        while(res.charAt(res.length() - 1) == '0'){
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}
