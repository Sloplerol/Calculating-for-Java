package Linear;

public class TwoDirectionLinkedListTest {
    public static void main(String[] args) {
        TwoDirectionLinkedList<String> t = new TwoDirectionLinkedList<>();
        t.insert("Hello");
        t.insert("world");
        t.insert("hello");
        System.out.println(t.get(1));
    }
}
