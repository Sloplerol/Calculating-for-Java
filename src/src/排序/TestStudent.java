package 排序;

public class TestStudent {
    public static void main(String[] args) {
        //通过comparable对对象进行排序
        Student s1 = new Student();
        s1.setUsername("zjj");
        s1.setAge(2);
        Student s2 = new Student();
        s2.setUsername("hello");
        s2.setAge(3);

        System.out.println(comparableAge(s1,s2));


    }

    public static Comparable comparableAge(Comparable s1,Comparable s2){
        int result = s1.compareTo(s2);
        if(result > 0){
            return s1;
        }else {
            return s2;
        }
    }
}
