import java.util.*;

/**
 * Created by priyanka on 23/4/17.
 */
public class MyString {
    public static void main(String[] args) {
        MyString string = new MyString();

        Scanner s = new Scanner(System.in);
        String p = s.next();

        ArrayList<String> strings = string.splitString("geeks,geeks,for,pri",',');
        for(String k : strings){
            System.out.println(k);

        }
    }

    private ArrayList<String> splitString(String s, char delim){
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)!=delim){
                stringBuilder.append(s.charAt(i));
            }
            else{
                strings.add(stringBuilder.toString());
                stringBuilder=new StringBuilder();
            }
        }
        strings.add(stringBuilder.toString());
        return strings;
    }

    private void reverseRecurssion(String s,int i){
        if(i==s.length()){
            return;
        }
        i++;
        reverseRecurssion(s,i);
        System.out.print(s.charAt(i-1));

    }
    private String compress(String s){
        StringBuilder stringBuilder = new StringBuilder();
        int count =0;
        for(int i=0;i<s.length();i++){
            count++;
            if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1)) {
                stringBuilder.append(s.charAt(i));
                stringBuilder.append(count);
                count=0;
            }
        }
        return stringBuilder.length()==2*s.length()?s:stringBuilder.toString();
    }

    private boolean edit(String p,String j){
            boolean isEdit=true;
            int i=0,k=0;
            while(i<p.length()&&k<j.length()){
                if(p.charAt(i) != j.charAt(k) ){
                    if (isEdit) {
                        if (p.length() > j.length()) {
                            i++;
                        } else if(j.length()>p.length()){
                            k++;
                        }
                        else{
                            i++;k++;
                        }
                        isEdit = false;
                    }else {
                        return false;
                    }
                } else{
                    i++;
                    k++;
                }
            }
        return true;
    }

    private void palindromePermutation1(String s1){
        String s = s1.toLowerCase();
        HashMap<Character,Integer> h = new HashMap<Character,Integer>();
        for(int i =0 ;i<s.length();i++){
            if(h.containsKey(s.charAt(i))){
                Integer k = h.get(s.charAt(i));
                k++;
                h.replace(s.charAt(i),k);

            }
            else{
                h.put(s.charAt(i),1);
            }
        }
        boolean odd = false;
        Iterator it = h.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            char f = (char) entry.getKey();
            if(f != ' ') {
                int j = (int) entry.getValue();
                if(j%2==0){

                }
                else if (!odd) {
                    odd = true;
                } else {
                    break;
                }
            }
        }
        if(it.hasNext()){
            System.out.println("false");
        }
        else {
            System.out.println("true");
        }
    }


    private void palindromePermutation(String s){
        String  j =s.toLowerCase();
        char k[] = j.toCharArray();
        Arrays.sort(k);
        System.out.println("k " + new String(k));
        boolean odd = false;
        int i=0;
        for(i =0;i<k.length-1;i++){
            if(k[i] ==' '){

            }
            else if(k[i]== k[i+1]){
                i++;
            }
            else if(!odd){
                odd = true;
            }
            else{
               break;
            }
        }
        if(i>=k.length-1){
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }

    }

    private String reverseUsingByteArray(String s) {
        byte[] b = s.getBytes();
        for(int i =0,j=b.length-1; i<b.length/2 && j>=0;i++,j--){
            byte temp = b[i];
            b[i]=b[j];
            b[j]=temp;
        }
        return new String(b);
    }


    public void reverse(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        for(int i = 0,j= s.length()-1;i<s.length()/2 && j>0;i++,j--){
            char k = stringBuilder.charAt(i);

        }
    }

    public String reverseUsingCharArray(String s){
        char[] b = s.toCharArray();
        for(int i =0,j=b.length-1; i<b.length/2 && j>=0;i++,j--){
            char temp = b[i];
            b[i]=b[j];
            b[j]=temp;
        }
       return String.valueOf(b);
    }
    public boolean permutationBySorting(String one,String two){

        if(one.length()!=two.length()){
            return false;
        }
        char[] x = one.toCharArray();
        char[] y = two.toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);
        System.out.println(x);
        System.out.println(y);
        for(int i=0;i<one.length();i++){
            if(x[i]!=y[i]){
                return false;
            }
        }
        return true;
    }

    public boolean permutationByLetterCount(String one,String two){

        if(one.length()!=two.length()){
            return false;
        }
        int letter[] = new int[256];
        for(int i=0;i<one.length();i++){
           letter[one.charAt(i)]++;
        }

        for(int i=0;i<one.length();i++){
            letter[two.charAt(i)]--;
            if(letter[two.charAt(i)]<0){
                return false;
            }
        }

        return true;
    }

    public boolean palindrome(String one , String two){
        if(one.length() == two.length()){
            int i,j;
            for(i =0 ,j=one.length()-1;i<=(one.length()/2)&& j>=(one.length()/2);i++,j--){
                if(one.charAt(i) != two.charAt(j)){
                    break;
                }
            }
            if(i>j){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

}
