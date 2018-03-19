import java.util.Scanner;

/**
 * Created by priyanka on 9/7/17.
 */
public class Urlify {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String p = s.nextLine();
        int length = s.nextInt();
        char[] f = p.toCharArray();
        int space =0;

        for(int i =0;i<length;i++){
            if(f[i]==' '){
                space++;
            }

        }
        shift(f,space);
//        for(int i =0;i<length;i++){
//            if(f[i] == ' '){
//                length = length +2;
//                shift(f,i,length);
//                f[i] = '%';
//                i++;
//                f[i] = '2';
//                i++;
//                f[i] = '0';
//            }
//
//        }
        System.out.println(new String(f));
    }

    private static void shift(char[] f, int i) {
        for(int j = f.length-1-i*2,k=f.length-1;j>=0&&k>=0;j--,k--){
            if(f[j] == ' '){
                f[k]= '0';
                k--;
                f[k]='2';
                k--;
                f[k]='%';

            }
            else{
                f[k] = f[j];
            }

        }
    }
}
