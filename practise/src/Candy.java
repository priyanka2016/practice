import java.util.Scanner;

/**
 * Created by priyanka on 16/11/17.
 */

public class Candy {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt(),k=s.nextInt();
        int min =0,s1=0;
        int a[] = new int[l];
        for(int i=0;i<l;i++){
            a[i]=s.nextInt();
        }
        int i=0;
        while(a[i]!=1){
            i++;
        }
        min =i+k;
        i++;
        while(a[i]!=1){
            i++;
            min=min+k;
        }
        s1=i+k;
        i++;
        while(i<l){
          if(a[i]==1){
              if(min>s1){
                  min=s1;
              }
              s1=i+k;
          }else {
              s1 = s1 + k;

          }
          i++;
        }
        System.out.println(min);
    }
}
