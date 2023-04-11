package Linear;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> s = new SequenceList<>(20);
        s.insert("吕布");
        s.insert("关于");
        s.insetInIndex("张飞",1);
        for(String s1 : s){
            System.out.println(s1);
        }
    }
}
