import static com.sun.xml.internal.ws.util.VersionUtil.compare;

public class WildCard {

    public static void main(String[] args) {
        String s1 = "g*ks";

        String s2 = "geeks";

        System.out.println(compare1(s1,s2));


    }

    private static boolean compare1(String s1, String s2) {
        int i=0,j=0;
        while(j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else if(s1.charAt(i)=='?'){
                i++;
                j++;
            }else if(s1.charAt(i)=='*'){

            }else{
                return false;
            }
        }
        return false;

    }
}