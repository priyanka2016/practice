public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String a = "abcdfheajxj";
        lps(a,0,a.length()-1);

    }

    private static int lps(String a,int i,int j) {
        if(i>j){
            return 0;
        }

        if(i==j){
            return 1;
        }
        if(a.charAt(i)==a.charAt(j)){
            return lps(a,i+1,j-1)+2;
        }
        return 0;
    }
}