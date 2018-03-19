import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by priyanka on 2/11/17.
 */
public class FunnySubarray {

    public static void main(String[] args) {
        Integer x=4000;
        Integer y =4000;
        if(x==y){
            System.out.println("same");
        }
        if(x!=y){
            System.out.println("not same");
        }

    }
}
//
//    int profit(int be, int en) {
//        if (be > en)
//            return 0;
//
//        return max(
//                profit(be+1, en) + year * p[be],
//                profit(be, en-1) + year * p[en]);
//    }
//int a[]=new int[m];
//        for(int i=0;i<m;i++){
//        a[i]=s.nextInt();
//    }
//    int max=0;
//    int bi=0,ei=m-1,i=0;
//        while(i<n){
//        if(a[bi]>a[ei]){
//            max=max+a[bi];
//            bi++;
//        }
//        else{
//            max=max+a[ei];
//            ei--;
//        }
//        i++;
//    }
//        System.out.println(max);
//}
