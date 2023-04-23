import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> twoDList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        innerList.add(2);
        twoDList.add(innerList);
        System.out.println(twoDList.get(0).get(0));



    }


}