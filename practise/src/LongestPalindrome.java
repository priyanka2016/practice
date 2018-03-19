import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Created by priyanka on 22/4/17.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String k = scanner.next();

        char[] s = k.toCharArray();
        int[] count = new int[26];
        for(int i =0;i<k.length();i++){
           if(s[i]>='a' && s[i]<='z'){
               count[s[i]-'a']++;
           }
        }

        boolean odd = false;
        int oddValue=0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<26;i++){
           if(!odd && count[i]==1){
               odd = true;
               oddValue = i;
           }
            if(count[i]>=2){
                char j = (char) (i + 'a');

                int f = count[i]/2;
                while(f!=0){
                    System.out.print(j);
                    stringBuilder.append(j);
                    f--;
                  }
             }
        }
        if(odd){
            char j = (char) (oddValue + 'a');
            System.out.print(j);
        }
        stringBuilder.reverse();
        System.out.print(stringBuilder);
    }
}
