import java.util.Scanner;

/**
 * Created by priyanka on 20/11/17.
 */


public class MaxXOR {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l=s.nextInt();

        int r=s.nextInt();
        int max =0;
        for(int i=l;i<=r;i++){
            for(int j=l;j<=r;j++){
                if((i^j)>max){
                    max=i^j;
                }
            }

        }
        System.out.println(max);
    }
}
