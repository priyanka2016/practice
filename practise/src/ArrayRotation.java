/**
 * Created by priyanka on 24/9/17.
 */
public class ArrayRotation {

    public static void main(String[] args) {
        int a[] ={1,2,3,4,5,6,7};
        int d =2;
        int i, j, k, temp;
        int n=a.length;
        for (i = 0; i < gcd(d, n); i++)
        {
            /* move i-th values of blocks */
            temp = a[i];
            j = i;
            while (1 != 0)
            {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                a[j] = a[k];
                j = k;
            }
            a[j] = temp;
        }

        printArray(a);
    }

    private static void printArray(int[] a) {
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    private static int gcd(int length, int d) {
        while(length%d!=0){
            int temp =length;
            length=d;
            d=temp%d;
        }
        return d;
    }
}
