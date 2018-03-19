import java.util.HashSet;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t--!=0){
            HashSet<Character> characters = new HashSet<>();
            String s1 = s.next();
            for(int i =0;i<s1.length();i++){
                if(!characters.contains(s1.charAt(i))){
                    characters.add(s1.charAt(i));
                }
            }
            if(characters.size()%2==0){
                System.out.println("Player2");
            }else{
                System.out.println("Player1");
            }
        }
    }
}