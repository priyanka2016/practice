import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeMath.min;

public class SubString {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        int q = s.nextInt();
        while(q--!=0){
            int q1 = s.nextInt();
            if(q1==2){
                int l = s.nextInt();
                int r = s.nextInt();
                int p = s.nextInt();
                System.out.println(min1(a,l,r,p));
            }else if(q1==1){
                int u = s.nextInt();
                int p = s.nextInt();
                a[u-1] =p;
            }
        }
    }

    private static int min1(int[] a, int l, int r, int p) {
        int min =-1;
        for(int i = l-1;i<r;i++){
            if(a[i]>p) {
                if (min == -1) {
                    min = a[i];
                }else if(a[i]<min){
                    min =a[i];
                }
            }
        }
        return min;
    }
}