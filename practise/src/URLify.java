import java.util.Scanner;

/**
 * Created by priyanka on 19/6/17.
 */
public class URLify {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        URLify urLify = new URLify();
        urLify.findMMI_fermat(7,11);


    }

    public long fast_pow(long base,long n,long M)
    {
        if(n==0)
            return 1;
        if(n==1)
            return base;

     long halfn=fast_pow(base,n/2,M);
        System.out.println(halfn);
        if(n%2==0)
            return ( halfn * halfn ) % M;
        else
            return ( ( ( halfn * halfn ) % M ) * base ) % M;
    }


    public int findMMI_fermat(int n,int M)
    {

        return (int) fast_pow(n,M-2,M);
    }

}
