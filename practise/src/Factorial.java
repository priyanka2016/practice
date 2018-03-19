import java.util.Scanner;

/**
 * Created by priyanka on 2/9/17.
 */
public class Factorial {

    int a[] = new int[100000];

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Factorial f = new Factorial();
        int t = s.nextInt();

        while(t--!=0){
            System.out.println(f.fact(s.nextInt()));
        }

    }

    public long fact(int n){
        if(n==0){
            a[0]=1;
            return 1;
        }
        if(n==1){
            a[1]=1;
            return  1;
        }
        if(a[n]!=0){
            return a[n];
        }

        a[n] =  (int)((fact(n-1)*n)%1000000007);
        return a[n];

    }
}
