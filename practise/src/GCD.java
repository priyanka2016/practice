import java.util.Scanner;

/**
 * Created by priyanka on 22/4/17.
 */
public class GCD {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int num1 = s.nextInt();
        int num2 = s.nextInt();

        if(num1<num2){
            int i=2;
            while(i<num1){
                if(num2%num1==0){
                    break;
                }
                else{
                    if(num1%i==0){
                        num1 = num1/i;
                    }else{
                        i++;
                    }
                }
            }
            if (num2%num1==0){
                System.out.println(num1);
            }
            else{
                System.out.println(1);
            }
        }
    }
}
