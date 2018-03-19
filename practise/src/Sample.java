import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by priyanka on 20/11/17.
 */
public class Sample {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            int a[] = new int[n];
            long count =-1;
            int k = s.nextInt();
            a[0]=k;
            int small=k;
            for(int j=1;j<n;j++){
                long min=-1;
                int l =s.nextInt();
                if(small>l){
                    small =l;
                    min=-1;
                }else {
                    min = min(a, l, j);
                }
                a[j]=l;
                count=count+min;
//                int m =searchIndex(a,l,0,j-1);
//                int add= m==0?-1:a[m-1];
//                count = count + add;
//                for(int f=j;f>m;f--){
//                    a[f]=a[f-1];
//                }
//                a[m]=l;
            }
            System.out.println(count);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
        }

    }

    private static long min(int[] arr,int x,int j){
        long min=0;
        for(int i=0;i<j;i++){
            if(min<arr[i]&&x>arr[i]){
                min=arr[i];
            }
        }
        if(min==0){
            return -1;
        }
        return min;
    }
    private static int searchIndex(int[] arr, int x, int low,int high) {
        int mid;
        while( low < high ) {
            mid = ( high + low ) / 2;
            if( arr[mid]== x ) {
                break;
            }
            else if( arr[mid] > x ) {
                high=mid-1;
            }
            else {
                low= mid+1;
            }
        }
        mid = ( high + low ) / 2;
        if (x<=arr[mid])
            return mid;
        else
            return mid+1;

    }

    private static void reverse(char[] a, int x, int y) {

        for(int i=x-1,j=y-1;i<j;i++,j--){
            char temp = a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }

    private static long minOPer(int i, int k) {
        if(k==1){
            return 0;
        }

        if (i < k) {
            return k - i;
        } else {
            int j = i % k;
            return j < k - j ? j : k - j;
        }

    }

//    private static int subStringNbr(String next) {
//
//        HashMap<Character,Integer> characterIntegerHashMap= new HashMap<Character,Integer>(26);
//        int size =0;
//        int count =0,i=0,j=0;
//        char[] s = next.toCharArray();
//        while(j<=next.length()-26 && i<next.length())
//        while(i<next.length()) {
//            if (size == 26) {
//                count = count+ (next.length() - i);
//                int l = characterIntegerHashMap.get(s[j]);
//                if(l==1){
//                    size--;
//                    i++;
//                    characterIntegerHashMap.remove(s[j]);
//                }else{
//                    characterIntegerHashMap.replace(s[j],l-1);
//                    System.out.println("my name is priyanka khabiya my nam eis priyanka b=khabiya" +
//                            "");
//                }
//                j++;
//                break;
//            }
//            if (characterIntegerHashMap.containsKey(s[i])) {
//                int l = characterIntegerHashMap.get(s[i]);
//                characterIntegerHashMap.replace(s[i], l + 1);
//
//            } else {
//                size++;
//                characterIntegerHashMap.put(s[i], 1);
//                if(size==26){
//                    break;
//                }
//            }
//
//            i++;
//        }
//        return count;
//
//    }
//
//    public static void specialSubSeq(String[] s){
//
//
//
//
//    }
}
