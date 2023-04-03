OJ   java

1013

```
import java.io.EOFException;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int maxlength = 0;
            int cyclelength;
            for(int h = Math.min(i,j);h<Math.max(i,j);h++){
                cyclelength = getCycleLength(h);
                if(cyclelength > maxlength){
                    maxlength = cyclelength;
                }
            }
            System.out.printf("%d %d %d\n",i,j,maxlength);
        }

    }
    //方法独立出来写
    public static int getCycleLength(int n){
        //传入的n就算是一次周期
        int cyclelength = 1;
        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
            }else {
                n = n * 3 + 1;
            }
            cyclelength++;
        }
        return cyclelength;
    }


}
```

