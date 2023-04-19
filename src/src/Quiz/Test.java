package Quiz;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = scanner.nextInt();
        int day = scanner.nextInt();
        int week = day / 7;
        int extraDay = day % 7;
        int mile = week * 5 * 250;
        for(int i = 0;i < extraDay;i++){
            if(begin == 7){
                begin = 0;
            }
            if(begin < 6){
                mile += 250;
            }

            begin++;
        }
        System.out.println(mile);

    }








}
