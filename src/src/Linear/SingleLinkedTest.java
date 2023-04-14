package Linear;

public class SingleLinkedTest {
    public static void main(String[] args) {
        SingleLinked<String> s = new SingleLinked<>();
        s.insert("hello");
        s.insert("world");
        s.insetInIndex(1,"nonono");
        System.out.println(s.get(1));
        s.remove(1);
        System.out.println( s.get(1));
        for(String str : s){
            System.out.println(str);
        }
        s.reverse();
        for(String str : s){
            System.out.println(str);
        }


    }
}
