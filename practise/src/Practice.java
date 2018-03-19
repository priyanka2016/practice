import com.sun.org.apache.xpath.internal.SourceTree;

import javax.naming.LimitExceededException;
import java.util.Arrays;
import java.util.HashMap;
import java.math.*;
import java.util.Scanner;

/**
 * Created by priyanka on 26/9/17.
 */
public class Practice {

    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);
        int p = s.nextInt();
        int m = s.nextInt();
        int a[] = new int[p];
        for(int i=0;i<p;i++){
            a[i] = (int)(s.nextLong()%m);
        }
        for(int i=0;i<p;i++){
            System.out.println(a[i]);
        }
        System.out.print("ans"+countTrio(a,m));

    }

    private static int countTrio(int[] a, int m) {
        int c =0,z=0;
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                z++;
            }
            else{
                break;
            }
        }
        for(int i=0;i<a.length-2;i++){
            int l=i+1,r=a.length-1;
            while(l<r){
                int k = a[i]+a[l]+a[r];
                if(k==m){
                    c++;
                    if(l+1!=r && a[l]==a[l+1]){
                        c++;
                    }
                    if(r-1!=l && a[r]==a[r-1]){
                        c++;
                    }
                    l++;
                    r--;
                }
                else if(k<m){
                    l++;
                }else{
                    r--;
                }
            }

        }
        return c;
    }

}