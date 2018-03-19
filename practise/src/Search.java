import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by priyanka on 11/11/17.
 */
public class Search {

    public static void main(String[] args) {
        int a[]={6,7,8};
        System.out.println(binarySearch(a));
    }

    private static int findMinRotated(int a[]){
        int min = a[0];
        for(int i=1;i<a.length;i++){
            System.out.println(i);
            if(a[i]<a[i-1]){
                min = a[i];
                break;
            }
        }
        return min;
    }

    private static int binarySearch(int a[]){
        int l =0,h=a.length-1;
        while(l<=h){

            if (h == l) return a[l];

            int m =(l+h)/2;
            if (m < h && a[m+1] < a[m])
                return a[m+1];


            if (m > l && a[m] < a[m - 1])
                return a[m];
            else if(a[m]<a[h]){
               h=m-1;
            }else{
               l=m+1;
            }
        }
        return a[0];

    }
    private static int minUnit(String s1) {
        String s2 =s1.toLowerCase();
        char a[] = s2.toCharArray();
        Arrays.sort(a);
        int bi=0;
        int ei=a.length%2==0?a.length-1:a.length-2;
        int min=0;
        while(bi<ei){
            while(bi<=a.length-1&&bi+1<=a.length-1&& a[bi]==a[bi+1]){
                bi=bi+2;
            }
            while(ei>=0&&ei-1>=0&&a[ei]==a[ei-1]){
                ei=ei-2;
            }
            if(bi<ei) {
                min = min + a[bi] - 'a' + 1;
                bi++;
                ei--;
            }
        }
        return min;
    }
}
