import java.util.Scanner;

/**
 * Created by priyanka on 2/4/17.
 */
public class IPL {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num[] = new int[10];
        boolean numExist[] = new boolean[10];
        for(int i=0;i<n;i++){
           num[i] = scanner.nextInt();
           numExist[scanner.nextInt()]=true;
            n--;
        }
        int k = scanner.nextInt();

    }

    public int smallestNbrDivisibleBy3(int a[],int k,boolean numExist[]){
        int number=0;
        int j = k;

        if(a[0] == 0){
            number = a[1]* (10*k);
        }

        else{
            while(j>0) {
                number = number + a[1] * (10 * j);
                j--;
            }
        }
        while(k>0){
            if (number % 3 == 0) {
                return number;
            }
            else if(number%3==1){
                if(numExist[1]&&numExist[4]&&numExist[7]){

                }
            }else {

            }
        }
        return 0;
    }
}
