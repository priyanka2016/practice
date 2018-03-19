import java.util.Scanner;

/**
 * Created by priyanka on 23/4/17.
 */
public class UniqueCharacterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char p[] = s.toCharArray();
        boolean check[] = new boolean[256];

        if(s.length()>256){
            System.out.println("not unique");
        }else{
            int i;
            for(i=0;i<s.length();i++){
                if(!check[p[i]]){
                    check[p[i]]= true;
                }
                else{
                    System.out.println("not unique");
                    break;
                }
            }
            if(i==s.length()){
                System.out.println("unique");
            }
        }
    }
}
