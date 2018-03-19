import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by priyanka on 18/4/17.
 */
public class Acronym {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        ArrayList<String> s = new ArrayList<>();
        int j[] = new int[10];
        while(k-->0){
            s.add(scanner.next());
        }

        int length = scanner.nextInt();
        String sentence[] = new String[length];
        for(int i = 0; i<length;i++){
            sentence[i] = scanner.next();
        }

        int p =0;
        ArrayList<Character> finalString = new ArrayList<>();
        for(int i =0 ;i<length;i++){
            if(!s.contains(sentence[i])){
                finalString.add(sentence[i].toUpperCase().charAt(0));
                finalString.add('.');
                p=p+2;
            }
        }
        finalString.remove(p-1);
        for (Character u : finalString){

            System.out.print(u);
     }
    }
}
