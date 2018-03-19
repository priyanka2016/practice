import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by priyanka on 1/9/17.
 */
public class Demo {

    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();

            long l = s.nextLong();
            long r = s.nextLong();
            int z = s.nextInt();
            boolean d[] = new boolean[10];

            while (z > 0) {
                int k = s.nextInt();

                z--;
                d[k] = true;

            }


            int count = 0;

            long start=l%p!=0?l+(p-(l%p)):l;

            for (long t = start; t <= r; t  = t + p) {

                long j = t;
                while (j != 0) {
                    long k = j%10;

                    if (d[(int)k]) {
                        j = j / 10;
                    } else {
                        break;
                    }

                }
                if (j == 0) {
                    count++;
                }
                System.out.println(count);
            }
            System.out.println(count);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}